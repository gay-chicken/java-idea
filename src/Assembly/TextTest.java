package Assembly;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * $  javax.swing.JComponent 1.2
 *      void setPerferredSize(Dimension d);
 *###  设置组件首选的大小
 */

/**
 * $  javax.swing.text.Document 1.2
 *      int getLength();
 *###  返回当前文档的字符个数
 *
 *      String getText(int offset,int Length);
 *###  返回文档中给定部分所包含的文本。offset:文本起始偏移量。 Length:需要的字符长度.
 *
 *      void addDocumentListener(DocumentListener listener);
 *###  注册监听器来监听文档改变时的通知。
 */

/**
 * $  javax.swing.event.DocumentEvent 1.2
 *      Document getDocument();
 *###  获得作为事件源的文档
 */

/**
 * $  javax.swing.event.DocumentListener 1.2
 *      void changeUpdate(DocumentEvent event);
 *###  当一个属性或属性集发生改变时被调用
 *
 *      void insertUpdate(DocumentEvent event);
 *###  当一个文档发生插入操作时被调用
 *
 *      void removeUpdate(DocumentEvent event);
 *###  当文档发生删除操作时被调用。
 */

/**
 * $  javax.swing.JPasswordField 1.2
 *      JPasswordField(String text,int columns);
 *###  构造一个新的密码域。text:将要显示的文本.  columns:列数
 *
 *      void setEchoChar(char echo);
 *###  为密码域设置回显字符。特殊的观感可以选择自己的回显字符，0表示重置为默认的回回显字符。
 *
 *      char[] getPassword();
 *###  返回密码域中的文本。为了安全起见，应在使用之后覆写返回数组的内容。
 */
public class TextTest {
    public static void main(String[] args){
        TextFrame frame=new TextFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TextFrame extends JFrame {

    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=300;
    private JTextField hourField;
    private JTextField minuteField;
    private ClockPanel clock;

    public TextFrame(){
        setTitle("TextTest");
//        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        DocumentListener listener=new ClockFieldListener();

        JPanel panel=new JPanel();

        minuteField=new JTextField("00",3);
        hourField=new JTextField("12",3);

        panel.add(new JLabel("hours:"));
        panel.add(hourField);
        panel.add(new JLabel("minutes:"));
        panel.add(minuteField);

        minuteField.getDocument().addDocumentListener(listener);
        hourField.getDocument().addDocumentListener(listener);

        add(panel, BorderLayout.SOUTH);
        clock=new ClockPanel();
        add(clock,BorderLayout.CENTER);

        pack();
    }

    public void setClock(){
        try{
            int hours=Integer.parseInt(hourField.getText().trim());
            int minutes=Integer.parseInt(minuteField.getText().trim());
            clock.setTime(hours,minutes);
        }catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("program error!!!");
        }
    }

    private class ClockFieldListener implements DocumentListener{
        @Override
        public void insertUpdate(DocumentEvent event){
            setClock();
        }

        @Override
        public void removeUpdate(DocumentEvent event){
            setClock();
        }

        @Override
        public void changedUpdate(DocumentEvent event){}

    }
}

class ClockPanel extends JPanel{

    private double minutes=0;
    private int RADIUS=100;
    private double MINUTE_HAND_LENGTH=0.8*RADIUS;
    private double HOUR_HAND_LENGTH=0.6*RADIUS;

    public ClockPanel(){
        setPreferredSize(new Dimension(2*RADIUS+1,2*RADIUS+1));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g;
        Ellipse2D circle=new Ellipse2D.Double(0,0,2*RADIUS,2*RADIUS);
        gd.draw(circle);

        double hourAngle=Math.toRadians(90-360*minutes/(12*60));
        double minuteAngle=Math.toRadians(90-360*minutes/60);

        drawHand(gd,minuteAngle,MINUTE_HAND_LENGTH);
        drawHand(gd,hourAngle,HOUR_HAND_LENGTH);
    }

    public void drawHand (Graphics2D gd,double angle,double handlength){
        Point2D end=new Point2D.Double(RADIUS+handlength*Math.cos(angle),RADIUS-handlength*Math.sin(angle));
        Point2D center=new Point2D.Double(RADIUS,RADIUS);
        gd.draw(new Line2D.Double(center,end));
    }

    public void setTime(int hour,int minute){
        minutes=hour*60+minute;
        repaint();
    }
}