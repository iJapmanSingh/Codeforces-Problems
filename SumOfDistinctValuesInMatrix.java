    import java.util.*;
public class SumOfDistinctValuesInMatrix {

    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();

                int[] a = new int[x];
                int[] b = new int[y];

                for (int i = 0; i < x; i++) {
                    a[i] = sc.nextInt();
                }

                for (int i = 0; i < y; i++) {
                    b[i] = sc.nextInt();
                }

                // Reverse -> decreasing order
                reverse(a);
                reverse(b);

                long ans = Math.max(
                        f(n - 1, m, x, y, a, b),
                        f(n, m - 1, x, y, a, b)
                );

                System.out.println(ans);
            }

            sc.close();
        }

        public static long f(int n, int m, int x, int y, int[] a, int[] b) {

            int i = 0;
            int j = 0;

            int both = 0;

            long sum = 0;

            while ((i < x || j < y) && i + j - both < n + m) {

                // Cannot take any more elements from a
                if (i == x || i - both >= n) {

                    if (j == y || j - both >= m) {
                        break;
                    }

                    sum += b[j];
                    j++;
                }

                // Cannot take any more elements from b
                else if (j == y || j - both >= m) {

                    if (i == x || i - both >= n) {
                        break;
                    }

                    sum += a[i];
                    i++;
                }

                // Both arrays have available elements
                else {

                    // Same value -> take it once
                    // but it can be used for both a and b
                    if (a[i] == b[j]) {

                        sum += a[i];

                        both++;
                        i++;
                        j++;
                    }

                    // Take the larger value
                    else if (a[i] > b[j]) {

                        sum += a[i];
                        i++;
                    }

                    else {

                        sum += b[j];
                        j++;
                    }
                }
            }

            return sum;
        }

        public static void reverse(int[] arr) {

            int left = 0;
            int right = arr.length - 1;

            while (left < right) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}
