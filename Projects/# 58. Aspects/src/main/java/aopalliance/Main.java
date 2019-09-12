package aopalliance;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] arg) {
        // ADVICE
        MethodBeforeAdvice beforeAdvice = (method, args, target) -> {
            System.out.print(method.getName() + " ");
            if (args.length > 0) {
                System.out.print(args[0] + " ");
            }
            System.out.println(target);
        };
        AfterReturningAdvice afterAdvice = (returnValue, method, args, target) -> {
            System.out.println("Метод " + method + " вернул " + returnValue);
        };
        ThrowsAdvice throwsAdvice = new IndexIllegalExceptionAdvice();
        // исходный объект
        Human source = new Human(0, "Марсель", 70);
        // introduction
        ProxyFactory proxyFactory = new ProxyFactory(source);
        // weaving
        proxyFactory.addAdvice(beforeAdvice);
        proxyFactory.addAdvice(afterAdvice);
        proxyFactory.addAdvice(throwsAdvice);
        // получил целевой объект
        Human target = (Human)proxyFactory.getProxy();
//        target.grow(0.10);
        target.sayName();
        target.getIndex();

    }
}
