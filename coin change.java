import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String firstLine = br.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;

        st = new StringTokenizer(firstLine);
        int tokenCount = st.countTokens();
        
        int T = 1;
        int V = 0, N = 0;
        boolean hasT = true;

        if (tokenCount > 1) {
            V = Integer.parseInt(st.nextToken());
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
                V = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
            }

            int[] inputCoins = new int[N];
            String coinLine = br.readLine();
            if (coinLine == null) break;
            st = new StringTokenizer(coinLine);
            for (int i = 0; i < N; i++) {
                if (st.hasMoreTokens()) {
                    inputCoins[i] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(inputCoins);
            ArrayList<Integer> coins = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (inputCoins[i] > V) break;
                if (coins.isEmpty() || coins.get(coins.size() - 1) != inputCoins[i]) {
                    coins.add(inputCoins[i]);
                }
            }

            int[] dp = new int[V + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int coin : coins) {
                for (int i = coin; i <= V; i++) {
                    if (dp[i - coin] != INF && dp[i - coin] + 1 < dp[i]) {
                        dp[i] = dp[i - coin] + 1;
                    }
                }
            }

            if (dp[V] == INF) {
                System.out.println("-1");
            } else {
                System.out.println(dp[V]);
            }

            if (hasT) {
                T--;
            } else {
                String nextLine = br.readLine();
                if (nextLine == null || nextLine.trim().isEmpty()) break;
                st = new StringTokenizer(nextLine);
                if (st.countTokens() >= 2) {
                    V = Integer.parseInt(st.nextToken());
                    N = Integer.parseInt(st.nextToken());
                } else {
                    break;
                }
            }
        }
    }
}
