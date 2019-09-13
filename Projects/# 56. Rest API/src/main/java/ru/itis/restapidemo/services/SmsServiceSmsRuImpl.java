package ru.itis.restapidemo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.restapidemo.dto.SmsResultDto;
import ru.itis.restapidemo.forms.SmsForm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SmsServiceSmsRuImpl implements SmsService {

    private Logger logger = LoggerFactory.getLogger(SmsServiceSmsRuImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${sms.ru.url}")
    private String smsUrl;

    @Value(("${sms.ru.api-key}"))
    private String smsApiKey;

    private ExecutorService service = Executors.newCachedThreadPool();

    @Override
    public SmsResultDto sendSms(SmsForm form) {

        String requestUrl = smsUrl + "?api_id=" + smsApiKey + "&to=" + form.getPhone()
                + "&msg=" + form.getText() + "&json=1";

        logger.info("Starting send sms to " + requestUrl + " ... ");

        service.submit(() -> restTemplate.getForEntity(requestUrl, String.class));

        return SmsResultDto.builder()
                .success(true)
                .build();
    }
}
