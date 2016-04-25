package quoters;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Jeka on 03/10/2015.
 */
public class IntegerFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
