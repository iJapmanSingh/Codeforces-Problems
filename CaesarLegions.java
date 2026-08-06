import java.io.*;
import java.util.*;

public class CaesarLegions {

    public class Main {

        static int n1, n2, k1, k2;
        static int MOD = 100000000;

        // dp[horseLeft][footLeft][prevType][consecutive]
        static Integer[][][][] dp;

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken()); // footmen
            n2 = Integer.parseInt(st.nextToken()); // horsemen
            k1 = Integer.parseInt(st.nextToken()); // max consecutive footmen
            k2 = Integer.parseInt(st.nextToken()); // max consecutive horsemen

            int maxK = Math.max(k1, k2);

            dp = new Integer[n2 + 1][n1 + 1][3][maxK + 1];

            int ans = solve(n2 , n1 , 0 , 0);
            System.out.println(ans);

        }

        static int solve(int horseLeft, int footLeft, int prevType, int consecutive) {

            if(horseLeft == 0 && footLeft == 0) return 1 ;

            if(dp[horseLeft][footLeft][prevType][consecutive] != null) return dp[horseLeft][footLeft][prevType][consecutive];

            long ans = 0 ;

            //try placing footman
            if(footLeft > 0 ){
                if(prevType == 1){
                    if(consecutive < k1){
                        ans += solve(horseLeft , footLeft - 1 ,1 , consecutive + 1);
                    }
                }else{
                    ans += solve(horseLeft , footLeft -1 , 1 , 1) ;
                }
            }

            //try placing horseman
            if(horseLeft > 0){
                if(prevType == 2){
                    if(consecutive < k2){
                        ans += solve(horseLeft -1 , footLeft , 2 , consecutive + 1);
                    }
                }else{
                    ans += solve(horseLeft -1 , footLeft , 2 , 1 );
                }
            }
            ans %= MOD ;
            return dp[horseLeft][footLeft][prevType][consecutive] = (int) ans ;

        }
    }

}
