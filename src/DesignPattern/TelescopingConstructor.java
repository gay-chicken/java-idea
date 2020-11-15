package DesignPattern;

public class TelescopingConstructor {
    public static void main(String[] args) {
        NutritionFacts tree=new NutritionFacts.Builder(121,24).build();
        System.out.println(tree.size+"  "+tree.count+"    "+tree.height);
    }
}

class NutritionFacts{
    public final int size;
    public final int count;
    public  int height;

    public static class Builder{
        private final int size ;
        private final int count;
        private int height;

        public Builder(int size,int count){
            this.size=size;
            this.count=count;
        }

        public Builder Height(int value){
            height=value;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        size=builder.size;
        count=builder.count;
        height=builder.height;
    }

}
