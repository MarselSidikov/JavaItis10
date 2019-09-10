package plain;

/**
 * 27.02.2018
 * plain.Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        CarBeforeAdvice before = () -> {
            System.out.println("Идет проверка бензина");
        };

        CarAfterAdvice after = () -> {
            System.out.println("Выключается двигатель");
        };
        CarMethodAdvice inProcess = () -> {
            System.out.println("Никуда я не поеду");
        };

        CarProxy proxy = new CarProxy(car, before, after, inProcess);

        Driver driver = new Driver(proxy);
        driver.drive();
    }
}
