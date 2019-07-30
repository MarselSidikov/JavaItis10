package ru.itis.web.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// класс, заменяющий web.xml
//
public class WebAppInitializer implements WebApplicationInitializer {

    // что происходит при запуске приложения в tomcat?
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // создаем специальный объект-контекст для веб приложений
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        // регистрируем в этом контексте контекст спринга
        context.register(AppConfig.class);
        // создаем три объекта DelegatingFilterProxy для того,
        // чтобы ваши фильтры тоже были бинами и в них можно было бы
        // автовайрить сервисы
        DelegatingFilterProxy authFilter = new DelegatingFilterProxy("authenticationFilter");
        DelegatingFilterProxy rolesFilter = new DelegatingFilterProxy("rolesFilter");
        DelegatingFilterProxy redirectFilter = new DelegatingFilterProxy("redirectFilter");

        // в контекст сервлетов добавляем наши фильтры
        // и указываем url-ы которые они обрабатывают
        servletContext
                .addFilter("authFilter", authFilter)
                .addMappingForUrlPatterns(null, false, "/*");
        servletContext
                .addFilter("rolesFilter", rolesFilter)
                .addMappingForUrlPatterns(null, false, "/*");

        servletContext
                .addFilter("redirectFilter", redirectFilter)
                .addMappingForUrlPatterns(null, false, "/*");

        // передаем ссылку на контекст сервлетов
        // внутрь контекста веб-приложения
        context.setServletContext(servletContext);
        // создаем диспатчер-сервлет и тут-же помещаем его в контекст
        // сервлетов
        // дисптачер-сервлету в свою очередь передаем контекст веб-приложения
        // чтобы он видел все бины
        // раньше это было автоматически - он находит context.xml
        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        // сказали что этот сервлет должен запускаться сразу при запуске приложения
        dispatcherServlet.setLoadOnStartup(1);
        // и принимал запросы на все урлы
        dispatcherServlet.addMapping("/");
    }
}
