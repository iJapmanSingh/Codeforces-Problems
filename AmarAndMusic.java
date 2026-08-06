import java.util.*;
    import java.io.*;

public class AmarAndMusic {

    public class Main {

        static class Pair {
            int days;
            int index;

            Pair(int days, int index) {
                this.days = days;
                this.index = index;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Pair[] arr = new Pair[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(Integer.parseInt(st.nextToken()), i + 1);
            }

            // Your solution goes here
            Arrays.sort(arr , (a,b) -> a.days - b.days) ;

            int count = 0 ;
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0 ; i < n ;i++){
                if(arr[i].days <= k){
                    count++ ;
                    k = k - arr[i].days ;
                    ans.add(arr[i].index);
                }
            }
            System.out.println(count);
            for(int x : ans){
                System.out.println(x + " ");
            }
        }
    }
}
