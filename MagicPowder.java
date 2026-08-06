import java.util.Scanner;
import java.util.*;
import java.io.*;
public class MagicPowder {


    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Read n and k
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // Read array a[] — grams needed per cookie for each ingredient
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Read array b[] — grams Apollinaria currently has
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            int low = 0;
            int high = 2000 ;

            int[] need = new int[n] ;

            while(low <= high){
                int mid = (low + high) / 2 ;
                //ingredients needed to make number of mid cookies
                for(int i = 0 ; i < n ; i++){
                    need[i] = a[i] * mid ;
                }

                if(canMakeCookie(a , b , need , k)){
                    answer = mid ;
                    low = mid + 1 ;
                }else{
                    high = mid - 1 ;
                }
            }
            System.out.println(answer);
        }


        public static boolean canMakeCookie(int[] a , int[] b , int[] need , int k){

            int[] cost = new int[b.length];
            long totalCost = 0 ;
            for(int i = 0 ; i < b.length ; i++){
                if(need[i] >= b[i]){
                    cost[i] = need[i] - b[i];
                }else{
                    cost[i] = 0;
                }
                totalCost += cost[i] ;
            }

            return k >= totalCost ;
        }
    }
}


//D2 problem on codeforces


    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken()); // CHANGED: k can be 10^9, use long

            // CHANGED: a[] to long[] since a[i] can be 10^9
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            // CHANGED: b[] to long[] since b[i] can be 10^9
            long[] b = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            long answer = 0;
            long low = 0;
            long high = 2_000_000_000L; // CHANGED: max b[i] + max k = 10^9 + 10^9

            long[] need = new long[n]; // CHANGED: a[i] * mid can overflow int

            while (low <= high) {
                long mid = (low + high) / 2;
                for (int i = 0; i < n; i++) {
                    need[i] = a[i] * mid; // now safe, both long
                }

                if (canMakeCookie(a, b, need, k)) {
                    answer = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(answer);
        }

        public static boolean canMakeCookie(long[] a, long[] b, long[] need, long k) {
            long totalCost = 0;

            for (int i = 0; i < b.length; i++) {
                long cost = Math.max(0L, need[i] - b[i]);

                totalCost += cost;

                // Prevent overflow and unnecessary work
                if (totalCost > k) {
                    return false;
                }
            }

            return true;
        }
    }