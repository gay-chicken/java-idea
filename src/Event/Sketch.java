package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * $  java.awt.KeyEvent 1.2
 *      char getChar();
 *###  返回用户键入字符
 *
 *      int getKeyCode();
 *###  返回该键盘事件的虚拟键码
 *
 *      boolean isActionKey();
 *###  如果事件中的键是一个“动作键”，返回true。动作键:
 *                                            HOME
 *                                            END
 *                                            PAGE UP
 *                                            PAGE DOWN
 *                                            LEFT
 *                                            RIGHT
 *                                            F1~F24
 *                                            PRINT SCREEN
 *                                            SCROLL LOCK
 *                                            CAPS LOCK
 *                                            NUM LOCK
 *                                            PAUSE
 *                                            INSERT
 *                                            DELETE
 *                                            ENTER
 *                                            BACKSPACE
 *                                            TAB
 *
 *      static String getKeyText(int keyCode);
 *###  返回描述建码的字符串。VK_F将返回F字符
 *
 *      static String getKeyModifiersTest(int modifiers);
 *###  返回描述SHIFT或CTRL+SHIFT这类组合键的字符串。modifiers:修饰符状态
 */

/**
 * $  java.awt.event.InputEvent 1.1
 *      int getModifiers();
 *###  使用位来描述SHIFT、CONTROL、ALL和META修饰符的状态。该方法既可以用于键盘事件，也可以用于鼠标事件。若要检测某一位是否被设置，可以设置返回值是否对应位掩码
 *                                                                                                                                  SHIFT_MASK
 *                                                                                                                                  CTRL_MASK
 *                                                                                                                                  ALT_MASK
 *                                                                                                                                  ALT_GRAPH_MASK
 *                                                                                                                                  META_MASK
 *                                                                                                                   或调用方法来来检测。
 *                                                                                                                          boolean isShiftDown();
 *                                                                                                                          boolean isControlDown();
 *                                                                                                                          boolean isAltDown();
 *                                                                                                                          boolean isAltGraphDown();
 *                                                                                                                          boolean isAetaDown();
 *                                                                                                                          在事件发生时，若某个修饰键被按下，方法返回true。
 */

public class Sketch {
    public static void main(String[] args){
        SketchFrame frame=new SketchFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class SketchFrame extends JFrame {
    public SketchFrame(){
        setTitle("ScketchTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        SketchPanel panel=new SketchPanel();
        add(panel);
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class SketchPanel extends JPanel{
    private Point2D last;
    private ArrayList<Line2D> lines;

    private static final int SMALL_INCREMENT=1;
    private static final int LARGE_INCREMENT=5;

    public SketchPanel(){
        last=new Point2D.Double(100,100);
        lines=new ArrayList<Line2D>();
        KeyHandler listener=new KeyHandler();
        addKeyListener(listener);
        setFocusable(true);
    }

    public void add(int dx,int dy){
        Point2D end=new Point2D.Double(last.getX()+dx,last.getY()+dy);
        Line2D line=new Line2D.Double(last,end);

        lines.add(line);
        repaint();

        last=end;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g;

        for(Line2D l:lines) {
            gd.draw(l);
        }
    }

    private class KeyHandler implements KeyListener {
        @Override
        public void keyPressed(KeyEvent event){
            int keyCode=event.getKeyCode();
            int d=0;

            if(event.isShiftDown()) {
                d=LARGE_INCREMENT;
            } else {
                d=SMALL_INCREMENT;
            }

            if(keyCode==KeyEvent.VK_LEFT) {
                add(-d,0);
            } else if(keyCode==KeyEvent.VK_RIGHT) {
                add(d,0);
            } else if(keyCode==KeyEvent.VK_UP) {
                add(0,-d);
            } else if(keyCode==KeyEvent.VK_DOWN) {
                add(0,d);
            }
        }

        @Override
        public void keyReleased(KeyEvent event){}

        @Override
        public void keyTyped(KeyEvent event){
            char keyChar=event.getKeyChar();
            int d=0;

            if(Character.isUpperCase(keyChar))
            {
                d=LARGE_INCREMENT;
                keyChar=Character.toLowerCase(keyChar);
            }else{
                d=SMALL_INCREMENT;
            }

            if(keyChar=='h') {
                add(-d,0);
            } else if(keyChar=='l') {
                add(d,0);
            } else if(keyChar=='j') {
                add(0,d);
            } else if(keyChar=='k') {
                add(0,-d);
            }
        }
    }
}