    import java.util.*;

public class Chocolates {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Write your solution here
            long ans = 0 ;
            int next = Integer.MAX_VALUE ;
            for(int i = n-1 ; i >= 0 ; i--){
                int curr = Math.min(a[i] , next - 1);
                curr = Math.max(curr , 0);
                ans += curr ;
                next = curr ;
            }
            System.out.println(ans);

        }
    }
}
