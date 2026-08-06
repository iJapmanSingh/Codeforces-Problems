
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int left = 0;
        int maxLength = 0;
        int aCount = 0;
        int bCount = 0;

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == 'a') {
                aCount++;
            } else {
                bCount++;
            }

            while (aCount > k && bCount > k) {

                if (s.charAt(left) == 'a') {
                    aCount--;
                } else {
                    bCount--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}