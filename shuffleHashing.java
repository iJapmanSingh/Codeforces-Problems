

import java.util.*;


public class shuffleHashing {

    public class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                String p = sc.next();
                String h = sc.next();

                char[] pass = p.toCharArray();
                char[] hash = h.toCharArray();
                Arrays.sort(pass);
                boolean answer = false ;
                for (int i = 0; i + p.length() <= h.length(); i++) {
                    int j = i + p.length() - 1;
                    char[] newArr = new char[p.length()];
                    for (int k = i; k <= j; k++) {
                        newArr[k - i] = hash[k];
                    }
                    Arrays.sort(newArr);
                    if (Arrays.equals(newArr, pass)) {
                        answer = true;
                        break;
                    }
                }
                if(answer){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
