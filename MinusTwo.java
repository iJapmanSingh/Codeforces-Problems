    import java.io.*;
import java.util.*;
public class MinusTwo {

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }

                // Your logic here
                int noOfOdd = 0 ;
                int noOfEvenWithEven = 0 ;
                int noOfEvenWithOdd = 0 ;
                for(int i = 0 ; i < n ; i++){
                    if(a[i] % 2 != 0){
                        noOfOdd++ ;
                    }
                    if(a[i] % 2 == 0){
                        if((a[i]/2) % 2 == 0){
                            noOfEvenWithEven++ ;
                        }
                        if((a[i]/2) % 2 != 0 ){
                            noOfEvenWithOdd++ ;
                        }
                    }
                }

                int ans = Math.max(noOfOdd , Math.max(noOfEvenWithEven , noOfEvenWithOdd));
                System.out.println(ans );

            }
        }
    }
}
