    import java.io.*;
import java.util.*;
public class ContestQ_C101 {

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }

                // Store positions of fixed 1s
                ArrayList<Integer> ones = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (a[i] == 1) {
                        ones.add(i);
                    }
                }

                int left = -1;
                int right = -1;

                // Case 1: There is no fixed 1
                if (ones.isEmpty()) {

                    int first = -1;
                    int last = -1;

                    for (int i = 0; i < n; i++) {
                        if (a[i] == -1) {
                            if (first == -1) {
                                first = i;
                            }
                            last = i;
                        }
                    }

                    if (first != -1) {
                        left = first;
                        right = last;
                    }

                } else {

                    // Start with first fixed 1
                    left = ones.get(0);
                    right = ones.get(0);

                    // Check prefix
                    for (int i = 0; i < ones.get(0); i++) {
                        if (a[i] == -1) {
                            left = i;
                            break;
                        }
                    }

                    // Check gaps between fixed 1s
                    for (int i = 0; i + 1 < ones.size(); i++) {
                        int l = ones.get(i);
                        int r = ones.get(i + 1);

                        if (r - l > right - left) {
                            left = l;
                            right = r;
                        }
                    }

                    // Check suffix
                    int lastOne = ones.get(ones.size() - 1);

                    for (int i = n - 1; i > lastOne; i--) {
                        if (a[i] == -1) {
                            if (i - lastOne > right - left) {
                                left = lastOne;
                                right = i;
                            }
                            break;
                        }
                    }
                }

                // Replace -1s
                for (int i = 0; i < n; i++) {
                    if (a[i] == -1) {
                        a[i] = 0;
                    }
                }

                // Make chosen endpoints 1
                if (left != -1) {
                    a[left] = 1;
                    a[right] = 1;
                }

                // Print answer
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }

                System.out.println();
            }
        }
    }
}
