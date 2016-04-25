package screenSaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 03/10/2015.
 */
public class TimeScopeProvider implements Scope {
    private Map<String, Pair<Pair<LocalDateTime,Integer>, Object>> map = new HashMap<>();

    private ConfigurableListableBeanFactory beanFactory;

    public TimeScopeProvider(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        try {
            String factoryBeanName = beanFactory.getBeanDefinition(name).getFactoryBeanName();
            TimeScope annotation = ((AbstractBeanDefinition) beanFactory.getBeanDefinition(factoryBeanName)).getBeanClass().getSuperclass().getMethod(name.split("\\.")[1]).getAnnotation(TimeScope.class);


            System.out.println();
            if (!map.containsKey(name) || Duration.between(map.get(name).getKey().getKey(), LocalDateTime.now()).toMillis()>map.get(name).getKey().getValue()*1000) {
                map.put(name, new Pair<>(new Pair<>(LocalDateTime.now(),annotation.seconds()), objectFactory.getObject()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }


    public static void main(String[] args) throws InterruptedException {
        LocalDateTime before = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime after = LocalDateTime.now();
        long l = Duration.between(after, before).toMillis();
        System.out.println(l);
    }
}
