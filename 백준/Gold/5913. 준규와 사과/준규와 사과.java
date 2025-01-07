import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int moveMax;
    static int answer = 0;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] block = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //25 - 4 / 2번 후 만나야 한다.
        //사과만 먹으니까 사과 다 셀 필요 없다.
        //a위치, b위치, 횟수

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            block[r - 1][c - 1] = true;
        }

        moveMax = (25 - K) / 2;

        block[0][0] = true;
        block[4][4] = true;

        findAnswer(0, 0, 4, 4, 0);
        System.out.println(answer);
    }

    private static void findAnswer(int p1R, int p1C, int p2R, int p2C, int count) {
        if (moveMax == count) {
            if (p1R == p2R && p1C == p2C) {
                answer++;
            }
            return;
        }
        if (p1R == p2R && p1C == p2C) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int newP1R = p1R + dr[d];
            int newP1C = p1C + dc[d];
            if (newP1R < 0 || newP1R > 4 || newP1C < 0 || newP1C > 4) {
                continue;
            }
            if (block[newP1R][newP1C]) {
                continue;
            }
            for (int d2 = 0; d2 < 4; d2++) {
                int newP2R = p2R + dr[d2];
                int newP2C = p2C + dc[d2];
                if (newP2R < 0 || newP2R > 4 || newP2C < 0 || newP2C > 4) {
                    continue;
                }
                if (block[newP2R][newP2C]) {
                    continue;
                }
                block[newP1R][newP1C] = true;
                block[newP2R][newP2C] = true;
                findAnswer(newP1R, newP1C, newP2R, newP2C, count + 1);
                block[newP1R][newP1C] = false;
                block[newP2R][newP2C] = false;
            }
        }
    }
}
