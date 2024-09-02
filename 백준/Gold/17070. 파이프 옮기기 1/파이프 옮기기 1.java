import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    static boolean[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("0")) map[i][j] = true;
            }
        }

        DFS(1, 2, 0);

        System.out.println(answer);
    }

    static void DFS(int r, int c, int direction) {
        if (r == N && c == N) {
            answer++;
            return;
        }

        switch (direction) {
            case 0:
                if (map[r][c + 1]) {
                    DFS(r, c + 1, 0);
                }
                break;
            case 1:
                if (map[r + 1][c]) DFS(r + 1, c, 1);
                break;
            case 2:
                if (map[r + 1][c]) DFS(r + 1, c, 1);
                if (map[r][c + 1]) DFS(r, c + 1, 0);
                break;
        }

        if (map[r + 1][c] && map[r][c + 1] && map[r + 1][c + 1]) {
            DFS(r + 1, c + 1, 2);
        }
    }
}