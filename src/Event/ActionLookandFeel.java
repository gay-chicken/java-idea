package Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * $ javax.swing.UIManager 1.2
 *      static UIManager.LookAndFeelInfo[]、getInstalled/lookAndFeels();
 *###  得到一个用于描述已安装的观感实现的对象按钮。
 *
 *      static setLookAndFeel(String className);
 *###  设置当前观感
 */

/**
 * $  javax.swing.UIManager.LookAndFeelInfo 1.2
 *      String getName();
 *###  得到观感的名称
 *
 *      String getClassName();
 *###  返回观感实现类的名称
 */
public class ActionLookandFeel {
    public static void main(String[] args){
        Frame frame=new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Frame extends JFrame {
    public Frame(){
        setTitle("PlafFrame");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        Panel panel=new Panel();
        add(panel);
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class Panel extends JPanel{
    public Panel(){
        UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo sum:infos) {
            makeButton(sum.getName(),sum.getClassName());
        }
    }

    public void makeButton(String name,final String plafName){
        JButton button=new JButton(name);
        add(button);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                try{
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(Panel.this);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}