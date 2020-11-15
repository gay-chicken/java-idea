package Assembly;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * $  javax.swing.BorderFactory 1.2
 *      static Border createLineBorder(Color color);
 *      static Border createLineBorder(Color color,int thickness);
 *###  创建一个直线边界
 *
 *      static MatteBorder createMatteBorder(int top,int left,int bottom,int right,Color color);
 *      static MatteBorder createMatteBorder(int top,int left,int bottom,int right,Icon titleicon）;
 *###  创建一个用颜色或重复的图标填充的粗边界。
 *
 *      static Border createEmptyBorder();
 *      static Border createEmptyBorder(int top,int left,int bottom,int right);
 *###  创建一个空边界
 *
 *      static Border createEtchedBorder();
 *      static Border createEtchedBorder(Color highlight,Color shadow);
 *      static Border createEtchedBorder(int type);
 *      static border createEtchedBorder(int type,Color highlight,Color shadow);
 *###  创建一个具有3D效果的直线边界。highlight,shadow:用于3D效果的颜色。type:EtchedBorder.RAISED或EtchedBorder.LOWRED之一
 *
 *      static Border createBevelBorder(int type);
 *      static Border createBevelBorder(int type,Color highlight,Color shadow);
 *      static Border createLoweredBevelBorder();
 *      static Border createRaisedBevelBorder();
 *###  创建具有凹面或凸面效果的边界。
 *
 *      static TitledBorder createTitledBorder(String title);
 *      static TitledBorder createTitledBorder(Border border);
 *      static TitledBorder createTitledBorder(Border border,String title);
 *      static TitledBorder createTitledBorder(Border border,String title,int justification,int position);
 *      static TitledBorder createTitledBorder(Border border,String title,int justification,int position,Font font);
 *      static TitledBorder createTitledBorder(Border border,String title,int justification,int position,Font font,Color color);
 *###  创建一个具有给定特性的带标题的边框。
 *                                  title:标题字符串
 *                                  border:用标题装饰的边框
 *                                  justification:TitledBorder的常量之一。LEFT,CENTER,RIGHT,LEADING,TRAILING,DEFAULT_JUSTIFICATION(left);
 *                                  position:TitledBorder的常量之一。ABOVE_TOP,TOP,BELOW_TOP,ABOVE_BOTTOM,BOTTOM,BELOW_BOTTOM,DEFAULT_POSITION(top)
 *                                  font:标题字体
 *                                  color:标题颜色
 */
public class BorderTest {
    public static void main(String[] args){
        BorderFrame frame=new BorderFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class BorderFrame extends JFrame {

    private JPanel panel;
    private ButtonGroup group;
    private JPanel buttonpanel;

    public BorderFrame(){
        setTitle("Border");
        setSize(600,400);

        panel=new JPanel();
        buttonpanel=new JPanel();
        group=new ButtonGroup();

        addRadioButton("lowered bevel",BorderFactory.createLoweredBevelBorder());
        addRadioButton("raised bevel",BorderFactory.createRaisedBevelBorder());
        addRadioButton("etched",BorderFactory.createEtchedBorder());
        addRadioButton("Line",BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("matte",BorderFactory.createMatteBorder(10,10,10,10,Color.RED));
        addRadioButton("empty",BorderFactory.createEmptyBorder());

        Border etched=BorderFactory.createEtchedBorder();
        Border titled=BorderFactory.createTitledBorder(etched,"Border");
        buttonpanel.setBorder(titled);

        setLayout(new GridLayout(2,1));
        add(buttonpanel);
        add(panel);
    }

    public void addRadioButton(String name,final Border b){
        JRadioButton button=new JRadioButton(name);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                panel.setBorder(b);
                validate();
            }
        });
        group.add(button);
        buttonpanel.add(button);
    }
}