import java.io.*;
import java.util.*;

public class Solution {
    public static int divide(int a, int b) {
     
        if (a== Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        if (a== Integer.MIN_VALUE && b == 1) {
            return Integer.MIN_VALUE;
        }
        int ab=Math.abs(a);
        int ba = Math.abs(b);
         int q = 0;

       
        while (ab >= ba) {
            ab-=ba;
            q++;
        }
         if(a<0 || b<0){
            
            return -1*q;
         }
         return q;
    
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int dividend = sc.nextInt();
            int divisor = sc.nextInt();
            System.out.print(divide(dividend, divisor));
        }
    }
}
