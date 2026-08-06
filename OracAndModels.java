import java.io.*;
import java.util.*;

public class OracAndModels {

    public class Main {

        static int n;
        static int[] arr;
        static int[] dp;

        static int solve(int idx) {

            if (dp[idx] != -1)
                return dp[idx];
            int ans = 1 ;
            for(int next = 2*idx ; next <= n ; next += idx){
                if(arr[next] > arr[idx]){
                    ans = Math.max(ans , 1 + solve(next));
                }
            }

            return dp[idx] = ans ;
        }

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                n = Integer.parseInt(br.readLine());

                arr = new int[n + 1];
                dp = new int[n + 1];

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 1; i <= n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                Arrays.fill(dp, -1);

                int ans = 1;

                for (int i = 1; i <= n; i++) {
                    ans = Math.max(ans, solve(i));
                }

                System.out.println(ans);
            }
        }
    }


}
