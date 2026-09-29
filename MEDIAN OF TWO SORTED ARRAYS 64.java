import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        if (line1 == null) return;
        
        StringTokenizer st = new StringTokenizer(line1);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        int[] b = new int[m];
        
        String line2 = br.readLine();
        if (line2 != null) {
            st = new StringTokenizer(line2);
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        String line3 = br.readLine();
        if (line3 != null) {
            st = new StringTokenizer(line3);
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        int totalLength = n + m;
        int targetIdx1 = totalLength / 2;
        int targetIdx2 = targetIdx1 - 1;
        
        int i = 0, j = 0, count = 0;
        int val1 = 0, val2 = 0;
        
        while (i < n || j < m) {
            int currentVal;
            if (i < n && (j >= m || a[i] <= b[j])) {
                currentVal = a[i++];
            } else {
                currentVal = b[j++];
            }
            
            if (count == targetIdx2) {
                val2 = currentVal;
            }
            if (count == targetIdx1) {
                val1 = currentVal;
                break;
            }
            count++;
        }
        
        if (totalLength % 2 == 1) {
            System.out.println(String.format(Locale.US, "%.1f", (double) val1));
        } else {
            double median = (val1 + val2) / 2.0;
            System.out.println(String.format(Locale.US, "%.1f", median));
        }
    }
}
