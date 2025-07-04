//leetcode 852 ,162(easy,medium) peak index in a mountain array
import java.util.*;

public class bs_peak_mountain_index {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size");
        int size=sc.nextInt();
        int[] arr=new int[size];
        System.out.println("enter the elements enter soretd or sort it using arrays.sort");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        //System.out.println("enter the target element");
        //int target=sc.nextInt();
        int ans=searching(arr);
        System.out.println(ans);
    }
    public static int searching(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) { // says you ar in the incresing ascending order so
                end = mid; // heremid value also considered beacuse of the possibilty
                //conside[ 3,4, 5,6,2,1] arr[mid]=5 then arr[mid+1]=6 which is greater so,end =mid ,that directly says that end is the mid and return to the while loop and check bs in satrt to mid
            }
            //or you or in decresing decending order
            else {
                start = mid + 1;// you can leave the mid element beacuse it obviously greater
                // consider same array that now checks from 6 to 1 that the 6 also added
            }
        }
        //in the end ,start ==end  and pointinh to the largest elemnt in the arary becausse of those 2 condition checked above
        //start and end always try to find the max elemnt in  the above 2 checks
        //hence when they are pointing to one element ,that is the peak element
        //at everey  point of start and end,they have the best possible answer til that time
        // and if are saying that only one itm remains, then that is the possible answer
        return start; // you can also return end both or =
    }
}
