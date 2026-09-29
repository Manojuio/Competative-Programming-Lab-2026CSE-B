import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        String line = sc.nextLine();
        String[] w = line.split(",");

        String pat = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String cur = w[i];

            int patIdx = 0;

            for (int j = 0; j < cur.length(); j++) {

                if (Character.isUpperCase(cur.charAt(j))) {

                    if (patIdx < pat.length() &&
                        cur.charAt(j) == pat.charAt(patIdx)) {
                        patIdx++;
                    } else {
                        break;
                    }
                }
            }

            if (patIdx == pat.length()) {
                System.out.println(cur);
                return;
            }
        }

        System.out.println("No match found");
    }
}
