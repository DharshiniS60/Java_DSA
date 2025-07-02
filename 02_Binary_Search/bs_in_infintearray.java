import java.util.*;
//actually infinte arra is impossible in scanner a standard is given

public class bs_in_infintearray {
    public static void main(String[] args) {

        int[] arr={ 2, 4 , 6 , 7 , 9, 10, 33, 45, 78, 89, 90, 100,130,899,900};

        int target=90;
        int ans=result(arr,target);
        System.out.println(ans);
    }
    public static int result(int[] arr, int target){
        int start=0;
        int end=1; // take neigbor rlmrnrt and check the elemnt found it not double the size
        while (target > arr[end]){ // if target is max then end then the target is also max than start no need tto check start
            int temp=end+1; //this is the new start
            end=end+(end-start+1)*2;  // here the original start value is used so we took temp and stored the new start; else the flow makes the wrong
            // end doubles
            start=temp; // after end update the start changed


        }
        return searching(arr,target,start,end);
    }
    public static int searching(int[] arr, int target,int start,int end) {
//        int start = 0;
//        int end = arr.length - 1;no possible beacuse of infinite ,but we can takr arr.lengh but it is not allowed to use length function
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

        return -1;
    }
}
