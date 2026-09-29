import java.util.Scanner;

public class DuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) return;
        String s = scanner.next();
        int n = s.length();
        
       
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        
        
        int longestPrefixSuffix = pi[n - 1];
        
        
        if (longestPrefixSuffix > 0 && n % (n - longestPrefixSuffix) == 0) {
            System.out.println(n - longestPrefixSuffix);
        } else {
            System.out.println(n);
        }
        
        scanner.close();
    }
}
