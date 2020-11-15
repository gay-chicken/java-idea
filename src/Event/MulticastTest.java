package Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 多个监听器共享一个事件
 */
public class MulticastTest {
    public static void main(String[] args){
        MulticastFrame frame=new MulticastFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class MulticastFrame extends JFrame {
    public MulticastFrame(){
        setTitle("MulticastTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        MulticastPanel panel=new MulticastPanel();
        add(panel);
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class MulticastPanel extends JPanel{
    public MulticastPanel(){
        JButton create=new JButton("New Frame");
        final JButton clear=new JButton("Close All");

        add(create);
        add(clear);

        ActionListener createList=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                BlankFrame frame=new BlankFrame(clear);
                frame.setVisible(true);
            }
        };

        create.addActionListener(createList);
    }
}

class BlankFrame extends JFrame{
    private static int sum=0;
    private ActionListener closeList;
    public static final int DEFAULT_WIDTH=200;
    public static final int DEFAULT_HEIGHT=150;
    public static final int SPACING=40;

    public BlankFrame(final JButton clear){
        sum++;
        setTitle("this frame is NO."+sum);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLocation(SPACING*sum,SPACING*sum);

        closeList=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clear.removeActionListener(closeList);
                sum=0;   //保证Close All后再New Frame的窗口不会超出屏幕
                dispose();
            }
        };

        clear.addActionListener(closeList);
    }
}