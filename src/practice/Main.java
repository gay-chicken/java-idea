package practice;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.lang.Math;
public class Main{
    /*
    在当前的版本中，构造器带参数无需显示定义无参构造器；
    Main(String name){
        System.out.println("name");
    }
    */

    /*
    对方法名不应该有连字符
    类名应以大写字母开头

     */
    //分割字符串方法
    //char[] split(String){}
    //char[] split(String,int){}

    //对字符串进行顺序排序方法Math子方法
    //char[] sort(char[]){ return char[]; }
    public static void main(String[] args){
        /*
       Class person=practice_five.class;

       // 获取所有成员变量
        Field[] field=person.getFields();

        Field fields=person.getField(practice_five.sub);

        System.out.println(field[0]);
        */


        StringBuilder SB=new StringBuilder("123aege");

        //链式编程
        SB.append("SFA").append("").append("").append("");

        String str=new String(SB);
        StringBuilder sb=new StringBuilder(str);
        System.out.println("");
    }


}
/*
反射：将类的各个组成部分封装成其他对象==反射机制

        可以再程序运行阶段操作对象
        可以降低程序耦合度，增加程序可扩展度
        such as：
        person类

源代码阶段
java->class
class:字节码文件

        class类对象阶段
        类加载器：class类对象
        {
            成员变量Field
        构造方法Constructor
        成员方法Method
        }

类 实例名=类。

类加载器-》将字节码文件加载进内存


运行时阶段runtime

*/
/**
 * 成员变量：Field
 * 对获取的成员变量有一定的操作
 * 读取:      getField(Object)；
 * 修改:      setField(Object);
 * 
 *
 *
 * */