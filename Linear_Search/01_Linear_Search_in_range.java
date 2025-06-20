// search a element in range of index[1,4]
import java.util.*;
public class lineaer_search_in_range {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enetr thr no. of elemnets in an array");
        int a=sc.nextInt();
        System.out.println("enter the elements in an array");
        int[] arr=new int[a];
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the start");
        int start=sc.nextInt();
        System.out.println("enter the end");
        int end=sc.nextInt();
        System.out.println("enter the element to search");
        int tosearch=sc.nextInt();
        int result=searching(arr,start,end,tosearch);
        if(result==-1){
            System.out.println("not found");
        }
        else{
            System.out.println("found at "+result);
        }
    }
    public static int searching(int[] arr,int start,int end,int tosearch){
        if(arr.length!=0) {
            for(int i=start;i<end;i++){
                if(arr[i]==tosearch){
                    return i;
                }
            }
        }
        return -1;
    }
}
