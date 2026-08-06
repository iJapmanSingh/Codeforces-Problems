    import java.io.*;
import java.util.*;
public class roomsAndStaircases {

    public class Main {

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                int n = Integer.parseInt(br.readLine());

                String s = br.readLine();

                // Your logic here
                int ans = n ;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        ans = Math.max(ans, 2 * (i + 1));
                        ans = Math.max(ans, 2 * (n - i));
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
