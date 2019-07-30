package ru.itis.freemarker;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
        configuration.setTemplateLoader(new FileTemplateLoader(new File("C:\\Users\\Marsel\\Desktop\\Education\\JavaItis10\\Projects\\# 48. Freemarker Example\\# 48. Freemarker Example\\src\\main\\resources\\")));

        Template template = configuration.getTemplate("template.ftl");
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Марсель");
        attributes.put("wifeName", "Айсылу");
        attributes.put("age", 26);

        FileWriter writer = new FileWriter("output.html");
        template.process(attributes, writer);
    }
}
