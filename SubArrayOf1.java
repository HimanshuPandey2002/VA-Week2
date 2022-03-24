import java.io.*;
import java.util.*;

public class SubArrayOf1 {
    static int longestSubSeg(int a[], int n, int k) {
        int count = 0;
        int l = 0;
        int max_len = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                count++;

            while (count > k) {
                if (a[l] == 0)
                    count--;
                l++;
            }
            max_len = Math.max(max_len, i - l + 1);
        }

        return max_len;
    }
    
    static ArrayList<Integer> maximized_one(int arr[], int n, int m) {
        int left[] = new int[n];
        int right[] = new int[n];
        ArrayList<Integer> zero = new ArrayList<>();
        int count = 0;
        int prevZero = -1;
        
        for (int i = 0; i < n; i++) {
            if (arr[i]!=0) 
                count++;
            else {
                left[i] = count;
                zero.add(i);
                if (prevZero != i && prevZero != -1) 
                    right[prevZero] = count;
                
                count = 0;
                prevZero = i;
            }
        }
        
        right[prevZero] = count;

        int max_one = -1;
        ArrayList<Integer> result_index = new ArrayList<Integer>();
        int i = 0;

        while (i <= (zero.size()) - m) {
            int temp = 0;
            ArrayList<Integer> index = new ArrayList<>();

            for (int c = 0; c < m; c++) {
                temp += left[zero.get(i + c)] + right[zero.get(i + c)] + 1;
                index.add(zero.get(i + c));
            }
            temp = temp - (m - 1);
            if (temp > max_one) {
                max_one = temp;
                result_index = index;
            }
            i += 1;
        }

        return result_index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(longestSubSeg(arr, n, k));
        
        for(int i: maximized_one(arr, n, k))
            arr[i] = 1;
        
        for(int i : arr)
            System.out.print(i + " ");
    }
}
