    import java.io.*;
import java.util.*;
public class MiddleOfContest {


    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] start = br.readLine().split(":");
            String[] end = br.readLine().split(":");

            int h1 = Integer.parseInt(start[0]);
            int m1 = Integer.parseInt(start[1]);

            int h2 = Integer.parseInt(end[0]);
            int m2 = Integer.parseInt(end[1]);

            // Your logic here
            int t1 = h1*60 + m1;
            int t2 = h2*60 + m2 ;
            int mid = (t1+t2)/2 ;

            int h3 = mid/60 ;
            int m3 = mid%60 ;
            System.out.printf("%02d:%02d%n", h3, m3);
        }
    }
}
