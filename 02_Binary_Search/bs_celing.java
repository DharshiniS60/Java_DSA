import java.util.*;
//celing should return target's smallest greater element or equal to

// same as bs retuen and 1 codition is addeed
public class bs_celing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size");
        int size=sc.nextInt();
        int[] arr=new int[size];
        System.out.println("enter the elements enter soretd or sort it using arrays.sort");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the target element");
        int target=sc.nextInt();
        int ans=searching(arr,target);
        System.out.println(ans);
    }
    public static int searching(int[] arr, int target) {

        // the codition to be addeed
        if(target>arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //int mid =(start-end)/2;
            //the problem in this statment is that the interger has the limit that start +end may give large nummber so the neww calculation
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start=mid+1; //descending end=mid -1
            }
            else if(target < arr[mid]){
                end=mid-1;  //descending start=mid +1
            }
            else{
                return mid;
            }
        }
        return start; // this return the celing element index
        //return arr[start]; this return the celing element itself
    }
}
