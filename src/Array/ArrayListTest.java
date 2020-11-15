package Array;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> array=new ArrayList<>();//装载String类型,泛型只能是引用类型，不能是基本类型
        array.add("attack");
        array.add("composition");
        System.out.println(array);

        //基本数据类型，包装类
    }
}
