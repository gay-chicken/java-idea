package Demo;

import java.awt.*;

public class Demo_three {
    public static void main(String[] args){
        String[] fontNames= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        int sum=0;
        for(String getNames:fontNames) {
            System.out.println(getNames);
            sum++;
        }
        System.out.println("字体总数为:"+sum);
    }
}
