import java.util.*;
class Solution{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    float [] arr = new float[n];
    for(int i= 0;i<n;i++){
        arr[i]=sc.nextFloat();
    }
   
    List<Float>[] buckets = new ArrayList[n];
    for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();

    
    for (float num : arr) {
        int idx = (int) (n * num);
        if (idx >= n) idx = n - 1;
        buckets[idx].add(num);
    }

   
    int k = 0;
    for (int i = 0; i < n; i++) {
        Collections.sort(buckets[i]);
        for (float num : buckets[i]) {
            arr[k++] = num;
        }
    }
    for( float num:arr){
        System.out.print(num+" ");
    }                               
    }
}
