package DesignPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StaticFactoryMethod {
    public static void main(String[] args) {
        Custom.RadonMethod();
        Custom.RadonMethod(555);
        Custom.RadonMethod("hello");
        Custom.Father();
        System.out.println("==================");
    }
}

class Custom extends Person{
    public Custom(){
        System.out.println("this no parameter constructor");
    }
    public Custom(int count){
        System.out.println("this count constructor");
    }
    public Custom(String text){
        System.out.println("this String constructor");
    }

    public static Custom RadonMethod(){
        return new Custom();
    }
    public static Custom RadonMethod(int count){
        return new Custom(count);
    }
    public static Custom RadonMethod(String text){
        return new Custom(text);
    }
    public static Person Father(){
        return new Person();
    }
}

@Deprecated
class Person{
    public Person(){
        System.out.println("Person");
    }
}
/*
public interface Service{

}
public interface Provider{
    Service newService();
}

class Service{
    private Service(){}
    private static final Map<String,Provider> providers=new ConcurrentHashMap<String,Provider>();
    public static final String DEFAULT_PROVIDER_NAME="<def>";

    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME,p);
    }
    public static void registerProvider(String name,Provider p){
        providers.put(name,p);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
    public static Service newInstance(String name){
        Provider p=providers.get(name);
        if(p==null){
            throw new IllegalArgumentException(
                    "No provider registered with name :"+name);
        }
        return p.newService();
    }
 */