package Assembly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class RobotTest {

    public static void main(String[] args){
        ButtonFrame frame=new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        GraphicsEnvironment environment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen=environment.getDefaultScreenDevice();

        try{
            Robot robot=new Robot(screen);
            run(robot);

        }catch (AWTException e){
            e.printStackTrace();
        }
    }

    public static void run(Robot robot){
        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(1000);
        robot.mouseMove(200,50);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.delay(1000);
        BufferedImage image=robot.createScreenCapture(new Rectangle(0,0,400,300));

        ImageFrame frame=new ImageFrame(image);
        frame.setVisible(true);
    }
}

class ImageFrame extends JFrame {
    private static final int D_WIDTH=450;
    private static final int D_HEIGHT=350;
    public ImageFrame(Image image){
        setTitle("RobotTest");
        setSize(D_WIDTH,D_HEIGHT);

        JLabel label=new JLabel(new ImageIcon(image));
        add(label);
    }
}

class ButtonFrame extends JFrame{
    private JPanel panel=new JPanel();

    public ButtonFrame(){
        setTitle("ButtonFRame");
        setSize(300,300);
        setLocation(500,500);
/*
        setting("BLUE",Color.BLUE);
        setting("RED",Color.RED);
        setting("GREEN",Color.GREEN);

 */
        JButton blue=new JButton("BLUE");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.BLUE);
            }
        });
        JButton red=new JButton("RED");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.RED);
            }
        });
        JButton green=new JButton("GREEN");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.GREEN);
            }
        });

        panel.add(blue);
        panel.add(red);
        panel.add(green);

        add(panel);
    }
    /*
    private void setting(String name,Color color){
        JButton button=new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(color);
            }
        });
        panel.add(button);
    }

     */

}