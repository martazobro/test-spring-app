package conditional;

import conditional.common.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Jeka on 03/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("conditional.conf");
        context.getBean(MyService.class).doWork();
    }
}
