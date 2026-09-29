import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        
        if (s == null || p == null) {
            System.out.println(0);
            return;
        }
        
        s = s.trim();
        p = p.trim();
        
        int n = s.length();
        int m = p.length();
        
        int sIdx = 0, pIdx = 0;
        int matchIdx = 0, starIdx = -1;
        
        while (sIdx < n) {
            if (pIdx < m && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } else if (pIdx < m && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++;
            } else if (starIdx != -1) {
                pIdx = starIdx + 1;
                matchIdx++;
                sIdx = matchIdx;
            } else {
                System.out.println(0);
                return;
            }
        }
        
        while (pIdx < m && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        System.out.println(pIdx == m ? 1 : 0);
    }
}
