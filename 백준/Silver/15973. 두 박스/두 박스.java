import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] square = new int[2][4];
        String answer = "NULL";

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            square[i][0] = Integer.parseInt(st.nextToken());
            square[i][1] = Integer.parseInt(st.nextToken());
            square[i][2] = Integer.parseInt(st.nextToken());
            square[i][3] = Integer.parseInt(st.nextToken());
        }

        if (square[1][2] < square[0][0] || square[0][2] < square[1][0]
                || square[1][3] < square[0][1] || square[0][3] < square[1][1]) {
            answer = "NULL";
        } else if ((square[0][0] == square[1][2] && square[0][1] == square[1][3]) ||
                (square[0][2] == square[1][0] && square[0][1] == square[1][3]) ||
                (square[0][0] == square[1][2] && square[0][3] == square[1][1]) ||
                (square[0][2] == square[1][0] && square[0][3] == square[1][1])) {
            answer = "POINT";
        } else if (square[0][0] == square[1][2] || square[0][2] == square[1][0]
                || square[0][1] == square[1][3] || square[0][3] == square[1][1]) {
            answer = "LINE";
        } else
            answer = "FACE";

        System.out.println(answer);
    }
}