
import java.util.*;
public class PoisonedDagger {

    public class Main {

        static long[] a;
        static int n;
        static long h;

        static boolean canKill(long k , int n , long h , long[] a) {
            // your logic here
            long damage = 0 ;
            for(int i = 0 ; i <= n-2 ; i++){
                damage += Math.min(k , a[i+1] - a[i]);
            }
            damage += k ;
            return damage >= h ;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                n = sc.nextInt();
                h = sc.nextLong();
                a = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextLong();
                }

                long low = 1 ;
                long high = h ;

                long answer = 0 ;

                while(low <= high){
                    long mid = low + (high - low) / 2 ;
                    if(canKill(mid , n , h , a)){
                        answer = mid ;
                        high = mid - 1 ;
                    }else{
                        low = mid + 1 ;
                    }
                }
                System.out.println(answer);
            }
        }
    }
}
