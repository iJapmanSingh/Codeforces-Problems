import java.io.*;
import java.util.*;

public class PredominantFreqDivision_ContestQ2 {

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                int n = Integer.parseInt(br.readLine());

                int[] a = new int[n];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }

                // Write your logic here
                int[] prefixOne = new int[n+1];
                int[] prefixTwo = new int[n+1];
                int[] prefixThree = new int[n+1];

                for(int i = 0 ; i < n ; i++){
                    prefixOne[i+1] = prefixOne[i];
                    prefixTwo[i+1] = prefixTwo[i];
                    prefixThree[i+1] = prefixThree[i];

                    if(a[i] == 1) prefixOne[i+1]++ ;
                    else if (a[i] == 2) prefixTwo[i+1]++ ;
                    else prefixThree[i+1]++ ;
                }
                boolean possible = false ;
                for(int i = 0 ; i < n-2 && !possible ; i++){
                    if(prefixOne[i+1] >= prefixTwo[i+1] + prefixThree[i+1]){
                        for(int j = i+1 ; j < n-1 ; j++){
                            if((prefixOne[j+1]-prefixOne[i+1]) + (prefixTwo[j+1] - prefixTwo[i+1]) >= (prefixThree[j+1]-prefixThree[i+1])){
                                possible = true ;
                                break ;
                            }
                        }
                    }
                }
                System.out.println(possible ? "YES" : "NO");
            }
        }
    }
}


import java.io.*;
        import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();

        int t = nextInt(in);
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n + 1]; // 1-indexed
            for (int idx = 1; idx <= n; idx++) a[idx] = nextInt(in);

            // prefix1[k]: sum over a[1..k] of (1 -> +1, 2 -> -1, 3 -> -1)
            // prefix2[k]: sum over a[1..k] of (1 -> +1, 2 -> +1, 3 -> -1)
            int[] prefix1 = new int[n + 1];
            int[] prefix2 = new int[n + 1];
            for (int k = 1; k <= n; k++) {
                int v = a[k];
                int t1 = (v == 1) ? 1 : -1;
                int t2 = (v == 3) ? -1 : 1;
                prefix1[k] = prefix1[k - 1] + t1;
                prefix2[k] = prefix2[k - 1] + t2;
            }

            // sufmax[k] = max(prefix2[k], prefix2[k+1], ..., prefix2[n-1])
            // valid j (end of part 2) ranges only up to n-1, since part 3 must be non-empty
            int NEG_INF = Integer.MIN_VALUE;
            int[] sufmax = new int[n + 2];
            sufmax[n] = NEG_INF;      // j = n is not allowed
            sufmax[n + 1] = NEG_INF; // sentinel
            for (int k = n - 1; k >= 1; k--) {
                sufmax[k] = Math.max(prefix2[k], sufmax[k + 1]);
            }

            boolean ok = false;
            // i = end index of part 1, must leave at least 1 element for part 2 and 1 for part 3
            for (int i = 1; i <= n - 2; i++) {
                if (prefix1[i] < 0) continue;
                // need some j in [i+1, n-1] with prefix2[j] >= prefix2[i]
                if (sufmax[i + 1] >= prefix2[i]) {
                    ok = true;
                    break;
                }
            }

            sb.append(ok ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}