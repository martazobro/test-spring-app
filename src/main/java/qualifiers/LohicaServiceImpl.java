package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import quoters.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 03/10/2015.
 */
@Service
@Transactional
public class LohicaServiceImpl implements LohicaService {
    @Autowired
    private Dao dao;


    @PostConstruct
    public void init(){
        System.out.println("Warming cache");
    }


    @Override
    public void doWork() throws InterruptedException {
        System.out.println("Working...");
        dao.save();
    }
}
