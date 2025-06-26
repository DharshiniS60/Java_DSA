import java.util.*;

/*arr[][] =
{[10,20,30,40],
[15,25,35,45],
[28,29,37,49],
[33,34,38,50]}
start ==>lowerbound ==>10
upperbound==>1st row last col ==>40 // for case 2 element is >40 then row will increased beacuse all element in that row should <40
//similaryly for case 3 elsemnt <target eg 37<35 ,, then the column is reduced beacuse all the in next col is bigger
case1: if(element==target)
return
case 2;
if (element >target)
row++
case 3
if(element<target)
col--
// ************** only for n*n matrix
*/

public class bs_2d_matrix {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no. of rows");
        int r=sc.nextInt();
        System.out.println("enter the no. of clos");
        int c=sc.nextInt();
        System.out.println("enter the elements");
        int[][] arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter the target");
        int target=sc.nextInt();

        System.out.println(Arrays.toString(search(arr, target)));


    }
    public static int[] search(int[][] arr, int target){
        int row=0; //start
        int col=arr.length-1;
        while(row<arr.length-1 && col>=0){
            if(arr[row][col]==target){
                return new int[]{row,col};
            }
            //all the element there is bigger than that target skip the col
            if (arr[row][col] > target) {

                col--;
            }
            //if(arr[row][col] <target)
            //all the element there is less than that target, so skip the row
            else{

                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
