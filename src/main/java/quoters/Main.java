package quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Jeka on 02/10/2015.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        new AnnotationConfigApplicationContext("quoters");


    }
}
