import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;
    int lose;

    public Node(int r, int c, int lose) {
        this.r = r;
        this.c = c;
        this.lose = lose;
    }
}

class ZoneRange {
    int startR;
    int startC;
    int endR;
    int endC;

    public ZoneRange(int startR, int startC, int endR, int endC) {
        this.startR = startR;
        this.startC = startC;
        this.endR = endR;
        this.endC = endC;
    }
}

public class Main {
    static ZoneRange[] critical;
    static ZoneRange[] dead;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited = new boolean[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        critical = new ZoneRange[n];
        setZone(br, n, critical);

        int m = Integer.parseInt(br.readLine());
        dead = new ZoneRange[m];
        setZone(br, m, dead);

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.lose));
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            //500,500인지 확인
            if (cur.r == 500 && cur.c == 500) {
                answer = cur.lose;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int r = cur.r + dr[i];
                int c = cur.c + dc[i];
                if (isOutRange(r, c) || visited[r][c] || isInclude(r, c, dead)) {
                    continue;
                }

                visited[r][c] = true;
                if (isInclude(r, c, critical)) {
                    q.add(new Node(r, c, cur.lose + 1));
                } else {
                    q.add(new Node(r, c, cur.lose));
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static boolean isOutRange(int r, int c) {
        return r < 0 || r > 500 || c < 0 || c > 500;
    }

    private static boolean isInclude(int r, int c, ZoneRange[] zones) {
        for (ZoneRange z : zones) {
            if (r >= z.startR && r <= z.endR && c >= z.startC && c <= z.endC) {
                return true;
            }
        }
        return false;
    }

    private static void setZone(BufferedReader br, int length, ZoneRange[] zone) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            zone[i] = new ZoneRange(Math.min(r1, r2), Math.min(c1, c2), Math.max(r1, r2), Math.max(c1, c2));
        }
    }
}
