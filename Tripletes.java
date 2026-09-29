import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
       int [] a = new int[n];
       for(int i = 0;i<n;i++){
        a[i] = sc.nextInt();
       }
       int x= sc.nextInt();
       Arrays.sort(a);
       boolean f = false;
       int s = 0;
       for(int i=  0;i<n;i++){
        int l = i+1;
        int r =n-1;
        while(l<r){
            s=a[i]+a[l]+a[r];
            if(s==x){
                System.out.println(a[i]+" "+a[l]+" "+a[r]);
                f=true;
                l++;
                r--;}
                else if(s<x){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        if(!f){
            System.out.println("No Triplet Found");
        }
       }
    }
