package ru.itis.springboot.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from}")
    private String mailFrom;

    @SneakyThrows
    @Override
    public void sendEmail(String email, String subject, String text) {
        // создаем сообщение
        MimeMessage message = mailSender.createMimeMessage();
        // указываем, что содержимое сообщение - это html-ка
        message.setContent(text, "text/html");
        // создаем объект-обертку для удобной настройки сообщения
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        // указываем почту, на которую следует отправить сообщение
        messageHelper.setTo(email);
        // указываем тему сообщения
        messageHelper.setSubject(subject);
        // указываем текст сообщения
        messageHelper.setText(text, true);
        // указываем, от кого это сообщение
        messageHelper.setFrom(mailFrom);
        // отправляем сообщение
        mailSender.send(message);
    }
}
