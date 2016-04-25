package aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jeka on 03/10/2015.
 */
@Service
public class DbService {
    @Autowired
    private PersonDao personDao;

    public void doStuff(){
        System.out.println("douing");
        personDao.savePerson();
    }

}
