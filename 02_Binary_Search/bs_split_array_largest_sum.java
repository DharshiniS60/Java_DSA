// leetcode 410
//bs concept
// split array largest sum
//hard
//qyestion
//Given an array nums which consists of non-negative integers and an integer, you can split the array into m non-empty continuous subarrays.
//Write an algorithm to minimize the largest sum among these subarrays.
//Example 1:
//Input:
//nums = [7,2,5,10,8], m = 2
//Output: 18
//Explanation;
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8), where the largest sum among the two subarrays is only 18.
// by seieng it is not a bs thats y hard
//my expallanation
/*
[7,2,3,10,8] ---> possbilty to spliting of array & it should be split int m=2 which is 2 subarray as continouse
like---> 1st casr[7,2,3,10] & [8]  =>sum =24,8  ===>largest=24
-->[7,2,3] & [10,8] ==>sum=14,18  ===>largest=18
--->[7,2] & [3,10,8] ==>sum=9,23  ===>largest=23
-->[7] & [2,3,10,8] ==>sum=7,23 ===>largest=23
from all the largest smallest should be considered
where the answer is smallest =====> smallest=18

refer one note== bs_split_array_largest_sum
 */


public class bs_split_array_largest_sum {
    public static void main(String[] args){
        int nums[]={7,2,3,10,8};
        int m=2;
        System.out.println(result(nums,m));
    }
    public static int result(int nums[],int m){
        int start=0;
        int end=0;

        for(int i=0;i<nums.length;i++){
            start=Math.max(start,nums[i]); // means that max element in an array --> that lower bound for bs --> which has max element in the array ie., the min possible
            end += nums[i]; // sum of the array --> max value-->upper bound of bs
        }
        //bs
        while(start <end){
            //try for the middle as potential answer
            int mid=start+(end-start )/2;
            //calculate how many pieces (count) that the array can split with this max sum
            int sum=0;
            int pieces=1; //initially 1  given in question
            for(int num :nums){
                if(sum + num >mid){
                    //you cannit  add this in the existing subarray, make new array
                    // say you add this num in new subarray,then sum=num
                    // sum for new array start with the num as sum not 0 as 1st array
                    sum =num;
                    pieces++; // next sub array
                }
                else{ //if not
                    sum+=num;
                }
            }
            if(pieces >m){ //m=2
                start=mid+1;

            }
            else{
                end=mid;
            }

        }
        return start; // or end bouth are ==
    }
}

