import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;
    int dir;
    int len;

    public Node(int r, int c, int len, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.len = len;
    }
}

public class Main {
    static int N, M;
    static boolean[][][] visited;
    static boolean[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("0")) {
                    map[i][j] = true;
                }
            }
        }

        // 1. 시작점 읽기 (큐 시작점)
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int startDir = Integer.parseInt(st.nextToken()) - 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startR, startC, 0, startDir));
        visited[startR][startC][startDir] = true;

        st = new StringTokenizer(br.readLine());
        int endR = Integer.parseInt(st.nextToken()) - 1;
        int endC = Integer.parseInt(st.nextToken()) - 1;
        int endDir = Integer.parseInt(st.nextToken()) - 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curDir = cur.dir;

            if (curR == endR && curC == endC && curDir == endDir) {
                System.out.println(cur.len);
                return;
            }

            //GO K
            for (int k = 1; k <= 3; k++) {
                int newR = curR + dr[curDir] * k;
                int newC = curC + dc[curDir] * k;
                if (newR < 0 || newR >= N || newC < 0 || newC >= M) {
                    continue;
                }
                if (!map[newR][newC]) {
                    break;
                }
                if (visited[newR][newC][curDir]) {
                    continue;
                }
                visited[newR][newC][curDir] = true;
                q.add(new Node(newR, newC, cur.len + 1, curDir));
            }

            int left = 0;
            int right = 0;
            switch (cur.dir) {
                case 0:
                    left = 3;
                    right = 2;
                    break;
                case 1:
                    left = 2;
                    right = 3;
                    break;
                case 2:
                    right = 1;
                    break;
                case 3:
                    left = 1;
                    break;
            }

            if (!visited[cur.r][cur.c][left]) {
                visited[cur.r][cur.c][left] = true;
                q.add(new Node(cur.r, cur.c, cur.len + 1, left));
            }
            if (!visited[cur.r][cur.c][right]) {
                visited[cur.r][cur.c][right] = true;
                q.add(new Node(cur.r, cur.c, cur.len + 1, right));
            }
        }

        System.out.println(-1);
    }
}