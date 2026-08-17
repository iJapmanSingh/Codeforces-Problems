    import java.util.*;
public class Gigantomachy {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();

                long a1 = sc.nextLong();

                // Read remaining a values
                for (int i = 1; i < n; i++) {
                    sc.nextLong();
                }
                long b1 = sc.nextLong();
                // Read remaining b values
                for (int i = 1; i < m; i++) {
                    sc.nextLong();
                }

                long beaNeeds = b1 + m - 1;
                long verNeeds = a1 + n - 1;

                if (beaNeeds <= verNeeds) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        }
    }
}
