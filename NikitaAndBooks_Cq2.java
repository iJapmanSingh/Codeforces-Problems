import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class NikitaAndBooks_Cq2 {

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                long[] a = new long[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    a[i] = Long.parseLong(st.nextToken());
                }

                // TODO: write your solution logic here
                boolean ans = false ;
                long miniSum = 0 ;
                long sum = 0 ;
                for(int i = 0 ; i < n ; i++){
                    miniSum = (long) (i + 1) *(i+2)/2 ;
                    sum = sum + a[i];
                    if(sum >= miniSum){
                        ans = true ;
                    }else{
                        ans = false ;
                        break ;
                    }
                }

                boolean answer = ans;

                sb.append(answer ? "YES" : "NO").append("\n");
            }

            System.out.print(sb);
        }
    }

}
