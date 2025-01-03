import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int answer;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        int gr = 0;
        int gc = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char data = s.charAt(j);
                if (data == 'G') {
                    gr = i;
                    gc = j;
                    continue;
                }
                map[i][j] = data;
            }
        }

        dfs(gr, gc, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int eat, int time) {
        if (eat + T - time < answer) {
            return;
        }

        if (time == T) {
            answer = Math.max(answer, eat);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if (newR < 0 || newR >= R || newC < 0 || newC >= C) {
                continue;
            }
            if(map[newR][newC] == '#') continue;
            if (map[newR][newC] == 'S') {
                map[newR][newC] = '.';
                dfs(newR, newC, eat + 1, time + 1);
                map[newR][newC] = 'S';
            } else {
                dfs(newR, newC, eat, time + 1);
            }
        }
    }
}
