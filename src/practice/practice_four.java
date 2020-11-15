package practice;

public class practice_four<T> {
    //使用void修饰，变成一个方法
    //无任何修饰符，为一个构造器
    practice_four(){
        System.out.println("这是一个构造器");
    }
    void practice_four(){
        System.out.println("这是一个方法");
    }

    public static <T> T collention(){
        T t=null;

        return t;
    }

}
