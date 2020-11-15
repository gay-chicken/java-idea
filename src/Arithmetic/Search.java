package Arithmetic;

public class Search {
    //暴力子字符串查找
    public static int search(String pat,String txt){
        int i,M=pat.length();
        int j,N=txt.length();
        for(i=0,j=0;i<N && j<M;i++){
            if(txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else{
                i-=j;
                j=0;
            }
        }
        if(j == M) {
            return i-M;
        } else {
            return N;
        }
    }

    public static void main(String[] args) {
        int index=search("hello","wocaonimadehelloworld");
        System.out.println(index);
    }
}
