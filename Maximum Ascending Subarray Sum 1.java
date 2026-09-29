import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int [] nums = new int[n];
        for(int i= 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
   
      
       int cs =nums[0];
       int ms =nums[0];
        for(int r= 1;r<n;r++){
            if(nums[r]>nums[r-1]){
                cs+=nums[r];
            }
       else{
        cs =nums[r];
       }
          ms = Math.max(ms,cs);
        }
        System.out.println(ms);
        sc.close();
    }
}
