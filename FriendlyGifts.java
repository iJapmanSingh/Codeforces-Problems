
import java.io.*;


public class FriendlyGifts {

    public class Main {

        public static void main(String[] args) throws Exception {
            DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
            StringBuilder sb = new StringBuilder();

            int t = nextInt(in);

            while (t-- > 0) {
                int n = nextInt(in);

                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = nextInt(in) - 1 ;
                }

                // Your code here
                //first - make a 2D array - able , which tells this subarray exists in array
                boolean[][] able = new boolean[n][n];
                for(int left = 0 ; left < n ; left++){
                    boolean[] seen = new boolean[n] ;
                    int min = a[left];
                    int max = a[left];
                    for(int right = left ; right < n ; right++){
                        if(seen[a[right]]){
                            break ;
                        }
                        seen[a[right]] = true;
                        min = Math.min(min , a[right]);
                        max = Math.max(max , a[right]);

                        if(max - min == right - left){
                            able[min][max] = true ;
                        }

                    }
                }
                boolean found = false ;
                for(int len = n ; len >= 1 && !found ; len--){
                    for(int start = 0 ; start + 2 * len <= n ; start++){
                        if(able[start][start + len - 1] && able[start + len][start + 2 * len - 1]){
                            sb.append(len).append('\n');
                            found = true ;
                            break ;
                        }
                    }
                }
                if (!found) {
                    sb.append(0).append('\n');
                }
            }

            System.out.print(sb);
        }

        static int nextInt(DataInputStream in) throws IOException {
            int c;
            while ((c = in.read()) <= ' ') ;

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = in.read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = in.read();
            }

            return val * sign;
        }
    }
}
