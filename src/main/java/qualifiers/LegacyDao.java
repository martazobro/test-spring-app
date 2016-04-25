package qualifiers;

import org.springframework.stereotype.Repository;

/**
 * Created by Jeka on 03/10/2015.
 */
@Postgres
public class LegacyDao implements Dao {
    @Override
    public void save() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Saving to postgres");
    }
}
