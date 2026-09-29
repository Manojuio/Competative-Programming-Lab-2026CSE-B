import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int shift=0;
   while(((a | b) & 1)==0) {
            a >>= 1;
            b >>= 1;
            shift++;}
while((a& 1) ==0) {
            a >>= 1;
        }
while(b!= 0) {
         while ((b & 1) == 0) {b >>= 1;
         }
if(a > b) {
  int temp = a;
  a = b;
b = temp;
}
 b = b - a;
        }
int gcd = a << shift;
System.out.println(gcd);
    }
}
