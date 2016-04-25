package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Jeka on 03/10/2015.
 */
@Component
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;

    @PostConstruct
    public void init(){
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void fly(){
        Random random = new Random();
        setLocation(random.nextInt(1200),random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }











}
