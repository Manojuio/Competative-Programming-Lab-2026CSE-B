import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        // Handle division by zero
        if (y == 0) {
            System.out.println("Infinity");
            return;
        }
        
        // Handle edge case for Integer.MIN_VALUE overflow
        if (x == Integer.MIN_VALUE && y == -1) {
            System.out.println(Integer.MAX_VALUE);
            return;
        }
        
        // Determine the sign of the result
        int sign = ((x < 0) ^ (y < 0)) ? -1 : 1;
        
        // Use long absolute values to safely prevent overflow during multiplication
        long absX = Math.abs((long) x);
        long absY = Math.abs((long) y);
        
        long low = 0;
        long high = absX;
        long ans = 0;
        
        // Perform binary search for integer division
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long currentProduct = mid * absY;
            
            // If product matches exactly, this is our perfect mid
            if (currentProduct == absX) {
                ans = mid;
                break;
            }
            // If product is less than x, it could be the floored answer
            else if (currentProduct < absX) {
                ans = mid; // Store candidate answer
                low = mid + 1; // Try to find a larger quotient
            } 
            // If product exceeds x, mid is too large
            else {
                high = mid - 1;
            }
        }
        
        // Apply sign and print the final integer result
        System.out.println(sign * ans);
        
        scanner.close();
    }
}
