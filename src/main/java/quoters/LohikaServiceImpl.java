package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 02/10/2015.
 */
@Component
@Transactional
public class LohikaServiceImpl implements LohikaService {

    @Override
    @PostProxy
    public void init(){
        System.out.println("Warming cache");
    }

    @Override
    public void doWork() {
        System.out.println("WORKING...");
    }

    @Override
    public void drinkBeer() {
        System.out.println("Pshenichnoe");
    }
}
