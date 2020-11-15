package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * $  java.awt.event.MouseEvent  1.1
 *      int getX();
 *      int getY();
 *      int getPoint();
 *###  返回事件发生时，事件源组件左上角坐标，或点信息
 *
 *      void translatePoint(int x,int y);
 *###  通过水平移动x单位，垂直移动y单位来转换事件坐标
 *
 *      int getClickCount();
 *###  返回与事件相关联的鼠标连击次数（“连击”所指定的时间间隔与具体系统有关）
 */

/**
 * $  java.awt.event.InputEvent 1.1
 *      int getModifiersEx();  1.4
 *###  返回事件扩展的或“按下”(down)的修饰符。使用掩码值检测返回值:
 *                                                      BUTTON1_DOWN_MASK
 *                                                      BUTTON2_DOWN_MASK
 *                                                      BUTTON3_DOWN_MASK
 *                                                      SHIFT_DOWN_MASK
 *                                                      CTRL_DOWN_MASK
 *                                                      ALT_DOWN_MASK
 *                                                      ALT_GRAPH_DOWN_MASK
 *                                                      MATE_DOWN_MASK
 *
 *      static String getModifiersExText(int modifiers);
 *###  返回用给定标志集描述的扩展或“按下”（down）的修饰字符串，例如：“Shift+Button1”
 */

/**
 * $  java.awt.Toolkit 1.0
 *      public Cursor createCustomCursor(Image image,Point hotSpot,String name);
 *###  创建一个新的定制光标对象.image:光标活动时显示的图像。HotSpot：光标热点。 name:光标的描，用来支持特殊访问环境。
 */

/**
 * $  java.awt.Component 1.0
 *      public void setCursor(Cursor cursor);
 *###  用光标图像设置给定光标。
 */
public class MouseTest {
    public static void main(String[] args){
        MouseFrame frame=new MouseFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class MouseFrame extends JFrame {
    public MouseFrame(){
        setTitle("MouseTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        MousePanel panel=new MousePanel();
        add(panel);
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class MousePanel extends JPanel{

    private static final int SIDELENGTH=10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    private class MouseHandler extends MouseAdapter{

        @Override
        public void mousePressed(MouseEvent event){
            current=find(event.getPoint());
            if(current==null) {
                add(event.getPoint());
            }
        }

        @Override
        public void mouseClicked(MouseEvent event){
            current=find(event.getPoint());
            if(current==null && event.getClickCount()>=2) {
                remove(current);
            }
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        @Override
        public void mouseMoved(MouseEvent event){
            if(find(event.getPoint())==null) {
                setCursor(Cursor.getDefaultCursor());
            } else {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
        }

        @Override
        public void mouseDragged(MouseEvent event){
            if(current != null){
                int x=event.getX();
                int y=event.getY();

                current.setFrame(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
                repaint();
            }
        }
    }

    public MousePanel(){
        squares=new ArrayList<Rectangle2D>();
        current=null;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g;

        for(Rectangle2D i:squares) {
            gd.draw(i);
        }
    }

    public Rectangle2D find(Point2D point){
        for(Rectangle2D i:squares) {
            if(i.contains(point)) {
                return i;
            }
        }
            return null;
    }

    public void add(Point2D point){
        double x=point.getX();
        double y=point.getY();

        current=new Rectangle2D.Double(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);

        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D point){
        if(point==null) {
            return;
        }
        if(point==current) {
            current=null;
        }
        squares.remove(point);
        repaint();
    }
}
