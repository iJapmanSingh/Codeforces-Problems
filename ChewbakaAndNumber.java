
import java.io.*;
import java.util.*;

public class ChewbakaAndNumber {


    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();

            // Your code here
            StringBuilder ans = new StringBuilder();

            for(int i = 0 ; i < s.length() ;i++){
                int digit = s.charAt(i) - '0' ;
                if(i == 0 && digit == 9) {
                    ans.append(digit);
                }
                else if(digit > 4){
                    ans.append(9 - digit);
                }else{
                    ans.append(digit);
                }
            }
            System.out.println(ans);

        }
    }
}
