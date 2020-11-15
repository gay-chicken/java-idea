package Assembly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * $  javax.swing.JCheckBox 1.2
 *      JCheckBox(String label);
 *      JCheckBox(String label,boolean state);
 *      JCheckBox(String label,Icon icon);
 *###  用给定标签、图标、状态构造一个复选框，该标签若未指定状态state,则初始为未选择状态。
 *
 *      void isSelected();
 *###  返回复选框状态。
 *
 *      void setSelected();
 *###  为复选框设置新的状态。
 */
public class CheckBox {
    public static void main(String[] args){
        CheckFrame frame=new CheckFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CheckFrame extends JFrame {

    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT= (int) (300*0.618);
    private static final int FONTSIZE=12;

    private JLabel label;
    private JPanel buttonpanel;
    private JCheckBox bold;
    private JCheckBox italic;

    public CheckFrame(){
        setTitle("CkeckBox");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        setCenter();

        label=new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif",Font.PLAIN,FONTSIZE));
        add(label,BorderLayout.CENTER);

        ActionListener action=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                int mode=0;
                if(bold.isSelected()) {
                    mode+=Font.BOLD;
                }
                if(italic.isSelected()) {
                    mode+=Font.ITALIC;
                }
                label.setFont(new Font("Serif",mode,FONTSIZE));
            }
        };

        buttonpanel=new JPanel();

        bold=new JCheckBox("bold");
        italic=new JCheckBox("Italic");
        bold.addActionListener(action);
        italic.addActionListener(action);
        buttonpanel.add(bold);
        buttonpanel.add(italic);
        add(buttonpanel,BorderLayout.SOUTH);

    }

    public void setCenter(){
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension dimension=kit.getScreenSize();

        int ScreenLocation_Width=(dimension.width-DEFAULT_WIDTH)/2;
        int ScreenLocation_Height=(dimension.height-DEFAULT_HEIGHT)/2;

        setLocation(ScreenLocation_Width,ScreenLocation_Height);
    }
}
