package quoters.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
@Aspect
public class QuoterAspect {

    @Before("execution(* quoters..*.say*(..))")
    public void printQuote(JoinPoint jp) {
        System.out.println("This is quotes "+jp.getTarget().getClass().getSimpleName());

    }












}
