package dam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    JPanel panel;
    JButton enter;
    JButton cancel;
    JTable table;
    public Frame(){

        //设置框架属性
        setSize(300,450);
        setTitle("TTA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //初始化组件
        panel=new JPanel();
        enter=new JButton("确认");
        cancel=new JButton("取消");
        table=new JTable(5,3);


        //添加“取消”按钮点击事件：关闭程序
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //将组件添加至框架
        panel.add(table);
        panel.add(enter);
        panel.add(cancel);
        add(panel);
    }
}

class Dialog extends JDialog{
    public Dialog(JFrame f,String title,boolean b){//b为true代表的是强制型对话框，在对话框没有结束前无法对窗体其他事件做出响应

    }
}