import java.util.Scanner;
import java.util.*;

public class Main {
    public static int solve(String s, int i, int j,int[][]dp) {
        if (i > j) {
            return dp[i][j]=0;
        }
        if (i == j) {
            return dp[i][j]=1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j]=2 + solve(s, i + 1, j - 1,dp);
        }
        
        return dp[i][j]= Math.max(solve(s, i + 1, j,dp),
         solve(s, i, j - 1,dp));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        if (sc.hasNextLine()) {
            String A = sc.nextLine().trim();
              int [][] dp = new int[A.length()][A.length()];
              for(int i = 0;i<A.length();i++){
              Arrays.fill(dp[i],-1);}
            System.out.println(solve(A, 0, A.length() - 1,dp));
        }
        sc.close();
    }
}
