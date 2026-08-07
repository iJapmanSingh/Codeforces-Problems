    import java.io.*;
import java.util.*;
public class HypercarpAndControlPannel {

    public class Main {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        static void solve() throws Exception {
            int n = nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }

            ArrayList<Integer> colors = new ArrayList<>();
            ArrayList<Integer> len = new ArrayList<>();

            // Compress consecutive equal colors
            for (int i = 0; i < n; i++) {
                if (colors.isEmpty() || colors.get(colors.size() - 1) != a[i]) {
                    colors.add(a[i]);
                    len.add(1);
                } else {
                    len.set(len.size() - 1, len.get(len.size() - 1) + 1);
                }
            }

            int m = colors.size();
            int ans = m;

            // Check if answer can become m + 2
            boolean addTwo = false;
            for (int i = 0; i < m - 1; i++) {
                if (len.get(i) >= 2 && len.get(i + 1) >= 2) {
                    addTwo = true;
                    break;
                }
            }

            if (addTwo) {
                System.out.println(ans + 2);
                return;
            }

            // Check if answer can become m + 1
            boolean addOne = false;

            for (int i = 0; i < m; i++) {

                if (len.get(i) >= 2) {

                    boolean nextPossible = false;
                    if (i + 1 < m) {
                        if (i + 2 >= m || !colors.get(i).equals(colors.get(i + 2))) {
                            nextPossible = true;
                        }
                    }

                    boolean prevPossible = false;
                    if (i > 0) {
                        if (i - 2 < 0 || !colors.get(i - 2).equals(colors.get(i))) {
                            prevPossible = true;
                        }
                    }

                    if (nextPossible || prevPossible) {
                        addOne = true;
                        break;
                    }
                }
            }

            if (addOne) {
                System.out.println(ans + 1);
            } else {
                System.out.println(ans);
            }
        }

        public static void main(String[] args) throws Exception {
            int T = nextInt();
            while (T-- > 0) {
                solve();
            }
        }
    }
}
