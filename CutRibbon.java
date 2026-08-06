import java.util.*;

public class CutRibbon {

    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int[] dp = new int[n + 1];
            Arrays.fill(dp , -1);

            int ans = solve(n, a, b, c , dp);

            System.out.println(ans);
        }

        static int solve(int n, int a, int b, int c , int[] dp) {

            if(n == 0) return 0 ;
            if(n < 0) return -(int)1e9 ;
            if(dp[n] != -1) return dp[n] ;

            return dp[n] = 1 + Math.max(solve(n-a , a , b , c , dp) , Math.max(solve(n-b , a , b , c , dp) , solve(n-c , a , b , c , dp)));
        }
    }


}


