import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N {
    int r;
    int c;
    int count;
    int jump;

    public N(int r, int c, int count,int jump) {
        this.r = r;
        this.c = c;
        this.count = count;
        this.jump = jump;
    }
}

public class Main {
    static int K, W, H;
    static boolean[][] map;
    static boolean[][][] visited;
    static int[] nearDR = {0, 0, -1, 1};
    static int[] nearDC = {1, -1, 0, 0};
    static int[] jumpDR = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] jumpDC = {-2, 2, -1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                if (st.nextToken().equals("0")) {
                    map[i][j] = true;
                }
            }
        }

        Queue<N> q = new LinkedList<>();
        q.add(new N(0, 0, 0,0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            N cur = q.poll();

            if (cur.r == H - 1 && cur.c == W - 1) {
                System.out.println(cur.count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int newR = cur.r + nearDR[d];
                int newC = cur.c + nearDC[d];
                if (isNotValid(newR, newC) || visited[newR][newC][cur.jump]) continue;
                visited[newR][newC][cur.jump] = true;
                q.add(new N(newR, newC, cur.count + 1, cur.jump));
            }

            if (cur.jump == K) {
                continue;
            }
            for (int d = 0; d < 8; d++) {
                int newR = cur.r + jumpDR[d];
                int newC = cur.c + jumpDC[d];
                if(isNotValid(newR, newC) || visited[newR][newC][cur.jump + 1]) continue;
                visited[newR][newC][cur.jump + 1] = true;
                q.add(new N(newR, newC, cur.count + 1, cur.jump + 1));
            }
        }

        System.out.println(-1);
    }

    static boolean isNotValid(int r, int c) {
        return r < 0 || r >= H || c < 0 || c >= W || !map[r][c];
    }
}
