    import java.util.*;
public class CreatingAbbrivations {
    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                int n = sc.nextInt();
                int m = sc.nextInt();

                // available[i] tells us whether there is
                // at least one original word starting with
                // the corresponding letter.
                boolean[] available = new boolean[26];

                // Read original words
                for (int i = 0; i < n; i++) {

                    String word = sc.next();

                    // Get first letter
                    char first = word.charAt(0);

                    // Mark this letter as available
                    available[first - 'a'] = true;
                }

                boolean possible = true;

                // Read and check every abbreviation
                for (int i = 0; i < m; i++) {

                    String abbr = sc.next();

                    // Check every character of abbreviation
                    for (int j = 0; j < abbr.length(); j++) {

                        char ch = abbr.charAt(j);

                        // Convert A-Z to 0-25
                        int index = ch - 'A';

                        // If we don't have any word starting
                        // with this letter, this abbreviation
                        // can never be created.
                        if (!available[index]) {
                            possible = false;
                        }
                    }
                }

                if (possible) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

            sc.close();
        }
    }
}
