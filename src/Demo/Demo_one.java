package Demo;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;


/**
 *$ java.awt.geom.RectangularShape 1.2
 *   double
 *          getCenterX();
 *          getCenterY();
 *          getMinX();
 *          getMinY();
 *          getMaxX();
 *          getMaxY();
 * ### 返回闭合矩形的中心，以及最大、最小的X、Y坐标值
 *
 *   double
 *          getWidth();
 *          getHeight();
 *###  返回闭合矩形的宽和高
 *
 * double
 *          getX();
 *          getY();
 *###  返回矩形左上角的X、Y坐标值;
 */

/**
 * $ java.awt.geom.Rectangle2D.Double 1.2
 *  Rectangle2D.Doble(double x,double y,double w,double h);
 *  ###  使用给定左上角、宽、高构建一个矩形
 */

/**
 * $  java.awt.geom.Rectangle2D.Float 1.2
 *      Rectangle2D.Float(float x,float y,float w,folat h);
 *###  使用给定左上角、宽高构建一个矩形
 */

/**
 * $ java.awt.geom.Ellipse2D 1.2
 *      Ellipse2D.Double(double x,double y,double w,double h);
 *###  使用给定左上角、宽、高的矩形构建一个内接椭圆
 */

/**
 * $ java.awt.geom.Point2D 1.2
 *      Point.Double(double x,double y);
 *###  使用给定坐标绘制一个点
 */

/**
 * $ java.awt.geom.Line2D 1.2
 *     Line2D.Double(Point2D start,Point2D end);
 *     Line2D.Double(double startX,double startY,double endX,double endY);
 *###  使用给定起点和终点绘制一条直线
 */

public class Demo_one {
    public static void main(String[] args){
        Draw frame=new Draw();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Draw extends JFrame{
    public Draw(){
        setTitle("DrawTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGH);

        DrawPanel panel=new DrawPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH=400;
    public static final int DEFAULT_HEIGH=400;

}

class DrawPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D gd=(Graphics2D)g;

        double LEFT_X=100;
        double TOP_Y=100;
        double WIDTH=200;
        double HEIGH=150;

        Rectangle2D rect=new Rectangle2D.Double(LEFT_X,TOP_Y,WIDTH,HEIGH);

        Ellipse2D ellipse=new Ellipse2D.Double();
        ellipse.setFrame(rect);
        gd.draw(ellipse);

        gd.draw(new Line2D.Double(LEFT_X,TOP_Y,LEFT_X+WIDTH,TOP_Y+HEIGH));

        double centerX=rect.getCenterX();
        double centerY=rect.getCenterY();
        double RADIUS=150;

        Ellipse2D cricle=new Ellipse2D.Double();
        cricle.setFrameFromCenter(centerX,centerY,centerX+RADIUS,centerY+RADIUS);
        gd.draw(cricle);
    }
}
