import java.io.*;
import java.util.*;

public class Complement {
    public static int onesComplement(int n) {
        int number_of_bits = (int)(Math.floor(Math.log(n) / Math.log(2))) + 1;
        return ((1 << number_of_bits) - 1) ^ n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int comp = onesComplement(n);
            System.out.println(n * comp);
        }
    }
}
