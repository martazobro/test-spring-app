package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Jeka on 03/10/2015.
 */
@Service
@EnableScheduling
public class MailService {
    @InjectMailGenerators
    private Map<String, MailGenerator> map;

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        String code = String.valueOf(DBUtils.getMailCode());
        MailGenerator mailGenerator = map.get(code);
        if (mailGenerator == null) {
            throw new RuntimeException(code + " not mapped to any generator class");
        }
        String html = mailGenerator.generateHtml();
        send(html);
    }

    private void send(String html) {
        System.out.println("Sending... "+html);
    }
}










