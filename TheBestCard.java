    import java.io.*;
import java.util.*;
public class TheBestCard {

    public class Main {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        static long nextLong() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Long.parseLong(st.nextToken());
        }

        static String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public static void main(String[] args) throws Exception {

            int t = nextInt();

            while (t-- > 0) {

                int n = nextInt();
                if(isPrime(n+1)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
        public static boolean isPrime(int n){
            if (n <= 1) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;

            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;
            }

            return true;
        }
    }
}
