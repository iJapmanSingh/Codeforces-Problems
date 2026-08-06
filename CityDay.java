    import java.util.*;


public class CityDay {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] rain = new int[n];

            for (int i = 0; i < n; i++) {
                rain[i] = sc.nextInt();
            }

            for(int i = 0 ; i < n ; i++){
                boolean ok = true ;
                for (int j = i - 1; j >= i - x && j >= 0; j--){
                   if(rain[j] <= rain[i]){
                       ok = false ;
                       break ;
                   }
               }
                if(ok){
                    for (int j = i + 1; j <= i + y && j < n; j++){
                        if(rain[j] <= rain[i]){
                            ok = false ;
                            break;
                        }
                    }
                }
                if(ok){
                    System.out.println(i+1);
                    break ;
                }
            }
            sc.close();
        }
    }

}

