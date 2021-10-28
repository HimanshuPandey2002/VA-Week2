import java.io.*;
import java.util.*;

public class Solution {
    public static int base(int n, int[] house){
        int mid = (n%2==0)? n/2 : n/2 + 1;
        Arrays.sort(house);
        
        return house[mid-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int[] house = new int[n];
            
            for(int i = 0; i < n; i++)
                house[i] = sc.nextInt();
            System.out.println(base(n, house));
        }
    }
}
