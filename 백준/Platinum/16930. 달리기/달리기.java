import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] open;
    static int[][] dist;
    static int N, M, K;
    static final int INF = 1_000_000_000;
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    static boolean in(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        open = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                open[i][j] = (line[j] == '.');
                dist[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;
        int tr = Integer.parseInt(st.nextToken()) - 1;
        int tc = Integer.parseInt(st.nextToken()) - 1;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[sr][sc] = 0;
        q.offer(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int t = dist[r][c];

            if (r == tr && c == tc) {
                System.out.println(t);
                return;
            }

            for (int d = 0; d < 4; d++) {
                for (int step = 1; step <= K; step++) {
                    int nr = r + dr[d] * step;
                    int nc = c + dc[d] * step;

                    if (!in(nr, nc) || !open[nr][nc]) break;

                    // 이미 더 빠르게 방문 → 이 방향 더 진행해도 모두 불필요
                    if (dist[nr][nc] < t + 1) break;

                    // 같은 시간으로 이미 방문 → enqueue는 안 하지만 더 멀리 볼 가치는 있음
                    if (dist[nr][nc] == t + 1) continue;

                    dist[nr][nc] = t + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        System.out.println(-1);
    }
}
