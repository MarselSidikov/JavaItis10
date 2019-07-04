package ru.itis;

public class MathUtil {
    public boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            throw new IllegalArgumentException();
        }

        number = Math.abs(number);

        if (number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
