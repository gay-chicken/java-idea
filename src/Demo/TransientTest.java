package Demo;

import java.io.*;

public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Kite");
        user.setPass("2000");

        System.out.println("read before Serializable");
        System.out.println("name:"+user.getName());
        System.out.println("pass:"+user.getPass());

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D://user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //User.name = "Jaa";
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("D://user.txt"));
            user = (User) is.readObject();
            is.close();

            System.out.println("\nread after Serializable");
            System.out.println("name:"+user.getName());
            System.out.println("pass:"+user.getPass());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    public static String name;
    private transient String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        User.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
