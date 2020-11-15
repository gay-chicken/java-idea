package Assembly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * $ javax.swing.JTextArea 1.2
 *      JTextArea(int rows,int cols);
 *###  构造一个新的文本域。rows:行数，cols:列数
 *
 *      JTextArea(String text,int cols);
 *###  用初始文本构造一个文本域。text:初始文本
 *
 *      void setColumns(int cols);
 *      void setRows(int rows);
 *###  设置文本域应该使用的首选行数、列数。
 *
 *      void append(String text);
 *###  将text附加到文本域已有文本的尾部。
 *
 *      void setLineWrap(boolean wrap);
 *###  打开或关闭换行。wrap:true打开换行。
 *
 *      void setWrapStyleWord(boolean word);
 *###  是否在字边界换行。word:true为在字边界换行。
 *
 *      void setTabSize(int c);
 *###  设置跳格（tab stop）为c列，跳格不会转换为空格，但它们能让文本对齐到下一个跳格处。
 */

/**
 * $  javax.swing.JScrollPane 1.2
 *      JScrollPane(Component com);
 *###  创建一个显示指定组件内容的滚动窗格。当组件超过显示范围时，滚动条自动出现。
 */

public class AreaTextTest {
    public static void main(String[] args){
        AreaFrame frame=new AreaFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class AreaFrame extends JFrame {

    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=300;

    private JTextArea text;
    private JScrollPane scroll;
    private JPanel panel;
    private JButton wrapbutton;

    public AreaFrame(){
        setTitle("AreaTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        panel=new JPanel();

        JButton insert=new JButton("insert");
        panel.add(insert);
        insert.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                text.append("look at me! ");
            }
        });

        wrapbutton=new JButton("wrap");
        panel.add(wrapbutton);
        wrapbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                boolean wrap=!text.getLineWrap();
                text.setLineWrap(wrap);
                scroll.revalidate();
                wrapbutton.setText(wrap?"no wrap":"wrap");
            }
        });

        add(panel, BorderLayout.SOUTH);

        text=new JTextArea(8,30);
        scroll=new JScrollPane(text);

        add(scroll,BorderLayout.CENTER);
    }
}