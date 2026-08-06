    import java.io.*;
    import java.util.*;

public class SleepingSchedule {


    public class Main {

        static int n, h, l, r;
        static int[] arr;
        static Integer[][] dp ;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dp = new Integer[n][h];


            int ans = solve(0 , 0 , arr , h , l , r) ;
            System.out.println(ans);
        }
        public static int solve(int i , int t , int[] arr , int h , int l ,int r ){
            int n = arr.length ;
            if(i == n) return 0 ;

            if(dp[i][t] != null) return dp[i][t] ;

            int time1 = (t + arr[i]) % h ;
            int time2 = (t + arr[i] -1) % h ;

            int good1 = (time1 >= l && time1 <= r) ? 1 : 0;
            int good2 = (time2 >= l && time2 <= r) ? 1 : 0;

            int take1 = good1 + solve(i + 1 , time1 , arr , h , l , r);
            int take2 = good2 + solve(i + 1 , time2 , arr , h , l , r);

            return dp[i][t] = Math.max(take1 , take2);

        }

    }
}
