    import java.util.*;
public class monocarpContest {

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];

                int count = 0;
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                    if (a[i] == 0) {
                        count++;
                    }
                }

                // Check if it's impossible to have two easy problems at the ends
                if (count < 2) {
                    System.out.println("-1");
                }
                // 0 operations if both ends are already easy
                else if (a[0] == 0 && a[n - 1] == 0) {
                    System.out.println("0");
                }
                // 1 operation if exactly one end is easy
                else if (a[0] == 0 || a[n - 1] == 0) {
                    System.out.println("1");
                }
                // 2 operations if both ends are hard
                else {
                    System.out.println("2");
                }
            }

            sc.close();
        }
    }
}
