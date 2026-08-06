import java.util.*;

public class FlippingGame {


    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int ans = solve(nums);

            System.out.println(ans);
        }

        public static int solve(int[] nums) {

            int n = nums.length ;
            int gain = 0 ;
            int one = 0 ;
            int maxi = Integer.MIN_VALUE ;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] == 1){
                    one += 1 ;
                    gain = gain - 1 ;
                }else{
                    gain = gain + 1 ;
                }
                if(gain > maxi){
                    maxi = gain ;
                }
                if(gain < 0){
                    gain = 0 ;
                }
            }
            return maxi + one ;
        }
    }
}
