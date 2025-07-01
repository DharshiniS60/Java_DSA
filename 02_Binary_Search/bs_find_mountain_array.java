import java.util.Scanner;
//leeycode 1095 find in mountain array but by using interface
public class bs_find_mountain_array {
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
        System.out.println(search(arr,target));
    }
    public static int search(int[] arr,int target){
        int peak=findingpeak(arr);

        int firsttry=orderagnostic(arr,target,0,peak);// for aces
        if(firsttry!=-1){
            return firsttry;
        }
        //if not try the des
        return orderagnostic(arr,target,peak+1,arr.length-1);
    }
    public static int findingpeak(int[] arr){
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

    public static int orderagnostic(int[] arr, int target,int start,int end) {//peak is codisered as end here

//        int start = 0; for this here not need
//        int end = arr.length - 1;
        //finding the array is sorted in ascending or descending
        boolean isAsc=arr[start]<arr[end];

        while (start <= end) {
            //int mid =(start-end)/2;
            //the problem in this statment is that the interger has the limit that start +end may give large nummber so the neww calculation
            int mid = start + (end - start) / 2;

            if(arr[mid]==target)
                return mid;

            // ascending
            if(isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1; //descending end=mid -1
                } else{// if (target < arr[mid]) {
                    end = mid - 1;  //descending start=mid +1
                }
            }
//            else{
//                return mid;   no need beacuse already added in upper beacise that is same for both ascending and descendimg
//            }
            else{
                if (target < arr[mid]) {
                    start = mid + 1; //descending end=mid -1
                } else {//if (target > arr[mid]) {
                    end = mid - 1;  //descending start=mid +1
                }
            }

        }
        return -1;
    }
}
