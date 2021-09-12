import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] arr = new int[length][length];
        for(int i=0; i<length;i++){
            for(int j=0; j<length;j++){
                arr[i][j]= scanner.nextInt();
            }
        }
        int a =0;
        for(int i=0; i<length;i++){
            for(int j=0; j<length;j++){
                if(arr[i][j]!=-1){
                    a = a|arr[i][j];
                }
            }
            System.out.print(a+" ");
            a=0;
        }
    }
}
