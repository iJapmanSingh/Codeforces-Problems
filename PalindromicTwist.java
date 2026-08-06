    import java.io.*;
import java.util.*;

public class PalindromicTwist {

    public class Main {

        static boolean canMatch(char a, char b) {
            char[] first = new char[2];
            int n1 = 0;
            if (a == 'a') {
                first[n1] = 'b';
                n1++ ;
            } else if (a == 'z') {
                first[n1] = 'y';
                n1++ ;
            } else {
                first[n1] = (char) (a - 1);
                n1++ ;
                first[n1] = (char) (a + 1);
                n1++ ;
            }
            char[] second = new char[2];
            int n2 = 0;

            if (b == 'a') {
                second[n2++] = 'b';
            } else if (b == 'z') {
                second[n2++] = 'y';
            } else {
                second[n2++] = (char) (b - 1);
                second[n2++] = (char) (b + 1);
            }
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j++) {
                    if (first[i] == second[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                int n = Integer.parseInt(br.readLine());
                String s = br.readLine();
                boolean answer = true;
                int low = 0;
                int high = n - 1;
                while (low < high) {
                    if (!canMatch(s.charAt(low), s.charAt(high))) {
                        answer = false;
                        break;
                    }
                    low++;
                    high--;
                }
                System.out.println(answer ? "YES" : "NO");
            }
        }
    }
}
