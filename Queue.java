import java.io.*;
import java.util.*;

public class Queue {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] res = new int[n-1];
            
            for(int i = 1; i < n; i++){
                res[i-1] = Math.abs(arr[i] - arr[i-1]);
            }
            boolean fl = true;
            
            for(int i = 1; i < n-1; i++){
                if(Math.abs(res[i]-res[i-1]) != 1)
                    fl = false;
            }
            System.out.println(!fl ? "Correct Formation" : "Incorrect Formation");
        }
    }
}
