package ru.itis.try_catch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainCatchWithInheritance {

    public static void f(int n) {
        System.out.println(n);
        f(n - 1);
    }

//    public static void main(String[] args) throws Exception {
//        try {
//            Scanner scanner = null;
//            int a = scanner.nextInt();
//            String strings[] = new String[Integer.MAX_VALUE - 100];
//            InputStream inputStream = new FileInputStream("файл которого нет");
//            f(5);
//        } catch (NullPointerException e) {
//            System.out.println("Я на NullPointer");
//        } catch (OutOfMemoryError e) {
//            System.out.println("Я на OutOfMemory");
//        } catch (FileNotFoundException e) {
//            System.out.println("Я на FileNotFound");
//        } catch (StackOverflowError e) {
//            System.out.println("Я на StackOverflow");
//        }
//    }

    public static void main(String[] args) throws Exception {
        try {
//            Scanner scanner = null;
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int y = a / b;
//            String strings[] = new String[Integer.MAX_VALUE - 100];
//            f(5);
            InputStream inputStream = new FileInputStream("файл которого нет");
        } catch (VirtualMachineError e) {
            System.out.println("Я на VirtualMachineError");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Файл мы не нашли");
        } catch (Exception e) {
            System.out.println("Я на Exception");
            e.printStackTrace();
        }
    }
}
