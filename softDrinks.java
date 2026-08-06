import java.util.*;

public class softDrinks {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int p = sc.nextInt();
            int nl = sc.nextInt();
            int np = sc.nextInt();

            // Write your solution here

            int enoughMilkToast = (k*l)/nl ;
            int enoughLimeSlice = (c*d) ;
            int enoughSalt = p/np ;
            int ans = Math.min(enoughSalt , Math.min(enoughLimeSlice , enoughMilkToast)) ;
            ans = ans/n ;
            System.out.println(ans);

        }
    }
}
