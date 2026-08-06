//import java.util.*;
//
//public class WhoWatchesTheWatchPig {
//
//    public class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//
//            int t = sc.nextInt();
//
//            while (t-- > 0) {
//                int n = sc.nextInt();
//                int k = sc.nextInt();
//
//                char[] s = sc.next().toCharArray();
//
//                if(2*k > n){
//                    System.out.println("-1");
//                    continue;
//                }
//                int[] prefixL = new int[n+1];
//                prefixL[0] = 0 ;
//                for(int i =1 ; i <= n ; i++){
//                    prefixL[i] = prefixL[i-1];
//                    if(s[i-1] == 'L'){
//                        prefixL[i]++ ;
//                    }
//                }
//                int[] suffixR = new int[n+1];
//                suffixR[n] = 0 ;
//                for(int i = n-1 ; i >= 0 ; i--){
//                    suffixR[i] = suffixR[i + 1];
//                    if (s[i] == 'R') suffixR[i]++;
//                }
//                int answer = Integer.MAX_VALUE;
//                for (int i = k; i <= n - k; i++) {
//                    int flips = prefixL[i] + suffixR[i];
//                    answer = Math.min(answer, flips);
//                }
//                System.out.println(answer);
//            }
//        }
//    }
//}


import java.util.*;

public class Main {
    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int ans = INF;

            for (int totalL = k; totalL <= n - k; totalL++) {

                int[][] dp = new int[n + 1][totalL + 1];

                for (int i = 0; i <= n; i++)
                    Arrays.fill(dp[i], INF);

                dp[0][0] = 0;

                for (int i = 0; i < n; i++) {
                    for (int l = 0; l <= Math.min(i, totalL); l++) {

                        if (dp[i][l] == INF) continue;

                        // Place R
                        if (totalL - l >= k) {
                            int cost = dp[i][l] + (s.charAt(i) == 'R' ? 0 : 1);
                            dp[i + 1][l] = Math.min(dp[i + 1][l], cost);
                        }

                        // Place L
                        if (l < totalL && (i - l) >= k) {
                            int cost = dp[i][l] + (s.charAt(i) == 'L' ? 0 : 1);
                            dp[i + 1][l + 1] = Math.min(dp[i + 1][l + 1], cost);
                        }
                    }
                }

                ans = Math.min(ans, dp[n][totalL]);
            }

            System.out.println(ans == INF ? -1 : ans);
        }
    }
}
