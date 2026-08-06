import java.util.*;
import java.io.*;

public class IskanderandDrawings {



    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String s = br.readLine().trim();

                // TODO: write your solution logic here
                int count = 0 ;
                int ans = 0 ;
                for(int i = 0 ; i < n ; i++){
                    if(s.charAt(i) == '#'){
                        count++ ;
                        ans = Math.max(ans , count);
                    }else{
                        count = 0 ;
                    }
                }
                int answer = (ans + 1) / 2;

                sb.append(answer).append("\n");
            }

            System.out.print(sb);
        }
    }

}
