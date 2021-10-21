import java.io.*;
import java.util.*;

public class Solution {
    
//     public static boolean Arrangement(int n, int g, int[] arr){
//         int sum = 0;
        
//         for(int i = 0; i < n; i++)
//             sum += arr[i]; 
//         // System.out.println(Math.ceil((double)sum/(double)2));
//         return (Math.ceil((double)sum/(double)2) <= g) ? true : false;
//     }
    public static void solve(int n, int g, int[] a){
        int sum=0;
        
            for(int i=0;i<n;i++){
                sum+=a[i];
            }
            if(g>=sum){
                System.out.println("YES");
                return;
            }
            if(sum>2*g){
                System.out.println("NO");
                return;
            }
        
            boolean[][] dp=new boolean[n+1][g+1];
            dp[0][0]=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<g;j++)
                    if(dp[i][j]){
                        dp[i+1][j]=true;
                        if(j+a[i]<=g)dp[i+1][j+a[i]]=true;
                    }
            }
            int max=0;
            for(int i=g;i>=0;i--)
                if(dp[n][i]){
                    max=i;
                    break;
                }
            if(sum-max<=g){
                System.out.println("YES");
            }
            else
                System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0){
            int n = sc.nextInt();
            int g = sc.nextInt();
            int[] arr = new int[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            // System.out.println(Arrangement(n, g, arr) ? "YES" : "NO");
            solve(n, g, arr);
        }
    }
}