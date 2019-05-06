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
        return 0;
    }
    
    public static void main(String[] args) {
        // 2.0000000000064175
        System.out.println(calcIntegralByRectangles(0, Math.PI, 1000000));
    }
}
