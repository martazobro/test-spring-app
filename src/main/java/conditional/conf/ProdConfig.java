package conditional.conf;

import conditional.common.Prod;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Jeka on 03/10/2015.
 */
@Configuration
@PropertySource("classpath:prod.properties")
@Prod
@ComponentScan(basePackages = "conditional.prod")
public class ProdConfig {

}
