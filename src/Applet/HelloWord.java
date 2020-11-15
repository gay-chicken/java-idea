package Applet;

import javax.swing.*;

/*
<applet code="HelloWord.class" width="300" height="200">
</applet>
 */
public class HelloWord extends JApplet{
        @Override
        public void init(){
            JLabel label=new JLabel("Hello Word!",SwingConstants.CENTER);
            add(label);
        }
}
