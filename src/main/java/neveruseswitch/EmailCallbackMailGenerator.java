package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
@MailCode(2)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        // 30 lines of code
        return "<html> don't call us we call you</html>";
    }
}
