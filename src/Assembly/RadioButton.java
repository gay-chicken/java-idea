package Assembly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * $  javax.swing.JRadioButton 1.2
 *      JRadioButton(String label,boolean state);
 *###  用给定标签构造一个单选按钮。
 *
 *      JRadioButton(String label,Icon icon);
 *###  用给定标签和图标构造一个单选按钮，初始化为“未选”。
 */

/**
 * $  javax.swing.ButtonGroup  1.2
 *      void add(AbstractButton button);
 *###  将该按钮button添加进按钮组中。
 *
 *      ButtonModel getSelection();
 *###  返回该按钮的按钮模型。
 */

/**
 * $  javax.swing.ButtonModel 1.2
 *      String getActionCommand();
 *###  返回这个按钮模型的命令。
 */

/**
 * $  javax.swing.AbstractButton 1.2
 *      void setActionCommand(String str);
 *###  设置这个按钮及其模型的动作命令。
 */
public class RadioButton {
    public static void main(String[] args){
        RadioFrame frame=new RadioFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class RadioFrame extends JFrame {
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=(int)(300*0.616);
    private static final int DEFAULT_SIZE=12;

    private JLabel label;
    private JPanel buttonpanel;
    private ButtonGroup group;

    public RadioFrame(){
        setTitle("RadioButton");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        label=new JLabel("the quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN,DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);

        buttonpanel=new JPanel();
        group=new ButtonGroup();

        addRadioButton("small",8);
        addRadioButton("medium",12);
        addRadioButton("large",18);
        addRadioButton("extra large",36);

        add(buttonpanel,BorderLayout.SOUTH);
    }

    public void addRadioButton(String name,final int size){
        boolean selected=size==DEFAULT_SIZE;
        JRadioButton button=new JRadioButton(name,selected);
        group.add(button);
        buttonpanel.add(button);

        ActionListener action =new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                label.setFont(new Font("Serif",Font.PLAIN,size));
            }
        };
        button.addActionListener(action);
    }
}