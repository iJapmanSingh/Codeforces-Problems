import java.io.*;
import java.util.*;

public class Vacations {

    public class Main {


        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        static long nextLong() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Long.parseLong(st.nextToken());
        }

        static String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }


        public static void main(String[] args) throws Exception {

            int n = nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            Integer[][] dp = new Integer[n][3];
            int ans = solve(0 , 0 , arr , dp);
            System.out.println(ans);

        }
        public static int solve(int index , int lastActivity , int[] arr , Integer[][] dp){
            int n = arr.length ;
            if(index >= n) return 0 ;

            if(dp[index][lastActivity] != null)
                return dp[index][lastActivity];

            int take0 = (int)(1e9);
            int take1 = (int)(1e9);
            int take2 = (int)(1e9);
            int take3 = (int)(1e9);

            //if index is 0
            if(arr[index] == 0) {
                 take0 = 1 + solve(index + 1, 0, arr ,dp);
            }

            else if(arr[index] == 3) {
                //take 3
                take3 = 1 + solve(index + 1, 0, arr , dp);
                if (lastActivity != 1) {
                    take3 = Math.min(take3, solve(index + 1, 1, arr ,dp));
                }
                if (lastActivity != 2) {
                    take3 = Math.min(take3, solve(index + 1, 2, arr , dp));
                }
            }

            else if(arr[index] == 2) {
                //take2
                take2 = 1 + solve(index + 1, 0, arr , dp);
                if (lastActivity != 2) {
                    take2 = Math.min(take2, solve(index + 1, 2, arr ,dp ));
                }
            }

            else if(arr[index] == 1) {
                //take 1
                take1 = 1 + solve(index + 1, 0, arr , dp);
                if (lastActivity != 1) {
                    take1 = Math.min(take1, solve(index + 1, 1, arr , dp));
                }
            }

            return dp[index][lastActivity] = Math.min(take0 , Math.min(take1 , Math.min(take2 , take3))) ;
        }
    }
}
