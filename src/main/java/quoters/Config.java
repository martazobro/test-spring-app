package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 03/10/2015.
 */
@Configuration
@PropertySource("classpath:quotes.properties")
@EnableAspectJAutoProxy
public class Config {

    @Value("${version}")
    private String version;

    @PostConstruct
    public void init(){
        System.out.println("version = " );
    }

    @Bean
    @Order(3)
    public Quoter quoter(){
        return new Quoter() {
            @Override
            public void sayQuote() {
                System.out.println("Smert vragam!!!");
            }
        };
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
