
import java.util.*;

public class BeautifulMatrix {


    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int row = -1, col = -1;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int x = sc.nextInt();
                    if (x == 1) {
                        row = i;
                        col = j;
                    }
                }
            }
            int rowShift = Math.abs(row - 2);
            int colShift = Math.abs(col - 2);

            System.out.println(rowShift + colShift);
            // row and col contain the position of 1 (0-based indexing)
        }
    }
}
