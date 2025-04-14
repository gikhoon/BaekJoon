import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (r < 0 || r>=N || c <0 || c>=M || map[r][c] == 1) {
                break;
            }

            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }


            int newD = d - 1;
            if (newD == -1) {
                newD = 3;
            }
            int fistD = newD;

            boolean isExist = false;
            while (true) {
                int newR = r + dr[newD];
                int newC = c + dc[newD];
                if ((newR < 0 || newR >= N || newC < 0 || newC >= M) || map[newR][newC] != 0) {
                    newD -= 1;
                    if (newD == -1) newD = 3;
                    if (newD == fistD) break;
                    continue;
                }

                r = newR;
                c = newC;
                isExist = true;
                break;
            }

            //4곳 다 존재하지 않을때
            if (!isExist) {
                r -= dr[d];
                c -= dc[d];
                continue;
            }

            //존재할때
            d = newD;
        }

        System.out.println(answer);
    }
}