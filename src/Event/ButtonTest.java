package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * $  javax.swing.JButton  1.2
 *      JButton(String text);
 *      JButton(Icon icon);
 *      JButton(String text,Icon icon);
 *###  构造一个按钮。text：显示的文本，也可以是HTML文本，例如：”<html><b>Yellow</b></html>"。icon:显示在按钮表面的图标
 */

/**
 * $  java.awt.Container 1.0
 * Component add(Component com);
 * ###  将组件com添加进容器中
 */

/**
 * $  java.awt.ImageIcon 1.2
 *      ImageIcon(String filename);
 *###  构造一个图标，他的图像存储在一个文件中。通过媒体跟踪器自动加载这个图像
 */
public class ButtonTest{
    public static void main(String[] args){
        buttonFrame frame=new buttonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class buttonFrame extends JFrame{
    public buttonFrame(){
        setTitle("ButtonFrame");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        buttonPanel panel=new buttonPanel();
        add(panel);
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class buttonPanel extends JPanel{
    public buttonPanel(){
        JButton yellow=new JButton("<html><b>Yellow</b><html>");
        JButton blue=new JButton("blue");
        JButton green=new JButton("green");

        add(yellow);
        add(green);
        add(blue);

        ColorAction yellowAction=new ColorAction(Color.YELLOW);
        ColorAction blueAction=new ColorAction(Color.BLUE);
        ColorAction greenAction=new ColorAction(Color.GREEN);

        yellow.addActionListener(yellowAction);
        blue.addActionListener(blueAction);
        green.addActionListener(greenAction);
    }

    private class ColorAction implements ActionListener{
        private Color backgroundColor;
        public ColorAction(Color color){
            backgroundColor=color;
        }

        @Override
        public void actionPerformed(ActionEvent event){
            setBackground(backgroundColor);
        }
    }
}
