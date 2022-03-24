import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        public class MagicNum {            
            public static int primeFactorsSum(int n) {
                int sum = 0;
                while (n%2 == 0) {
                    sum += 2;
                    n /= 2;
                }

                for (int i = 3; i <= Math.sqrt(n); i+= 2) {
                    while (n%i == 0) {
                        sum += digitSum(i);
                        n /= i;
                    }
                }

                if (n > 2) sum += digitSum(n);
                return sum;
            }
            
            public static int digitSum(int num){
                int sum = 0;
                while(num != 0){
                    int rem = (int)(num % 10);
                    sum += rem;
                    num = num/10;
                }
                return sum;
            }
            
            public static void main(String args[] ) throws Exception {
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                System.out.println((digitSum(num) == primeFactorsSum(num)) ? "1" : "0"); 
            }
        }
