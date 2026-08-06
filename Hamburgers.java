import java.util.*;

public class Hamburgers {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String recipe = sc.next();

            long nb = sc.nextLong();
            long ns = sc.nextLong();
            long nc = sc.nextLong();

            long pb = sc.nextLong();
            long ps = sc.nextLong();
            long pc = sc.nextLong();

            long r = sc.nextLong();

            long cntB = 0, cntS = 0, cntC = 0;
            for (char ch : recipe.toCharArray()) {
                if (ch == 'B') cntB++;
                else if (ch == 'S') cntS++;
                else if (ch == 'C') cntC++;
            }

            long low = 0 ;
            long maxFromKitchen = Long.MAX_VALUE;
            if (cntB > 0) maxFromKitchen = Math.min(maxFromKitchen, nb / cntB);
            if (cntS > 0) maxFromKitchen = Math.min(maxFromKitchen, ns / cntS);
            if (cntC > 0) maxFromKitchen = Math.min(maxFromKitchen, nc / cntC);
            long high = maxFromKitchen + r;

            long answer = 0 ;

            while(low <= high){
                long mid = (low + high)/2 ;

                //no. of B , S , C needed to make number of mid Burgers
                long needB = mid * cntB ;
                long needS = mid * cntS ;
                long needC = mid * cntC ;

                if(canMake(mid , needB , needS , needC , nb , ns , nc , pb , ps , pc ,  r)){
                    answer = mid ;
                    low = mid + 1 ;
                }else{
                    high = mid - 1 ;
                }

            }

            System.out.println(answer);
        }

        public static boolean canMake(long burgers , long needB , long needS , long needC , long nb , long ns , long nc , long pb , long ps , long pc , long r){
            needB = needB - nb ;
            needS = needS - ns ;
            needC = needC - nc ;

            if (needB < 0) needB = 0 ;
            if (needS < 0) needS = 0 ;
            if (needC < 0) needC = 0 ;

            long totalCost = (needB * pb) + (needS * ps) + (needC * pc);

            return r >= totalCost ;
        }

    }

}






