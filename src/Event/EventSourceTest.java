package Event;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;

/**
 * $  javax.swing.event.EventListenerList 1.2
 *      void add(Class c,EventList e);
 *###  将一个事件监听器和它的类添加列表中。存储这个类的原因是激活这个方法的事件可以有选择的调用事件。它的典型用法在addXxxListener中：
 *                                                                                  public void addXxxListener(XxxListener X){
 *                                                                                      listenerList.add(XxxListener.class,X);
 *                                                                                  }
 *                                                                                  c:监听器类型 X:监听器
 *
 *      void remove(Class c,EventListener e);
 *###  从列表中删除一个事件监听器和它的类。典型用法类似add方法。
 *
 *      EventListener[] getListener(Class c) 1.3
 *###  返回包含给定类型的所有监听器的数组。该数组保证不为null。
 *
 *      Object[] getListenerList();
 *###  返回一个数组，其偶数编号下标元素为监听器类，奇数下标元素为监听器对象。该数组保证不为null
 */

/**
 * $  java.beans.PropertyChangeEvent 1.1
 *      PropertyChangeEvent(Object source,String name,Object oldValue,Object newValue);
 * ###  构造一个能够变化的事件。source:事件源，为报告属性变化的对象.name:属性名。oldValue:变化前属性值。newValue:变化后属性值。
 */

/**
 * $  java.beans.PropertyChangeListener 1.1
 *      void PropertyChange(PropertyChangeEvent event);
 *###  属性值变化时调用该方法
 */
public class EventSourceTest {
    public static void main(String[] atgs){
        EventSourceFrame frame=new EventSourceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class EventSourceFrame extends JFrame {
    public EventSourceFrame(){
        setTitle("EventSourceTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        final PaintCountPanel panel=new PaintCountPanel();
        add(panel);

        panel.addPropertyChangeListener(new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent event){
                setTitle("Count--"+event.getNewValue());
            }
        });
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class PaintCountPanel extends JPanel{
    private int paintcount=0;
    @Override
    public void paintComponent(Graphics g){
        int oldpaintcount=paintcount;
        paintcount++;
        firePropertyChangeEvent(new PropertyChangeEvent(this,"paintcount",oldpaintcount,paintcount));
        super.paintComponent(g);
    }

    public void addProperyChangeListener(PropertyChangeListener listener){
        listenerList.add(PropertyChangeListener.class,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener){
        listenerList.remove(PropertyChangeListener.class,listener);
    }

    public void firePropertyChangeEvent(PropertyChangeEvent event){
        EventListener[] listeners=listenerList.getListeners(PropertyChangeListener.class);
        for(EventListener i:listeners) {
            ((PropertyChangeListener)i).propertyChange(event);
        }
    }

    public int getPaintCount(){
        return paintcount;
    }

}