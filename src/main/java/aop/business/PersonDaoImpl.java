package aop.business;

import aop.DatabaseRuntimeException;
import org.springframework.stereotype.Repository;

/**
 * Created by Jeka on 03/10/2015.
 */
@Repository
public class PersonDaoImpl implements PersonDao {
    @Override
    public void savePerson() {
        System.out.println("saving...");
        throw new DatabaseRuntimeException("FIRE ALL DBA!!!");
    }
}
