//leetcode 33
import java.util.*;
public class bs_search_in_rotated_sa {
    public static void main(String[] args){
        int nums[]={4,5,6,7,0,1,2};
        int target =6;
        System.out.println(search(nums,target));

    }
    public static int search(int nums[],int target){
        int pivot=findpivot(nums);
        if(pivot==-1) {
            //no found pivot so arry is not rotated , so do just simple bs
            return searching(nums,target,0,nums.length-1);
        }
        //if pivot found them , 2 asc sorted array
        if(nums[pivot]==target){
            return pivot;
        }
        if(target >= nums[0]){
            return searching(nums,target,0,pivot-1);
        }
        return searching(nums,target,pivot+1,nums.length-1);
    }
    public static int searching(int[] arr, int target,int start,int end) {
       // int start = 0;
        //int end = arr.length - 1;
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

    public static int findpivot(int arr[]){// pivot is the largest number
        int start=0;
        int end=arr.length-1;
        //bs
        while(start <= end){
            int mid=start+ (end-start)/2;
            //4 case
            // 1st case
            if(mid <end && arr[mid]>arr[mid+1]){ //2nd condition mid may be last eemnt of array so 1st condtion added
                return mid;
            }
            //2nd case
            if(mid >start && arr[mid]< arr[mid-1]){
                return mid-1;
            }
            //3rd case
            if(arr[start]<mid){
                end=mid+1;
            }
            //4thcase
            if(arr[start]>mid){
                start=mid+1;
            }
        }
        return -1;
    }
}

