import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String firstLine = br.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;

        st = new StringTokenizer(firstLine);
        int tokenCount = st.countTokens();

        int T = 1;
        int N = 0;
        boolean hasT = true;

        if (tokenCount > 1) {
            T = 1;
            N = Integer.parseInt(st.nextToken());
            hasT = false;
        } else {
            T = Integer.parseInt(st.nextToken());
        }

        while (T > 0 || !hasT) {
            if (hasT) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
                if (!st.hasMoreTokens()) continue;
                N = Integer.parseInt(st.nextToken());
            }

            long[][] grid = new long[N][N];
            for (int i = 0; i < N; i++) {
                String gridLine = br.readLine();
                if (gridLine == null) break;
                st = new StringTokenizer(gridLine);
                for (int j = 0; j < N; j++) {
                    if (st.hasMoreTokens()) {
                        grid[i][j] = Long.parseLong(st.nextToken());
                    }
                }
            }

            long[][] dp = new long[N][N];
            int[][] parentRow = new int[N][N];
            int[][] parentCol = new int[N][N];

            dp[0][0] = grid[0][0];

            for (int j = 1; j < N; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
                parentRow[0][j] = 0;
                parentCol[0][j] = j - 1;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
                parentRow[i][0] = i - 1;
                parentCol[i][0] = 0;
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    long minVal = dp[i - 1][j];
                    int pR = i - 1;
                    int pC = j;

                    if (dp[i][j - 1] < minVal) {
                        minVal = dp[i][j - 1];
                        pR = i;
                        pC = j - 1;
                    }

                    if (dp[i - 1][j - 1] < minVal) {
                        minVal = dp[i - 1][j - 1];
                        pR = i - 1;
                        pC = j - 1;
                    }

                    dp[i][j] = minVal + grid[i][j];
                    parentRow[i][j] = pR;
                    parentCol[i][j] = pC;
                }
            }

            System.out.println(dp[N - 1][N - 1]);

            if (hasT) {
                T--;
            } else {
                String nextLine = br.readLine();
                if (nextLine == null || nextLine.trim().isEmpty()) break;
                st = new StringTokenizer(nextLine);
                if (st.hasMoreTokens()) {
                    N = Integer.parseInt(st.nextToken());
                } else {
                    break;
                }
            }
        }
    }
}
