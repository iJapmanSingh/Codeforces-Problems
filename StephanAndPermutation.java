import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class StephanAndPermutation {

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int[] p = new int[n + 1]; // 1-indexed
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    p[i] = Integer.parseInt(st.nextToken());
                }

                // TODO: write your solution logic here
                DisjointSet ds = new DisjointSet(n+1);
                for(int i = 1 ; i <= n ;i++){
                    if(i + x <= n){
                        ds.union(i , i + x) ;
                    }
                    if(i + y <= n){
                        ds.union(i , i + y) ;
                    }
                }
                boolean answer = true;
                for(int i= 1  ; i <= n ; i++){
                    if(ds.findParent(i) != ds.findParent(p[i])){
                        answer = false ;
                        break ;
                    }
                }
                sb.append(answer ? "YES" : "NO").append("\n");
            }

            System.out.print(sb);
        }
    }
}
