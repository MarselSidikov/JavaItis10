package ru.itis.web.listeners;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.web.repositories.CookieValuesRepository;
import ru.itis.web.repositories.jdbc.CookieValuesRepositoryJdbcImpl;
import ru.itis.web.repositories.UsersRepository;
import ru.itis.web.repositories.jdbc.UsersRepositoryJdbcImpl;
import ru.itis.web.services.UsersService;
import ru.itis.web.services.UsersServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

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
        ServletContext context = sce.getServletContext();
//        String fullPath = context.getRealPath("/WEB-INF/context.xml");
        String fullPath = "C:\\Users\\Marsel\\Desktop\\Education\\JavaItis10\\Projects\\# 43. JavaWeb\\src\\main\\webapp\\WEB-INF\\context.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(fullPath);
        sce.getServletContext().setAttribute("usersService", applicationContext.getBean(UsersService.class));
    }
}
