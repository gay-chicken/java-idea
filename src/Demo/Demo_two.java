package Demo;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * setBackgrounp(color);
 * class Color{
 *     void brighter(){}//加亮，可多次调用c.brighter().brighter().brighter();
 *     void darker(){}//加暗
 * }
 */

/**
 * $ java.awt.Color 1.0
 *      Color(int red,int green,int blue);
 * ###  创建一个颜色对象
 *
 * $ java.awt.Graphics 1.0
 *      void setColor(Color c);
 *###  改变当前颜色为c
 *
 * $ java.awt.Graphics2D 1.2
 *      void setPaint(Paint p);
 *###  设置图形环境的绘制属性，-//Color类实现了Component类，所以可以使用该方法来将绘制属性设置为纯色
 *
 * $ java.awt.Component 1.0
 *      void setBackground(Color c);
 *###  设置背景颜色
 *      void setForeground(Color c);
 *###  设置前景颜色
 *
 * --------------------------------------------
 * //匹配系统颜色
 * p.setBackground(SystemColor.desktop);
 * 颜色代码：
 * desktop========================桌面的背景颜色
 * activeCaption==================标题的背景颜色
 * activeCaptionText==============辩题的文本颜色
 * activeCaptionBorder============标题的边框颜色
 * inactiveCaption================非活动标题的背景颜色
 * inactiveCaptionText============非活动标题的文本颜色
 * inactiveCaptionBorder==========非活动标题的边框颜色
 * window=========================窗口的背景
 * windowBorder===================窗口边框的颜色
 * windowText=====================窗口文本的颜色
 * menu===========================菜单的背景颜色
 * menuText=======================菜单的文本颜色
 * text===========================文本的背景颜色
 * textText=======================文本的前景颜色
 * textInactiveText===============非活动组件的文本颜色
 * textHighlight==================高亮文本的背景颜色
 * textHighlightText==============高亮文本的文本颜色
 * control========================组件的背景颜色
 * controlText====================组件的文本颜色
 * controlLtHighLight=============组件的浅亮颜色
 * controlHighlight===============组件的高亮颜色
 * controlShadow==================组件的阴影颜色
 * scrollbar======================滚动条的背景颜色
 * info===========================帮助区文本的背景颜色
 * infoText=======================帮助区文本颜色
 */
public class Demo_two {
    public static void main(String[] args){
        FillFrame frame=new FillFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class FillFrame extends JFrame{
    public FillFrame(){
        setTitle("FillTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        FillPanel panel=new FillPanel();
        add(panel);
    }
    public static final int DEFAULT_WIDTH=400;
    public static final int DEFAULT_HEIGHT=400;
}

class FillPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g;

        double LEFT_X=100;
        double TOP_Y=100;
        double WIDTH=200;
        double HEIGHT=150;

        Rectangle2D rect=new Rectangle2D.Double(LEFT_X,TOP_Y,WIDTH,HEIGHT);
        gd.setPaint(Color.RED);
        gd.fill(rect);

        Ellipse2D ellipse=new Ellipse2D.Double();
        ellipse.setFrame(rect);
        gd.setPaint(new Color(0,128,128));
        gd.fill(ellipse);
    }
}