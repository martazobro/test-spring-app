package qualifiers;

/**
 * Created by Jeka on 03/10/2015.
 */
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Mongo.....");
    }
}
