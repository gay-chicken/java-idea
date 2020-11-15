package Demo;

interface fly {
    // 接口中可以定义变量，但会被隐式的定义成public static final
    // 方法会被隐式的修饰为public abstract也仅能修饰成如此
    // public static final int l=1;
    void fly();
}

public class AbstractTest{
    public static void main(String[] args) {
        bird a = new yellow();
        airplane b = new blue();
        a.fly();
        b.fly();
    }
}


// 抽象类就是为了继承而设计的,方法不能被private修饰,否则无法被子类继承
abstract class airplane implements fly{
    @Override
    public void fly() {
        System.out.println("airplane");
    }
}
abstract class bird implements fly{
    @Override
    public void fly() {
        System.out.println("bird");
    }
}

class yellow extends bird {
    @Override
    public void fly() {
        super.fly();
    }
}
class blue extends airplane {
    @Override
    public void fly() {
        super.fly();
    }
}