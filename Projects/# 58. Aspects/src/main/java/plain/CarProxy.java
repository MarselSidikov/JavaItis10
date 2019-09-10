package plain;

/**
 * 27.02.2018
 * plain.CarProxy
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CarProxy extends Car {

    private Car inner;
    private CarBeforeAdvice carBeforeAdvice;
    private CarAfterAdvice carAfterAdvice;
    private CarMethodAdvice carMethodAdvice;

    public CarProxy(Car car, CarBeforeAdvice carBeforeAdvice, CarAfterAdvice carAfterAdvice,
                    CarMethodAdvice methodAdvice) {
        this.inner = car;
        this.carBeforeAdvice = carBeforeAdvice;
        this.carAfterAdvice = carAfterAdvice;
        this.carMethodAdvice = methodAdvice;
    }

    @Override
    public void go() {
        // АСПЕКТ = Advice + joinpoint
        carBeforeAdvice.before();
        if (carMethodAdvice == null) {
            inner.go();
        } else {
            carMethodAdvice.invoke();
        }
        carAfterAdvice.after();
    }
}
