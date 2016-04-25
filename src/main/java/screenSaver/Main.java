package screenSaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Jeka on 03/10/2015.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
        while (true) {
            context.getBean(ColorFrame.class).fly();
            Thread.sleep(100);
        }
    }
}






