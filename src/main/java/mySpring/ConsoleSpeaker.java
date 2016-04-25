package mySpring;

/**
 * Created by Jeka on 02/10/2015.
 */
public class ConsoleSpeaker implements Speaker {

    @Inject
    private Cleaner cleaner;

    public void speak(String message) {
        System.out.println(message);
        cleaner.clean();
    }
}
