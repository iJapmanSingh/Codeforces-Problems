import java.io.*;
import java.util.*;

public class MashmokhandACM {

    public class Main {

        static final long MOD = 1_000_000_007L;

        static int n, k;
        static long[][] memo;

        static long solve(int len, int curr) {

            if (len == 1)
                return 1;

            if (memo[len][curr] != -1)
                return memo[len][curr];

            long ans = 0;

            for(int next = curr ; next <= n ;  next += curr){
                ans += solve(len - 1 , next) ;
            }

            return memo[len][curr] = ans % MOD;
        }

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            memo = new long[k + 1][n + 1];

            for (int i = 0; i <= k; i++) {
                Arrays.fill(memo[i], -1);
            }

            long ans = 0;

            for (int start = 1; start <= n; start++) {
                ans = (ans + solve(k, start)) % MOD;
            }

            System.out.println(ans);
        }
    }

}
