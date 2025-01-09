import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int N, H;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H][N - 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = true;
        }

        dfs(0, 0, 0);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    static void dfs(int r, int c, int cnt) {
        if (checkAnswer()) {
            MIN = Math.min(cnt, MIN);
            return;
        }
        if (cnt >= 3 || cnt >= MIN) {
            return;
        }

        for (int i = r; i < H; i++) {
            for (int j = (i == r ? c : 0); j < N - 1; j++) {
                if (isValid(i, j)) {
                    map[i][j] = true;
                    dfs(i, j + 1, cnt + 1); // 다음 열부터 탐색
                    map[i][j] = false;
                }
            }
        }
    }

    static boolean isValid(int r, int c) {
        if (map[r][c]) return false;
        if (c > 0 && map[r][c - 1]) return false;
        if (c < N - 2 && map[r][c + 1]) return false;
        return true;
    }

    static boolean checkAnswer() {
        for (int i = 0; i < N; i++) {
            int index = i;
            for (int j = 0; j < H; j++) {
                if (index > 0 && map[j][index - 1]) {
                    index--;
                } else if (index < N - 1 && map[j][index]) {
                    index++;
                }
            }
            if (index != i) return false;
        }
        return true;
    }
}
