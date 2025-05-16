import java.util.*;
import java.io.*;
public class Main {
    static final String RED = "R";
    static final String BLUE = "B";
    public static void main(String[] args) throws IOException {
        int min = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arrays = br.readLine().split("");

        boolean blueCheck = false;
        boolean redCheck = false;
        int rCount = 0;
        int bCount = 0;
        for (int i = 0; i < N; i++) {
            if (!blueCheck && arrays[i].equals(BLUE)) {
                blueCheck = true;
            } else if (blueCheck && arrays[i].equals(RED)) {
                rCount++;
            }
            if (!redCheck && arrays[i].equals(RED)) {
                redCheck = true;
                continue;
            }

            if (redCheck && arrays[i].equals(BLUE)) {
                bCount++;
            }
        }

        min = Math.min(min, Math.min(rCount, bCount));

        blueCheck = false;
        redCheck = false;
        rCount = 0;
        bCount = 0;

        for (int i = N-1; i >= 0; i--) {
            if (!blueCheck && arrays[i].equals(BLUE)) {
                blueCheck = true;
            } else if (blueCheck && arrays[i].equals(RED)) {
                rCount++;
            }
            if (!redCheck && arrays[i].equals(RED)) {
                redCheck = true;
                continue;
            }

            if (redCheck && arrays[i].equals(BLUE)) {
                bCount++;
            }
        }

        min = Math.min(min, Math.min(rCount, bCount));

        System.out.println(min);
    }
}