package Assembly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * $  javax.swing.JComboBox 1.2
 *      void setEditable(boolean b);
 *###  组合框域是否可修改。true为可修改
 *
 *      void addItem(Object item);
 *###  将一个选项添加进列表中
 *
 *      void insertItemAt(Object item,int index);
 *###  将一个选项插入指定位置
 *
 *      void removeItem(Object item);
 *###  从列表中删除一个选项
 *
 *      void removeItemAt(int index);
 *###  删除指定位置的项
 *
 *      void removeAllItems();
 *###  删除所有的项
 *
 *      Object getSelectedItem();
 *###  返回当前选择的项目
 */
public class ComboBoxTest {
    public static void main(String[] args) {
        ComboBoxFrame frame = new ComboBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ComboBoxFrame extends JFrame {
    private static final int width = 300;
    private static final int height = 200;
    private JLabel label;
    private JPanel panel;
    private JComboBox combobox;

    public ComboBoxFrame(){
        setTitle("ComboBoxTest");
        setSize(width,height);

        label=new JLabel("Dog.");
        label.setFont(new Font("Serif",Font.BOLD,12));
        add(label,BorderLayout.CENTER);

        combobox=new JComboBox();
        combobox.setEditable(false);
        combobox.addItem("Serif");
        combobox.addItem("SansSerif");
        combobox.addItem("Monospaced");
        combobox.addItem("Dialog");
        combobox.addItem("DialogInput");

        combobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font((String)combobox.getSelectedItem(),Font.PLAIN,12));
            }
        });

        panel=new JPanel();
        panel.add(combobox);
        add(panel,BorderLayout.SOUTH);
    }
}