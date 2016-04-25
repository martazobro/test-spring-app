package aop;

import org.springframework.stereotype.Service;

/**
 * Created by Jeka on 03/10/2015.
 */
@Service
public class MyServiceImpl  {
    @Secured
    public void doWork(){
        System.out.println("WORKING123...");
    }
}
