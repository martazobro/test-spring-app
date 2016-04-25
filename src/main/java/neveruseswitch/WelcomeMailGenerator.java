package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
@MailCode(1)
@MailCode(5)
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        // 30 lines of code
        return "<html> Welcome new client</html>";
    }
}
