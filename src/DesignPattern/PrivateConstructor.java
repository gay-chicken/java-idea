package DesignPattern;

public class PrivateConstructor {
    public static final PrivateConstructor VALUE=new PrivateConstructor();//受保护的构造器，无法被改变
    private PrivateConstructor(){    }//仅被调用一次，用于初始化VALUE
    public static PrivateConstructor getInstance(){return VALUE;}//防止通过反射获得私有构造器
    public void leaveTheBuilding(){    }
    private Object readResolve(){ return VALUE; }//维护Singleton，防止每次反序列化一个序列化的实例时，会创建一个新的实例。另一种方法为使用enum
}
/*
public enum PrivateConstructor{
    VALUE;

    public void leaveTheBuilding(){    }
}

 */