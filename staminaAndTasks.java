import java.io.*;
import java.util.*;


public class staminaAndTasks {

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static int nextInt() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        public static void main(String[] args) throws Exception {


            int t = nextInt();

            while (t-- > 0) {

                int n = nextInt();

                int[] c = new int[n];
                int[] p = new int[n];

                for (int i = 0; i < n; i++) {
                    c[i] = nextInt();
                    p[i] = nextInt();
                }

                // Write your solution here
                double[] dp = new double[n] ;
                Arrays.fill(dp , -1);
                double ans = solve(0 , c ,p , dp);
                System.out.println(ans);

            }
        }
        public static double solve(int i  , int[] c , int[] p , double[] dp){
            int n = c.length ;
            if(i == n) return 0 ;
            if(dp[i] != -1 ) return dp[i] ;

            double factor = 1.0 - p[i] / 100.0;

            double take = c[i] + factor * solve(i + 1  , c , p , dp   );
            double notTake = solve(i + 1  , c , p , dp);


            return dp[i] = Math.max(take , notTake);
        }
    }

}
