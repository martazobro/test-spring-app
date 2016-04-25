package conditional.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by Jeka on 03/10/2015.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Value("${personName}")
    private String personName;


    @Override
    public String getPerson() {
        return personName;
    }
}
