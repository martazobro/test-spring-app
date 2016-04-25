package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class SecurityAspect {

    @Around("@annotation(aop.Secured)")
    public void doSecured(ProceedingJoinPoint pjp) throws Throwable {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            pjp.proceed();
        }else {
            throw new SecurityException("you not permited!!!");
        }
    }











}
