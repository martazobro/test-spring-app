package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeka on 02/10/2015.
 */
@Component
public class TalkingRobotImpl implements TalkingRobot {

    @Autowired(required = false)
    private List<Quoter> quoters = Arrays.asList(new Quoter() {
        @Override
        public void sayQuote() {
            System.out.println("This is default quote");
        }
    });


    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters) {
            System.out.println(quoter.getClass().getName());
        }
        quoters.forEach(Quoter::sayQuote);
    }
}
