//leetcode1295
import java.util.*;
public class linear_search_even_digit {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(digits(arr));
        System.out.println(digitsfind2(68375));
    }
//    enter the size
//2
//        2345 9339842
//        1
//        5
    public static int digits(int[] arr){
        int count=0;
        for(int i:arr) {

            if (even(i)) {
               count++;
            }
        }
        return count;
    }
    public static boolean even(int i){
        int noofeven=finding(i);
        if(noofeven%2==0){
            return true;
        }
        else{
            return false;
        }
    }
    //other way better time complexity
    public static int digitsfind2(int i){
        if(i<0){
            i=i*-1;
        }
        return (int)(Math.log10(i)+1);
    }
    public static int finding(int i){
        //for negative
        if(i<0){
            i=i*-1;
        }
        if(i ==0){
            return 1;
        }
        int count=0;
        while(i>0){
            count++;
            i/=10;

        }
        return count;
    }
}

