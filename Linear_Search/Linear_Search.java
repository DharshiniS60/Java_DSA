import java.util.*;
public class linera_search {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no of elements in an array");
        int a=sc.nextInt();
        int[] arr=new int[a];
        System.out.println("enter the elements in an array");
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the element to be searched");
        int k=sc.nextInt();
        int result=searching(arr,k);
        if (result==-1){
            System.out.println("element not found");

        }
        else{
            System.out.println("element found at index: "+result);
        }
    }
    public static int searching(int[] arr,int k){
        if(arr.length!=0) {
            for(int i=0;i<arr.length;i++){
                if(arr[i]==k){
                    return i;
                }
            }
        }
        return -1;
    }

}
