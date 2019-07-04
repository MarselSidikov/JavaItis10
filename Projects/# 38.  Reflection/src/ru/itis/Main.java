package ru.itis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) throws Exception {
	    Class<User> aClass = User.class;

	    String className = aClass.getTypeName();

        Field fields[] = aClass.getFields();

        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        User user = new User("Игорь", 25);

        Field nameField = aClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(user, "Марсель");

        System.out.println(user.getName());
        System.out.println(className);

        Method methods[] = aClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());

            for (Parameter parameter : method.getParameters()) {
                System.out.println(parameter.getType() + " " + parameter.getName());
            }
        }
        Method method = aClass.getMethod("makeOlder", int.class);
        method.invoke(user, 25);
        System.out.println(user.age);

        Method method2 = aClass.getMethod("getHalfLife");
        int value = (int)method2.invoke(user);
        System.out.println(value);

//        User user2 = (User)aClass.newInstance();
        Constructor<User> constructor = aClass.getConstructor(String.class, int.class);
        User user2 = constructor.newInstance("Олег", 23);
        System.out.println(user2.getName() + " " + user2.age);
    }
}
