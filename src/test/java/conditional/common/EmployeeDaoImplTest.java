package conditional.common;

import conditional.conf.CommonConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Jeka on 03/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CommonConfig.class)
public class EmployeeDaoImplTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testGetPerson() throws Exception {
        System.out.println(employeeDao.getPerson());




    }
}