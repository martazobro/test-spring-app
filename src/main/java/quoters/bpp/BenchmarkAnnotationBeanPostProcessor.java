package quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import quoters.Benchmark;
import quoters.BenchmarkController;
import quoters.Transactional;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 02/10/2015.
 */
@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> beanName2OriginalBeanClass = new HashMap<>();

    private BenchmarkController benchmarkController = new BenchmarkController();

    public BenchmarkAnnotationBeanPostProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(benchmarkController, new ObjectName("lohicaMBeans", "name", "benchmark"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                beanName2OriginalBeanClass.put(beanName, beanClass);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanName2OriginalBeanClass.get(beanName);

        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalClassMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());
                    if (originalClassMethod.isAnnotationPresent(Benchmark.class)&&benchmarkController.isEnabled()) {
                        System.out.println("**************BENCHMARK***************");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println("method " + method.getName() + " worked for " + (after - before) + " nanos");
                        System.out.println("**************BENCHMARK***************");
                        return retVal;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        }


        return bean;
    }
}















