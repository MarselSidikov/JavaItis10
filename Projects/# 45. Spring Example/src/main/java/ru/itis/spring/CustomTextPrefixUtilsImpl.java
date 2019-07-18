package ru.itis.spring;

public class CustomTextPrefixUtilsImpl implements PrefixUtils {
    private String prefix;
    private MessageRenderer renderer;

    public CustomTextPrefixUtilsImpl(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void render(String message) {
        System.out.println(prefix);
        renderer.render(message);
    }
}
