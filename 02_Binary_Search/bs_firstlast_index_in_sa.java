import java.util.Arrays;
import java.util.Scanner;

//leetcode 34 find 1st and last of position of element in sorted array
public class bs_firstlast_index_in_sa{
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
        boolean firststartindex = false;
        System.out.println(Arrays.toString(result(arr,target,firststartindex)));
    }
    public static int[] result(int[] arr,int target, boolean firststartindex){

        int[] arrayans={-1,-1};
        //checking the first occurenece if target first
        //arrayans[0]=start;
        // int start=searching(arr,target,firststartindex:true);
        //int end=searching(arr,target,firststartindex:false);
        arrayans[0]=searching(arr,target,true);
        if(arrayans[0]!=-1){
            arrayans[1]=searching(arr,target,false);
        }
        return arrayans;
    }
    public static int searching(int[] arr, int target,boolean isfirststartindex) {
        int answer=-1;
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
            else {
                answer = mid;//update re answer whe target found
                if (isfirststartindex) {
                    end = mid - 1;
                } else {

                    start = mid + 1;
                }
            }

        }

        return answer;
    }
}
