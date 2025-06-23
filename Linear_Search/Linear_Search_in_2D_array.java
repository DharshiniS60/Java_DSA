import java.util.*;

public class linear_search_in2d_array {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the rows");
        int rows=sc.nextInt();
        System.out.println("enter the col");
        int col=sc.nextInt();
        int[][] arr=new int[rows][col];
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

      System.out.println("enter the target");
        int target=sc.nextInt();


       int[] result=search(arr,target);


       System.out.println(Arrays.toString(result));

    }

    public static int[] search(int[][] arr,int target) {

            if (arr.length!=0) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (arr[i][j] == target) {
                            return new int[]{i, j};
                        }
                    }
                }
            }
        return new int[]{-1,-1};
    }
}

