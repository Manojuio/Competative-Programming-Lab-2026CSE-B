import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long n = scanner.nextLong();
        int k = scanner.nextInt();
        
        long result = n ^ (1L << k);
        
        System.out.println(result);
        
        scanner.close();
    }
}
