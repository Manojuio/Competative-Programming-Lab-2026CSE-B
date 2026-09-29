import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tar= sc.nextInt();
        int g = gcd(a,b);
        if(tar%g==0){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
    public static int gcd(int a, int b){
        
        while(b!=0){
            int t = a%b;
            a =b;
            b =t;
        }
        return a;
    }
}