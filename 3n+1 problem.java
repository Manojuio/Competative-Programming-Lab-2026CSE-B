import java.io.*;
import java.util.*;

public class Solution {
  public static int f(int n,int c){
    if(n==1) return c;
    if(n%2==0){
        return f(n/2,c+1);
    }
    return f(3*n+1,c+1);
  }
  

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int i = sc.nextInt();
       int j = sc.nextInt();
       int ans = 0;
       for(int k = i;k<=j;k++){
       ans = Math.max(ans,f(k,1));
       }
 System.out.print(i+ " " +j + " " + ans); 
    }
}
