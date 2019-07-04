package ru.itis;

import java.lang.reflect.Field;

public class ObjectsGenerator {
    // User user = generator.createObject(User.class, "Марсель", 25);
    public <T> T createObject(Class<T> aClass, Object ... fieldsValues) {
        Field fields[] = aClass.getDeclaredFields();

        try {
            T object = aClass.newInstance();

            int fieldNumber = 0;
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, fieldsValues[fieldNumber]);
                fieldNumber++;
            }

            return object;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }
}
