    import java.util.*;
public class RiskyTower {

    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                int n = sc.nextInt();
                int m = sc.nextInt();

                long[] v = new long[n];

                for (int i = 0; i < n; i++) {
                    v[i] = sc.nextLong();
                }

                long[][] a = new long[n][m];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        a[i][j] = sc.nextLong();
                    }
                }

                for (int i = 0; i < n; i++) {
                    Arrays.sort(a[i]);

                    // descending
                    for (int l = 0, r = m - 1; l < r; l++, r--) {
                        long temp = a[i][l];
                        a[i][l] = a[i][r];
                        a[i][r] = temp;
                    }
                }

                int low = 1;
                int high = m;

                while (low < high) {

                    int mid = low + (high - low) / 2;

                    if (check(mid, n, m, v, a)) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }

                System.out.println(low);
            }

            sc.close();
        }

        static boolean check(int k, int n, int m, long[] v, long[][] a) {

            long[] best = new long[k];
            long[] next = new long[k];

            for (int i = n - 1; i >= 0; i--) {

                int p1 = 0;
                int p2 = 0;

                for (int j = 0; j < k; j++) {

                    if (p1 < m && (p2 == k || a[i][p1] >= best[p2])) {
                        next[j] = a[i][p1];
                        p1++;
                    } else {
                        next[j] = best[p2];
                        p2++;
                    }
                }

                long[] temp = best;
                best = next;
                next = temp;

                long sum = 0;

                for (int j = 0; j < k; j++) {
                    sum += best[j];

                    if (sum >= v[i]) {
                        return true;
                    }
                }
            }

            return k == m;
        }
    }
}
