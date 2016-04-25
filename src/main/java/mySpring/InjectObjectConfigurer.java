package mySpring;

import java.lang.reflect.Field;

/**
 * Created by Jeka on 02/10/2015.
 */
public class InjectObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object o) throws Exception {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(o,ObjectFactory.getInstance().createObject(field.getType()));
            }
        }
    }
}
