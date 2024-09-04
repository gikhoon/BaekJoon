import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] circles = new boolean[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                if (split[j].equals("1")) {
                    circles[i][j] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            boolean[] linked = new boolean[3];
            linked[0] = (circles[0][2] ^ circles[1][6]);
            linked[1] = (circles[1][2] ^ circles[2][6]);
            linked[2] = (circles[2][2] ^ circles[3][6]);

            st = new StringTokenizer(br.readLine());
            int circleNumber = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            int current =  circleNumber-1;
            int directionTmp = direction;

            changeCircle(current, direction);
            while (current > 0) {
                directionTmp *= -1;
                if (linked[current-1]) {
                    changeCircle(current-1, directionTmp);
                } else {
                    break;
                }
                current--;
            }
            current = circleNumber-1;
            directionTmp = direction;

            while (current < 3) {
                directionTmp *= -1;
                if (linked[current]) {
                    changeCircle(current+1, directionTmp);
                } else {
                    break;
                }
                current++;
            }
        }

        int answer = 0;
        if (circles[0][0]) {
            answer += 1;
        }
        if (circles[1][0]) {
            answer += 2;
        }
        if (circles[2][0]) {
            answer += 4;
        }
        if (circles[3][0]) {
            answer += 8;
        }

        System.out.println(answer);
    }

    private static void changeCircle(int circleNumber, int direction) {
        if (direction == 1) {
            boolean tmp = circles[circleNumber][7];
            for (int i = 7; i > 0; i--) {
                circles[circleNumber][i] = circles[circleNumber][i - 1];
            }
            circles[circleNumber][0] = tmp;
        } else {
            boolean tmp = circles[circleNumber][0];
            for (int i = 0; i < 7; i++) {
                circles[circleNumber][i] = circles[circleNumber][i + 1];
            }
            circles[circleNumber][7] = tmp;
        }
    }


}