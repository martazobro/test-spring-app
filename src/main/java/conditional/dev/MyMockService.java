package conditional.dev;

import conditional.common.EmployeeDao;
import conditional.common.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jeka on 03/10/2015.
 */
@Service
public class MyMockService implements MyService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void doWork() {
        System.out.println(employeeDao.getPerson()+" was fired");
    }
}



