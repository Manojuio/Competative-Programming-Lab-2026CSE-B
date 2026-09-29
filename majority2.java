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
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
          mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
           if(mp.get(nums[i])>n/2){
            System.out.println(nums[i]);
            return;
            }
        }
        System.out.println("-1");

    }
}
