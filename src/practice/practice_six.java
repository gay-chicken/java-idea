package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class practice_six {
    public static void main(String[] args){
        ButtonFrame frame=new ButtonFrame();

        frame.addButton("button");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setCenter();
    }

}

class ButtonFrame extends JFrame {
    private static final int DEFAULT_WIDTH=600;
    private static final int DEFAULT_HEIGHT=(int)(DEFAULT_WIDTH*0.618);
    private JPanel panel=new JPanel();
    public ButtonFrame(){
        setTitle("ButtonFrame");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        add(panel,BorderLayout.NORTH);
    }

    public void setCenter(){
        Toolkit kit= Toolkit.getDefaultToolkit();
        Dimension dimension=kit.getScreenSize();

        setLocation((dimension.width-DEFAULT_WIDTH)/2,(dimension.height-DEFAULT_HEIGHT)/2);
    }

    public  void addButton(String name){
        JButton button=new JButton(name);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });
        panel.add(button);
    }

}
