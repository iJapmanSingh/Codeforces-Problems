import java.io.*;
import java.util.*;

public class MinimizingTheSum {

    public class Main {

        static int n, k;
        static int[] arr;
        static long[][] dp;

        public static void main(String[] args) throws Exception {

            DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));

            int t = nextInt(in);

            while (t-- > 0) {

                n = nextInt(in);
                k = nextInt(in);

                arr = new int[n];

                for (int i = 0; i < n; i++)
                    arr[i] = nextInt(in);

                dp = new long[n + 1][k + 1];

                for (int i = 0; i <= n; i++)
                    Arrays.fill(dp[i], -1);

                System.out.println(solve(0, k));
            }
        }

        static long solve(int i, int rem) {

            if (i == n)
                return 0;

            if (dp[i][rem] != -1)
                return dp[i][rem];

            long ans = Long.MAX_VALUE;

            int mn = (int)1e9 ;

            for(int j = i ; j < n ; j++){
                mn = Math.min(mn , arr[j]);
                int len = j-i+1 ;
                int op = len - 1;
                if(op <= rem){
                    ans = Math.min(ans , (long)len * mn + solve(j + 1 , rem - op));
                }else{
                    break ;
                }
            }

            return dp[i][rem] = ans;
        }

        static int nextInt(DataInputStream in) throws Exception {
            int c;
            while ((c = in.read()) <= ' ')
                ;

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = in.read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = in.read();
            }

            return val * sign;
        }
    }
}
