package aopalliance;

import org.springframework.aop.ThrowsAdvice;


public class IndexIllegalExceptionAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("МЫ СЛОВИЛИ ОШИБКУ :( - " + ex.getMessage());
    }
}
