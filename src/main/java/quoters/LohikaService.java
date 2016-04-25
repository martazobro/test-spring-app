package quoters;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 02/10/2015.
 */
public interface LohikaService {
    @PostConstruct
    void init();

    void doWork();
    void drinkBeer();
}
