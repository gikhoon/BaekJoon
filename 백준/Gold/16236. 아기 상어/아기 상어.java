import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Node{
    int r;
    int c;
    int dist;

    public Node(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
public class Main {
    static int[][] map;
    static int BLOCK = 1000;
    static int N;
    static int sharkR = 0;
    static int sharkC = 0;
    static int sharkSize = 2;
    static int eatFish = 0;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N + 2][N + 2];

        for (int i = 0; i <= N + 1; i++) {
            map[i][0] = BLOCK;
            map[i][N + 1] = BLOCK;
            map[N + 1][i] = BLOCK;
            map[0][i] = BLOCK;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int data = Integer.parseInt(st.nextToken());
                if (data == 9) {
                    sharkR = i;
                    sharkC = j;
                } else {
                    map[i][j] = data;
                }
            }
        }

        int time = 0;
        while (true) {
            int beforeTime = time;
            time += moveShark();
            if (time == beforeTime) {
                System.out.println(time);
                break;
            } else {
                eatFish++;
                if (eatFish == sharkSize) {
                    sharkSize++;
                    eatFish = 0;
                }
            }
        }
    }

    private static int moveShark() {
        boolean[][] isVisited = new boolean[N + 2][N + 2];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sharkR, sharkC, 0));
        isVisited[sharkR][sharkC] = true;

        int r = BLOCK;
        int c = BLOCK;
        int dist = BLOCK;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.dist > dist) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newR = cur.r + dr[i];
                int newC = cur.c + dc[i];
                if (map[newR][newC] > 0 && map[newR][newC] < sharkSize) {
                    if (r > newR || (r == newR && c > newC)) {
                        r = newR;
                        c = newC;
                        dist = cur.dist;
                    }
                } else if (!isVisited[newR][newC] && map[newR][newC] <= sharkSize) {
                    isVisited[newR][newC] = true;
                    q.add(new Node(newR, newC, cur.dist + 1));
                }
            }
        }

        if (r == BLOCK) {
            return 0;
        }

        sharkR = r;
        sharkC = c;
        map[r][c] = 0;
        return dist + 1;

    }
}