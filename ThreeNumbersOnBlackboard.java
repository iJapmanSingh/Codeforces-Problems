    import java.util.*;
public class ThreeNumbersOnBlackboard {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                long c = sc.nextLong();

                long totalSum = a + b + c ;
                long minNum = Math.min(a , Math.min(b , c));
                long maxNum = Math.max(a, Math.max(b , c));
                if(totalSum - maxNum < maxNum){
                    maxNum = totalSum - maxNum ;
                }
                System.out.println(maxNum - minNum);
            }

            sc.close();
        }
    }
}
