import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
       
      
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] g  = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                g[i][j] = sc.nextInt();
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int fc = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(g[i][j]==2){
                    
                    q.add(new int[]{i,j,0});
                }
                else if(g[i][j]==1){
                    fc++;
                }
                    
                }
            }
            if (fc== 1) {
                System.out.println(0);
                return;
            }
             int mt = 0;
            
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            
        
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            mt = Math.max(mt,t);
            for(int i = 0;i<4;i++){
                int nr = r+dr[i];
                int nc  = c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && g[nr][nc]==1){
                    g[nr][nc] = 2;
                    fc--;
                    q.add(new int[]{nr,nc,t+1});
                }
            }
        }
        if (fc == 0) {
                System.out.println(mt);
            } else {
                System.out.println(-1);
            }
    
    }
}
