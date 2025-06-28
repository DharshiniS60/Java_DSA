import java.util.Scanner;
//leetcode 744 find smallest letter than target
//celing should return target's smallest greater element
public class bs_celing_letter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size");
        int size=sc.nextInt();
        char[] arr=new char[size];
        System.out.println("enter the elements enter soretd or sort it using arrays.sort");
        for(int i=0;i<size;i++){
            arr[i]=sc.next().charAt(0);
        }
        System.out.println("enter the target element");
        char target=sc.next().charAt(0);
         char ans=searching(arr,target);
        System.out.println(ans);
    }
    public static char searching(char[] arr, char target) {

//        // the codition to be addeed
//        if(target>arr[arr.length-1]){
//            return -1;
//        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //int mid =(start-end)/2;
            //the problem in this statment is that the interger has the limit that start +end may give large nummber so the neww calculation
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start=mid+1; //descending end=mid -1
            }
            else {//if(target < arr[mid]){
                end=mid-1;  //descending start=mid +1
            }

        }
        //return start; // this return the celing element index
        return arr[start % arr.length]; //this return the celing element itself like 2% 4= 2 which is 2nd element 4%4 which is 0 when the elemnt not found 0 index will be returned

    }
}
