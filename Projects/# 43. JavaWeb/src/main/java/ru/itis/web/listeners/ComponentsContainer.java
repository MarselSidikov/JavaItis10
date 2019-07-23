package ru.itis.web.listeners;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.web.configuration.AppConfig;
import ru.itis.web.services.CarsService;
import ru.itis.web.services.UsersService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ComponentsContainer implements ServletContextListener {

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Properties properties = new Properties();
//        ServletContext context = sce.getServletContext();
//        String fullPath = context.getRealPath("/WEB-INF/db.properties");
//        properties.load(new FileReader(fullPath));
//        Class.forName(properties.getProperty("db.driver"));
//        Connection connection = DriverManager.getConnection(properties.getProperty("db.url"),
//                properties.getProperty("db.username"),
//                properties.getProperty("db.password"));
//        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
//        CookieValuesRepository cookieValuesRepository = new CookieValuesRepositoryJdbcImpl(connection);
//        UsersService usersService = new UsersServiceImpl(usersRepository, cookieValuesRepository);
//        String fullPath = context.getRealPath("/WEB-INF/context.xml");
        ServletContext context = sce.getServletContext();
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        context.setAttribute("usersService", applicationContext.getBean(UsersService.class));
        context.setAttribute("carsService", applicationContext.getBean(CarsService.class));
    }
}
