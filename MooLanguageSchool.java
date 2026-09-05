    import java.io.*;
import java.util.*;
public class MooLanguageSchool {

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                String s = br.readLine();

                // Your logic here
                int count = 0 ;
                for(int i = 0 ; i < n ; i += k){
                    for(int j = i ; j < i + k ; j++){
                        if(s.charAt(j) == '0'){
                            break ;
                        }
                        if(j == i+ k - 1){
                            count++ ;
                        }
                    }
                }

                System.out.println(count);
            }
        }
    }
}
