import java.io.*;
import java.util.*;

public class BasketballExercise {


    public class Main {

        static int n;
        static long[] h1, h2;

        static long solve(int idx, int prev , long[] h1 , long[] h2 , long[][] dp) {
            //base case
            if(idx < 0 ) return 0 ;
            long takeH1 = 0 ;
            long takeH2 = 0 ;
            long skip = 0 ;

            if(dp[idx][prev] != -1) return dp[idx][prev] ;
            //case 1 , take idx from row 1
            if(prev == 1 || prev == 2){
                takeH1 = solve(idx - 1 , 0 , h1 , h2 , dp) + h1[idx] ;
            }
            if (prev == 2 || prev == 0){
                takeH2 = solve(idx - 1 , 1 , h1 , h2 , dp) + h2[idx] ;
            }
            skip = solve(idx - 1 , prev , h1 , h2 , dp) ;
            return dp[idx][prev] = Math.max(takeH1 , Math.max(takeH2 , skip)) ;

        }

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());

            h1 = new long[n];
            h2 = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                h1[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                h2[i] = Long.parseLong(st.nextToken());
            }
            long[][] dp = new long[n][3] ;
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < 3 ; j++){
                    dp[i][j] = -1 ;
                }
            }

            System.out.println(solve(n-1 , 2 , h1 , h2 , dp ));
        }
    }


}
