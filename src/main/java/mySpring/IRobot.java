package mySpring;

import quoters.Transactional;

/**
 * Created by Jeka on 02/10/2015.
 */

@Transactional
public class IRobot {
    @Inject
    private Cleaner cleaner;
    @Inject
    private Speaker speaker;


    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
