import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
           while (b != 0) {
          
            int carry = a & b; 
            
           
            a = a ^ b; 
            

            b = carry << 1; 
        }
        System.out.println(a);
    }
}
