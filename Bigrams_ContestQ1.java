import java.io.*;
import java.util.*;

public class Bigrams_ContestQ1 {

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                int k = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] c = new int[k];

                for (int i = 0; i < k; i++) {
                    c[i] = Integer.parseInt(st.nextToken());
                }

                // Write your logic here
                boolean possible = false ;
                int count = 0 ;
                for(int i = 0 ; i < k ; i++){
                    if(c[i] >= 3) {
                        possible = true ;
                    }
                    if(c[i] >= 2){
                        count++ ;
                    }
                }
                if(count >= 2){
                    possible = true;
                }
                System.out.println(possible ? "YES" : "NO");
            }
        }
    }
}
