package mySpring;

import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Jeka on 02/10/2015.
 */
public class ObjectFactory {

    private Reflections reflections = new Reflections("mySpring");

    private static ObjectFactory ourInstance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private Config config = new JavaConfig();

    private List<ObjectConfigurer> configurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = reflections.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> configurerClass : classes) {
            if (!Modifier.isAbstract(configurerClass.getModifiers())) {
                try {
                    configurers.add(configurerClass.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public <T> T createObject(Class<T> type) throws Exception {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        invokeInitMethods(type, t);
        t = configureProxy(type, t);
        return t;

    }

    private <T> T configureProxy(Class<T> type, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = (T) proxyConfigurer.wrapWithProxy(t, type);
        }
        return t;
    }

    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class impl = config.getImpl(type);
            if (impl == null) {
                Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException(type + " has 0 or more than 1 impl, please map needed impl in Config");
                }else {
                    impl = (Class<T>) classes.iterator().next();
                }
            }
            type = impl;
        }
        return type;
    }

    private <T> void configure(T t) throws Exception {
        for (ObjectConfigurer configurer : configurers) {
            configurer.configure(t);
        }
    }

}
