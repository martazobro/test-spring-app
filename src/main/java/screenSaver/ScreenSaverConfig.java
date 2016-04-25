package screenSaver;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Jeka on 03/10/2015.
 */
@Configuration
@ComponentScan(basePackages = {"screenSaver"})
public class ScreenSaverConfig {
    private Random random = new Random();

    @Bean
    @TimeScope(seconds = 1)
    public Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }



}





