package conditional.conf;

import conditional.common.Dev;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Jeka on 03/10/2015.
 */
@Configuration
@PropertySource("classpath:dev.properties")
@Dev
@ComponentScan(basePackages = "conditional.dev")
public class DevConfig {

}
