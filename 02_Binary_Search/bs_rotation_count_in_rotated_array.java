//geeks for geeks
//for this only pivot required
//answer is always pivot+1
//as it is bs

public class bs_rotation_count_in_rotated_array {
    public static void main(String[] args){
        int nums[]={4,5,6,7,0,1,2};
        System.out.println("without duplicates");
        System.out.println(countrotation(nums));
        int numwithdup[]={2,2,8,9,0,1,2};
        System.out.println("with duplicates");
        System.out.println(countrotationwithdup(numwithdup));


    }
    public static int countrotation(int[] arr){
        int pivot=findpivot( arr);
        //not required it automatically return 0;
//        if(pivot==-1){
//            return 0;
//        }
        return pivot+1;
    }
    public static int countrotationwithdup(int[] arr){
        int pivot=findpivotwithduplicates( arr);
        //not required it automatically return 0;
//        if(pivot==-1){
//            return 0;
//        }
        return pivot+1;
    }
    //for sorted withput duplicates
    public static int findpivot(int arr[]) {// pivot is the largest number
        int start = 0;
        int end = arr.length - 1;
        //bs
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //4 case
            // 1st case
            if (mid < end && arr[mid] > arr[mid + 1]) { //2nd condition mid may be last eemnt of array so 1st condtion added
                return mid;
            }
            //2nd case
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            //3rd case
            if (arr[start] < mid) {
                end = mid + 1;
            }
            //4thcase
            if (arr[start] > mid) {
                start = mid + 1;
            }
        }
        return -1;
    }
    //for sorted with duplicates
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
