package ru.itis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomTextPrefixUtilsImpl implements PrefixUtils {

    @Value("${prefix.utils.prefix}")
    private String prefix;

    @Autowired
    @Qualifier("messageRendererRed")
    private MessageRenderer renderer;

    @Override
    public void render(String message) {
        System.out.println(prefix);
        renderer.render(message);
    }
}
