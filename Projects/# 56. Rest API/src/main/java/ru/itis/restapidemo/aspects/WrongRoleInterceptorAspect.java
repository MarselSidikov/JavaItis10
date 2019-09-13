package ru.itis.restapidemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class WrongRoleInterceptorAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(value = "execution(public org.springframework.http.ResponseEntity ru.itis.restapidemo.controllers.UsersController.getUser(..)) && args(token, userId))",
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception, String token, Long userId) {
        logger.info(exception.getMessage() + " " + token + " " + userId);
    }
}
