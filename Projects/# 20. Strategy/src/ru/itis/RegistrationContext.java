package ru.itis;

public class RegistrationContext implements Context {
    private Strategy registrationStrategy;

    public void setStrategy(Strategy strategy) {
        this.registrationStrategy = strategy;
    }

    public void registration() {
        System.out.println("РЕГИСТРАЦИЯ НАЧАТА:");
        registrationStrategy.run();
        System.out.println("РЕГИСТРАЦИЯ ЗАВЕРШЕНА");
    }

}
