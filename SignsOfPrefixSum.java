    import java.util.Scanner;
public class SignsOfPrefixSum {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            if (!sc.hasNextInt()) return;
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();

                // Check if impossible
                if (s.charAt(0) == '0' || s.contains("00")) {
                    System.out.println("-1");
                    continue;
                }

                // BINARY SEARCH: Fixed the upper bound to prevent Long Overflow
                long low = 1;
                long high = 1000000000L; // 1 Billion is safe and won't overflow
                long answer = -1;

                while (low <= high) {
                    long mid = low + (high - low) / 2;

                    if (isValid(s, mid)) {
                        answer = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                System.out.println(answer);
            }
            sc.close();
        }

        private static boolean isValid(String s, long maxStep) {
            long minP = 0;
            long maxP = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // Remember exactly where we were before we jump
                long oldMin = minP;
                long oldMax = maxP;

                // 1. Expand range by our step
                minP = minP - maxStep;
                maxP = maxP + maxStep;

                // 2. Filter by the map character
                if (c == '+') {
                    minP = Math.max(minP, 1);
                } else if (c == '-') {
                    maxP = Math.min(maxP, -1);
                } else if (c == '0') {
                    minP = Math.max(minP, 0);
                    maxP = Math.min(maxP, 0);
                }

                // TRAP 1 FIX: The "0-Step" Hole
                if (oldMin == oldMax) {
                    if (minP == oldMin) minP++;
                    if (maxP == oldMax) maxP--;
                }

                // TRAP 2 FIX: The X=1 Parity Ping-Pong
                if (maxStep == 1) {
                    long requiredParity = (i + 1) % 2;

                    if (Math.abs(minP % 2) != requiredParity) {
                        minP++;
                    }
                    if (Math.abs(maxP % 2) != requiredParity) {
                        maxP--;
                    }
                }

                // 3. Did our range collapse?
                if (minP > maxP) {
                    return false;
                }
            }
            return true;
        }
    }
}
