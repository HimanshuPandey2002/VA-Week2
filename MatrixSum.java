import java.io.*;
import java.util.*;

public class MatrixSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            
             int sum = 0;
        
            for(int i = 0; i < n; i++){
                for(int j = 0;j<n; j++){
                    int x = sc.nextInt();
                    if(i == 0 || i == n-1 || j == 0||j==n-1||i==j||i+j == n-1)
                        sum += x;
                }
            }
            System.out.println(sum);
        }
    }
}
