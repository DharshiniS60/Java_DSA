// unorder sorted array (with duplicates)
import java.util.*;

public class bs_search_in_rotated_usa {
    public static void main(String[] args) {
        int nums[]={2,2,8,9,0,1,2};
        int target =8;
        System.out.println(search(nums,target));
    }
    public static int search(int nums[],int target){
        int pivot=findpivotwithduplicates(nums);
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

    public static int findpivotwithduplicates(int arr[]){// pivot is the largest number
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
            //these two cases not possible for duplicate array
//            //3rd case
//            if(arr[start]<mid){
//                end=mid+1;
//            }
//            //4thcase
//            if(arr[start]>mid){
//                start=mid+1;
//            }

            //if the elements in start,end,middle are equal,just skip the duplicates
            if(arr[mid] == arr [start] && arr[mid] == arr[end]) {
                //just skip the duplicates
                //note that start or end can be pivot . check for it
                //check for start is pivit
                // 9>8 then pivot is start
                if (arr[start] > arr[start + 1]) {
                    return start; //beacuse it is a ppivot
                }
                //else skip
                start++;
                //check for end is pivot
                //... 9,8]
                // 8<9
                if (arr[end] < arr[end - 1]) {
                    return end - 1; //beacuse it is pivot
                }
                //else skip
                end--;
            }
                // left side is sorted ,so the pivot should be right
            // 2<9 || 2==9 && 9>4.. inthis case.. start =mid +1 bacuse element in right only
                else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid] >arr[end]){
                    start=mid+1;
            }else{
                    end=mid-1;
            }

        }
        return -1;
    }
}


