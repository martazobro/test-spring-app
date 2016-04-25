package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
@MailCode(3)
public class HappyBithdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "Happy birthday!";
    }
}
