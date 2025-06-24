import java.util.*;

public class linearsearchin_string {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string");
        String str=sc.nextLine();

        char c='u';
        int result=search(str,c);
        if(result==-1){
            System.out.println("not found");
        }
        else{
            System.out.println("exists");
        }
    }
    public static int search(String str,char c){
        if(!str.isEmpty()){
            for(int i=0;i<str.length()-1;i++){
                if(c==str.charAt(i)) {
                    System.out.println("found at " + i);
                    return i;
                }
            }
        }
        return -1;
    }

}
