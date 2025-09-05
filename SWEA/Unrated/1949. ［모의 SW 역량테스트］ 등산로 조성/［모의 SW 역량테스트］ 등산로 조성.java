import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int N, K;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            answer = 0;

            Set<int[]> set = new HashSet<>();
            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new  StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > max) {
                        max = map[i][j];
                        set.clear();
                        set.add(new int[] {i, j});
                    } else if (map[i][j] == max) {
                        set.add(new int[] {i, j});
                    }
                }
            }

            for (int[] high : set) {
                dfs(high[0], high[1], 1, false);
            }

            System.out.println("#" + t + " "+answer);

        }
    }

    static void dfs(int r, int c, int depth, boolean isCarved) {
        visited[r][c] = true;
        for(int d=0;d<4;d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if(!isValid(newR, newC)) continue;
            if (map[r][c] > map[newR][newC]) {
                dfs(newR, newC, depth + 1, isCarved);
            } else {
                if(isCarved || map[newR][newC] - map[r][c] >= K) continue;
                int tmp = map[newR][newC];
                map[newR][newC] = map[r][c] -1;
                dfs(newR, newC, depth + 1, true);
                map[newR][newC] = tmp;
            }
        }
        visited[r][c] = false;

        answer = Math.max(answer, depth);
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N) return false;
        return !visited[r][c];
    }
}
