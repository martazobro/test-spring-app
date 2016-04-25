package aop;

import aop.business.DbService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Jeka on 03/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");

        DbService service = context.getBean(DbService.class);
        try {
            service.doStuff();
        } catch (Exception e) {
            System.err.println("PROBLEM");
        }

    }
}
