import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;
        s = s.trim();

        int visited = 0;
        int duplicates = 0;

        // First pass: Identify all duplicate characters using bit masks
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int bitPosition = ch - 'a';

            if ((visited & (1 << bitPosition)) != 0) {
                duplicates |= (1 << bitPosition); // Mark as a duplicate
            } else {
                visited |= (1 << bitPosition);
            }
        }

        // If no duplicates were found
        if (duplicates == 0) {
            System.out.println("No duplicates");
            return;
        }

        StringBuilder sb = new StringBuilder();

        // Second pass: Print duplicates in the order of their first appearance
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int bitPosition = ch - 'a';

            if ((duplicates & (1 << bitPosition)) != 0) {
                sb.append(ch).append(" ");
                duplicates &= ~(1 << bitPosition); // Clear the bit so it's not printed again
            }
        }

        System.out.println(sb.toString().trim());
    }
}
