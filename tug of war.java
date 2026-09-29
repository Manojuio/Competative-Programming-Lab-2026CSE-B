import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] weights = new int[n];
        int totalWeight = 0;
        
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            totalWeight += weights[i];
        }
        
        
        int targetSize1 = n / 2;
        int targetSize2 = (n + 1) / 2; 
        boolean[][] dp = new boolean[targetSize2 + 1][totalWeight + 1];
        dp[0][0] = true;
        
        for (int weight : weights) {
            
            for (int j = targetSize2; j >= 1; j--) {
                for (int w = totalWeight; w >= weight; w--) {
                    if (dp[j - 1][w - weight]) {
                        dp[j][w] = true;
                    }
                }
            }
        }
        
        int minDiff = Integer.MAX_VALUE;
        
       
        for (int w = 0; w <= totalWeight; w++) {
         
            if (dp[targetSize1][w] || dp[targetSize2][w]) {
                int currentDiff = Math.abs(totalWeight - 2 * w);
                minDiff = Math.min(minDiff, currentDiff);
            }
        }
        
        System.out.println(minDiff);
    }
}
