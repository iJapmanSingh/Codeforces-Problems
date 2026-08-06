    import java.io.*;
import java.util.*;

public class Books_279B {

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
            int t = nextInt();

            int[] books = new int[n];

            for (int i = 0; i < n; i++) {
                books[i] = nextInt();
            }

            int len = 0 ;
            int left = 0 ;
            int right = 0 ;
            int sum = 0 ;
            while(right < n){
                sum += books[right];

                    while(sum > t){
                        sum -= books[left];
                        left++ ;
                    }
                len = Math.max(len , right - left + 1 )    ;
                right++ ;
            }
            System.out.println(len);
        }

    }
}
