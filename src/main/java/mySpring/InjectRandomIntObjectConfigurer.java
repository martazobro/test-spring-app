package mySpring;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Jeka on 02/10/2015.
 */
public class InjectRandomIntObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object o) throws IllegalAccessException {
        Class<?> type = o.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int randomInt = min + random.nextInt(max - min + 1);
                field.setAccessible(true);
                field.set(o,randomInt);
            }
        }
    }
}
