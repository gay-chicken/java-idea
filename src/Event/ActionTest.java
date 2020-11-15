package Event;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 * 输入映射条件
 * WHEN_FOCUSED:当该组件拥有键盘焦点时
 * WHEN_ANCESTOR_OF_FOCUSED_COMPONENT:当该组件包含了拥有键盘焦点的组件时
 * WHEN_IN_FOCUSED_WINDOW:当该组件被包含在一个拥有键盘焦点组件的窗口时
 */
/**
 *$  javax.swing.Action 1.2
 *      void setEnabled(boolean b);
 *###  启用或禁用该动作
 *
 *      boolean isEnabled();
 *###  如果该动作被启用，返回true。
 *
 *      void putValue(String key,Object value);
 *###  将名-值对放置在动作对象内。
 *                          key:用动作对象存储性能的名字。可以是字符串，但预定义了几个名字。 value:与名字相关联的对象
 *
 *      Object getValue(String key);
 *###  返回已存储的名-值对的值
 */

/**
 * $  javax.swing.JMenu 1.2
 *      JMenuItem add(Action a);
 *###  将一个菜单项添加到菜单中，当选择这个菜单项时将调用动作a，并返回被添加的菜单项。
 */

/**
 * $  javax.swing.KeyStroke 1.2
 *      static keyStroke getKeyStroke(char keyChar);
 *###  创建一个KeyStroke对象，它封装了对应KEY_TYPED事件的一个击键。
 *
 *      static keyStroke getKeyStroke(int keyCode,int modifiers);
 *      static keyStroke getKeyStroke(int keyCode,int modifiers,boolean onRelease);
 *###  创建一个KeyStroke对象，它封装了对应KEY_PRESSED或KEY_RELEASED事件的一个击键。
 *###  keyCode:虚拟键码 modifiers:几个常量的组合：InputEventSHIFT_MASK,InputEvent.CTRL_MASK,InputEvent.ATL_MASK,InputEvent.META_MASK  onRelease:当键被释放时，如果击键被识别，则返回true。
 *
 *      static keyStroke getKeyStroke(String description);
 *###  根据一个说明性描述构造击键。说明性描述是由空白符分割的字符序列，其格式为：
 *                                                                A。字符串shift control ctrl meta alt button1 button2 button3转换为相应的掩码.
 *                                                                B。字符串typed必须紧跟一个只有一个字符的字符串，如“typed a”
 *                                                                C。字符串pressed或released表示按下一个键或释放一个键。（默认为按下）
 *                                                                D。若不使用空格做分割，则使用前缀为VK_的字符串对应一个KeyEvent常量，例如，“INSERT"对应KeyEvent,
 *                                                                   "released ctrl Y"对应getKeyStroke(KeyEvent.VK_Y,Event.CTRL_MASK,true)。
 */

/**
 * $  javax.swing.JComponent 1.2
 *      ActionMap getActionMap() 1.3
 *###  返回将击键映射到动作键的动作映射。
 *
 *      InputMap getInputMap(int flag); 1.3
 *###  将得到的动作键映射到动作对象的输入映射。flag :触发动作的的键盘焦点条件,即输入映射条件。
 */
public class ActionTest {
    public static void main(String[] args){
        ActionFrame frame=new ActionFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ActionFrame extends JFrame {
    public ActionFrame(){
        setTitle("ActionTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        ActionPanel panel=new ActionPanel();
        add(panel);
    }
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
}

class ActionPanel extends JPanel{
    public ActionPanel(){
        Action yellowAction=new ColorAction("Yellow",new ImageIcon("Z:\\image\\1_icon.png"), Color.YELLOW);
        Action blueAction=new ColorAction("blue",new ImageIcon("Z:\\image\\3_icon.png"),Color.BLUE);
        Action redAction=new ColorAction("red",new ImageIcon("Z:\\image\\2_icon.png"),Color.RED);

        add(new JButton(yellowAction));
        add(new JButton(redAction));
        add(new JButton(blueAction));

        InputMap map=getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        map.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        map.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
        map.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");

        ActionMap actionmap=getActionMap();
        actionmap.put("panel.yellow",yellowAction);
        actionmap.put("panel.blue",blueAction);
        actionmap.put("panel.red",redAction);
    }
    public class ColorAction extends AbstractAction{
        public ColorAction(String name, Icon icon, Color color){
            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,icon);
            putValue(Action.SHORT_DESCRIPTION,"set panel color to "+name.toLowerCase());
            putValue("color",color);
        }

        @Override
        public void actionPerformed(ActionEvent event){
            Color c=(Color)getValue("color");
            setBackground(c);
        }

    }
}