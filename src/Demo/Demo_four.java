package Demo;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
/**
 * ——————————————————————————————上坡度
 *             ****
 *           **    **
 *          **********
 *          **
 *          **       **
 *           *******
 *———————————————————————————————基线———————————————————+
 * ——————————————————————————————下坡线——>行间距          |
 * —————————————————————————————————————>行间距          |
 *                                                      |
 *                                                      |
 *                  第二行                              高度
 *                                                      |
 *                                                      |
 *                                                      |
 *                                                      |
 * ————————————————————————————————————————————————————基线
 */

/**
 * $ java.awt.Font 1.0
 *      Font(String name,int style,int size);
 *###  创建一个字体对象
 *              name:字体名
 *              style:字体风格.常规、粗体、斜体、粗斜体（Font.PLAIN,Font.BOLD,Font.ITALIC,Font.BOLD+Font.ITALIC)
 *              size:字体大小
 *
 *      String getFontName();
 *###  返回字体名
 *
 *      String getFamily();
 *### 返回字体家族名
 *
 *      String getName();
 *###  如果采用逻辑字体名创建字体，将返回逻辑名。否则返回字体名
 *                          tip:逻辑名：Java中定义的五种字体名，映射到系统上的字体名   字体名：系统中已安装有的字体
 *
 *      Rectangle2D getStringBounds(String s,FontRenderContext context);
 * ###  返回包围字符串s的矩形。矩形的起点为基线。矩形顶端的y坐标等于上坡度的负值。矩形的高度等于上坡度、下坡度和行间距之和，宽度等于字符串的宽度。
 *
 *      LineMetrics getLineMetrics(String s,FontRenderContext context);
 * ###  返回确定字符串宽度的一个线性metrics对象
 *
 *      Font deriveFont(int style);
 *      Font deriveFont(float size);
 *      Font deriveFont(int style,float size);
 *###  返回一个指定大小和风格的新字体
 */

/**
 * $  java.awt.font.LineMetrics;
 *      float getAscent();
 *###  返回字体的上坡度————基线到字符串顶端的距离
 *
 *      float getDescent();
 *###  返回字体的下坡度————基线到坡的距离
 *
 *      float getLeading();
 *###  返回字体的行间距————从从一行文本到下一行文本的距离
 *
 *      float getHeight();
 *###  返回字体的总高度————两条文本基线的距离（下坡度+行间距+上坡度）
 */

/**
 * $ java.awt.Graphics 1.0
 *      void setFont(Font font);
 *### 为图形环境选择一种字体。
 *
 *      void drawString(String string,int x,int y);
 *###  绘制string字符串。x：字符串开始的坐标；y：字符串基线坐标
 */

/**
 * $ java.awt.Graphics2D 1.2
 *      FontRenderContext getFontRenderContext();
 *#
 */
public class Demo_four {
    public static void main(String[] args){
        //System.out.printlnfont("\u2297");
        FontFrame frame=new FontFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class FontFrame extends JFrame{
    public FontFrame(){
        setTitle("TestFrame");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        FontPanel panel=new FontPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH=400;
    public static final int DEFAULT_HEIGHT=400;
}

class FontPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g;

        String hello="hello,world!";

        Font font=new Font("Serif",Font.BOLD,36);
        gd.setFont(font);

        FontRenderContext context=gd.getFontRenderContext();
        Rectangle2D bounds=font.getStringBounds(hello,context);

        double x=(getWidth()-bounds.getWidth())/2;
        double y=(getHeight()-bounds.getHeight())/2;

        double ascent=-bounds.getY();
        double baseY=y+ascent;

        gd.drawString(hello,(int)x,(int)baseY);
        gd.setPaint(Color.red);

        gd.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));

        Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
        gd.draw(rect);
    }
}
