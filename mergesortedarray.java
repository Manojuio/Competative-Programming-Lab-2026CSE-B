import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int j = 0; j < m; j++) {
            arr2[j] = scanner.nextInt();
        }
       int[] result = msa(arr1, arr2);

     
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(" ");
            }
        }
        
        scanner.close();
    }
    public static int[] msa(int [] arr1,int []arr2){
        
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i =0;
        int j = 0;
        int k = 0;
        int[] result = new int[n+m];
       while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
         while (i < n) {
            result[k++] = arr1[i++];
        }
        
        
        while (j < m) {
            result[k++] = arr2[j++];
        }
        return result;
    }
}













