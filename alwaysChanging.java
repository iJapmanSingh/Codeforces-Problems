    import java.util.*;
public class alwaysChanging {

        static Integer[][][] dp ;
        static final int INF = 1000000000;

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                int n = sc.nextInt();
                String s = sc.next();

                // Your logic here
                dp = new Integer[n+1][3][3];
                int ans = f(0, s, 2, 2);
                System.out.println(ans >= INF ? -1 : ans);
            }

            sc.close();
        }

        public static int f(int index , String s , int lastUsed , int lastKept){
            if(index == s.length()) return 0 ;
            if(dp[index][lastUsed][lastKept] != null) return dp[index][lastUsed][lastKept] ;
            char ch = s.charAt(index) ;
            int remove = INF ;
            int notRemoved = INF ;
            if(ch == '1' && lastUsed != 1){
                remove = 1 + f(index + 1 , s , 1 , lastKept);
            }else if(ch == '0' && lastUsed != 0 ){
                remove = 1 + f(index + 1  , s , 0 , lastKept) ;
            }
            if(ch == '1' && lastKept != 1){
                notRemoved = f(index + 1 , s , lastUsed , 1);
            }else if(ch == '0' && lastKept != 0){
                notRemoved = f(index + 1 , s , lastUsed , 0);
            }

            return dp[index][lastUsed][lastKept] = Math.min(remove , notRemoved);
        }
    }

