package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
@Aspect
@PropertySource("classpath:mails.properties")
public class ExceptionHandlerAspect {

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Value("${dbaMails}")
    private String[] mails;


    private Map<DatabaseRuntimeException, Void> map = new WeakHashMap<>();


    @Pointcut("execution(* aop.business..*.*(..))")
    public void allBusinessMethods() {
    }

    @AfterThrowing(value = "allBusinessMethods()", throwing = "ex")
    public void handleDBException(DatabaseRuntimeException ex) throws Throwable {

        if (!map.containsKey(ex)) {
            map.put(ex, null);
            for (String mail : mails) {
                System.out.println("sending to " + mail + " " + ex.getMessage());
            }

        }


    }


}
