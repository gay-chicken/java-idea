package practice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class practice_five extends JFrame {
    JButton click;
    showFrame showframe;
    JPanel panel;
    practice_five(){
        showframe=new showFrame(this);
        panel=new JPanel();
        setTitle("JDialog");
        setSize(10,10);
        click=new JButton("click");
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showframe.setVisible(true);
            }
        });
        panel.add(click);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        pack();
    }
}

class showFrame extends JDialog{
    JTextField text;
    JPanel panel;
    public showFrame(){

    }
    public showFrame(JFrame frame){
        super(frame,"new",true);
        text=new JTextField(15);
        panel.add(text);
        this.add(panel);
        this.pack();
    }
}