package mySpring;

/**
 * Created by Jeka on 02/10/2015.
 */
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 4, max=7)
    private int repeat;
    
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVvvvvvvvvvvvvvvv");
        }
    }
}
