    import java.util.Scanner;
public class monocarpAndProjects {

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {
                int t = sc.nextInt();

                while (t-- > 0) {
                    long x = sc.nextLong();
                    long y = sc.nextLong();
                    long k = sc.nextLong();

                    long d = y - x;
                    long answer = 0;
                    long i = 0;

                    // 1. Calculate step-by-step ONLY while x + i <= d
                    while (i < k && (x + i) <= d) {
                        answer += d % (x + i);
                        i++;
                    }

                    // 2. Fast-forward the rest!
                    // Once x + i > d, the remainder is always just d.
                    if (i < k) {
                        long remainingMonths = k - i;
                        answer += remainingMonths * d;
                    }

                    System.out.println(answer);
                }
            }

            sc.close();
        }
    }
}
