//leetcode 1672-richest wealth customer
import java.util.*;
public class linear_max_wealth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[][] arr=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(max(arr));
    }
    public static int max(int [][] arr){
        int max=Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
                sum+=arr[i][j];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}
