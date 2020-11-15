package dam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestDialog implements ActionListener{
    private Label info;
    private Dialog loginDialog;
    private Dialog quitDialog;
    private TextField tf_name;
    private TextField tf_psw;

    public static void main( String[] args) {
        new TestDialog().init();
    }

    public void init(){
        JFrame f = new JFrame("Frame");
        Button login = new Button("Login");
        Button register = new Button("register");
        Button help = new Button("Help");
        Button exit = new Button("Exit");
        Panel p = new Panel();
        p.setLayout(new GridLayout(1,4));
        p.add(login);
        p.add(register);
        p.add(help);
        p.add(exit);
        info = new Label("Please login...");
        f.add(p,"North");
        f.add(info,"Center");

        login.addActionListener(this);
        exit.addActionListener(this);
        f.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                TestDialog.this.quit();
            }
        });
        f.setSize(500,350);
        f.setLocation(450,200);
        f.setVisible( true);
        loginDialog = this.createLoginDialog(f);
        quitDialog = this.createQuitDialog(f);
    }

    public Dialog createLoginDialog(JFrame f){
        Dialog d = new Dialog(f,"Login Window",true);
        Label note = new Label("Please enter your information");

        Panel pa = new Panel();
        pa.setLayout(new GridLayout(2,1));
        pa.add(new Label("Account:"));
        pa.add(new Label("Password:"));

        Panel pc = new Panel();
        pc.setLayout(new GridLayout(2,1));
        tf_name = new TextField();
        tf_psw = new TextField();
        tf_psw.setEchoChar('*');
        pc.add(tf_name);
        pc.add(tf_psw);

        Panel pb = new Panel();
        pb.setLayout(new GridLayout(1,2));
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        submit.setActionCommand("submitLogin");
        cancel.setActionCommand("cancelLogin");
        submit.addActionListener(this);
        cancel.addActionListener(this);
        pb.add(submit);
        pb.add(cancel);

        d.add(note,"North");
        d.add(pa,"West");
        d.add(pc,"Center");
        d.add(pb,"South");
        d.setSize(160,120);
        d.setLocation(400,200);
        return d;
    }

    public Dialog createQuitDialog(JFrame f){
        Dialog d = new Dialog(f,"Exit",true);
        Label note = new Label("Exit？");
        Panel p = new Panel();
        //p.setLayout(new GridLayout(1,2));
        Button confirm = new Button("Confirm");
        Button cancel = new Button("Cancel");
        confirm.setActionCommand("confirmQuit");
        cancel.setActionCommand("cancelQuit");
        confirm.addActionListener(this);
        cancel.addActionListener(this);
        p.add(confirm);
        p.add(cancel);
        d.setSize(160,120);
        d.setLocation(400,200);
        d.add(note,"Center");
        d.add(p,"South");
        return d;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        //多重else if结构可考虑使用switch结构来优化代码
        if("Login".equals(s)){
            loginDialog.setVisible(true);
        }else if("Exit".equals(s)){
            this.quit();
        }else if("confirmQuit".equals(s)){
            System.exit(0);
        }else if("cancelQuit".equals(s)){
            quitDialog.setVisible(false);
        }else if("submitLogin".equals(s)){
            String name = tf_name.getText();
            String password = tf_psw.getText();
            if("Scott".equals(name) && "Tiger".equals(password)){
                info.setText("Welcome to: " + name + " Admin");
            }else{
                info.setText("Verification failed!");
            }
            loginDialog.setVisible(false);
        }else if("cancelLogin".equals(s)){
            loginDialog.setVisible(false);
        }
    }

    public void quit(){
        quitDialog.setVisible(true);
    }
}