package ExceptionTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptTest {
    public static void main(String[] args){
        ExceptFrame frame=new ExceptFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (frame == null) {
            throw new AssertionError();
        }
        frame.setVisible(true);
    }
}

class ExceptFrame extends JFrame {
    public ExceptFrame(){
        setTitle("Exception Test");
        setSize(1000,1000);

        add(new ExceptPanel());
        pack();
    }
}

class ExceptPanel extends Box{
    private ButtonGroup group;
    private JTextField textField;
    private double[] a=new double[10];
    public ExceptPanel(){
        super(BoxLayout.Y_AXIS);
        group=new ButtonGroup();

        addRadioButton("Integer divide by zero",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                a[1]=1/(a.length-a.length);
            }
        });

        addRadioButton("Floating divide by zero",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                a[1]=a[2]/(a[3]-a[3]);
            }
        });

        addRadioButton("Arrays bounds",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                a[1]=a[10];
            }
        });

        addRadioButton("Null pointer",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                e=null;
                System.out.println(e.getSource());
            }
        });

        addRadioButton("Bad cast",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                a=(double[])e.getSource();
            }
        });

        addRadioButton("sqrt(-1)",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                a[1]=Math.sqrt(-1);
            }
        });

        addRadioButton("Overflow",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                a[1]=1000*1000*1000*1000;
                int n=(int)a[1];
            }
        });

        addRadioButton("No such file",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    InputStream stream=new FileInputStream("woolze.txt");
                }catch (IOException ioe){
                    textField.setText(e.toString());
                }
            }
        });

        addRadioButton("Throw unknow",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnknownError();
            }
        });


        textField=new JTextField(30);
        add(textField);
    }

    private void addRadioButton(String text,ActionListener action){
        JRadioButton button=new JRadioButton(text,false)
        {
            @Override
            protected void fireActionPerformed(ActionEvent Event){
                try{
                    textField.setText("No exception");
                    super.fireActionPerformed(Event);
                }catch (Exception exception){
                    textField.setText(exception.toString());
                }
        }
        };

        button.addActionListener(action);
        add(button);
        group.add(button);
    }
}