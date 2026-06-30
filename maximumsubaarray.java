import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

public class Main {
    public static int maxSubarraySum(int[] arr) {

        int ma = arr[0];
        int curr = arr[0];
       for (int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            ma = Math.max(ma, curr);
        }
        
        return ma;
    
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            
     
            System.out.println(maxSubarraySum(arr));
        }
        
        scanner.close();
    }
}
