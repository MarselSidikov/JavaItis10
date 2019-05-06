package ru.itis;

public class Main {
    public static double f(double x) {
        return Math.sin(x);
    }

    public static double calcIntegralByRectangles(double a, double b, int N) {
        double h = (b - a) / N;
        double result = 0;
        for (double x = a; x <= b; x += h) {
            result = result + f(x) * h;
        }
        return result;
    }

    public static double calcIntegralBySimpson(double a, double b, int N) {
        double h = (b - a) / N;
        double result = 0;
        for (double x = a + h; x < b; x = x + 2 * h) {
            double currentValue = f(x - h) + 4 * f(x) + f(x + h);
            result = result + currentValue;
        }

        return (h / 3) * result;
    }

    public static void main(String[] args) {
        // 2.0000000000064175
        System.out.println(calcIntegralByRectangles(0, Math.PI, 1000000));
        System.out.println(calcIntegralBySimpson(0, Math.PI, 100));
    }
}
