
import java.io.*;
import java.util.*;
public class DominoTiles {


    public class Main {

        static final int MOD = 998244353;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String s = br.readLine().trim();

                // dp[i][prevValue][prevWeight + 1]
                int[][][] dp = new int[n][2][4];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        Arrays.fill(dp[i][j], -1);
                    }
                }

                long ans = 0;

                // Choose the first character
                if (s.charAt(0) == '?') {
                    ans += f(1, 0, -1, s, dp);
                    ans += f(1, 1, -1, s, dp);
                } else {
                    int first = s.charAt(0) - '0';
                    ans = f(1, first, -1, s, dp);
                }

                sb.append(ans % MOD).append('\n');
            }

            System.out.print(sb);
        }

        public static int f(int i, int prevValue, int prevWeight,
                            String s, int[][][] dp) {

            int n = s.length();

            // All characters are filled
            if (i == n) {
                return 1;
            }

            int state = prevWeight + 1;

            if (dp[i][prevValue][state] != -1) {
                return dp[i][prevValue][state];
            }

            long ans = 0;

            // Try current value = 0
            if (s.charAt(i) == '?' || s.charAt(i) == '0') {

                int newWeight = prevValue + 0;

                if (newWeight != prevWeight) {
                    ans += f(i + 1, 0, newWeight, s, dp);
                }
            }

            // Try current value = 1
            if (s.charAt(i) == '?' || s.charAt(i) == '1') {

                int newWeight = prevValue + 1;

                if (newWeight != prevWeight) {
                    ans += f(i + 1, 1, newWeight, s, dp);
                }
            }

            return dp[i][prevValue][state] = (int) (ans % MOD);
        }
    }
}
