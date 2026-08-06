
import java.util.*;


public class Fence {



    public class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            //solution----
            long windowSum = 0;
            for(int i = 0 ; i < k ; i++){     //calculated first window sum
                windowSum += arr[i];
            }

            long minSum = windowSum ;
            int answer = 0 ;
            for(int i = 1 ; i <= n-k ; i++){
                windowSum = windowSum - arr[i-1] + arr[i+k-1] ;
                if(windowSum < minSum){
                    answer = i ;
                    minSum = windowSum ;
                }
            }

            System.out.println(answer + 1);
        }
    }


}
