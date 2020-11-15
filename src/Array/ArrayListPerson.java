package Array;

import java.util.ArrayList;

public class ArrayListPerson {
    public static void main(String[] args){
        Person student=new Person(11,"张三");
        Person teacher=new Person(28,"刘六");

        ArrayList<Person> array=new ArrayList<>();
        array.add(student);
        array.add(teacher);
        System.out.println(array);
    }
}

class Person{
    private int age;
    private String name;

    public Person(){}
    public Person(int age,String name){this.age=age;this.name=name;}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
