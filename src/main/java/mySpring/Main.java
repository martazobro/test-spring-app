package mySpring;

/**
 * Created by Jeka on 02/10/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
