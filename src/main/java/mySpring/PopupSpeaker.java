package mySpring;

import javax.swing.*;

/**
 * Created by Jeka on 02/10/2015.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
