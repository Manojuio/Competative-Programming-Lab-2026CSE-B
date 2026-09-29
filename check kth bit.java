import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k  =sc.nextInt();
        n =(n>>k)&1;
        System.out.println(n);
        return;
        
    }
}
