import java.io.*;
import java.util.*;

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.r == N - 1 && cur.c == N - 1) {
                System.out.println("HaruHaru");
                return;
            }

            for (int i = 0; i < 2; i++) {
                int newR = cur.r + dr[i] * map[cur.r][cur.c];
                int newC = cur.c + dc[i] * map[cur.r][cur.c];
                if (newR < N && newC < N && !isVisited[newR][newC]) {
                    isVisited[newR][newC] = true;
                    q.add(new Node(newR, newC));
                }
            }
        }

        System.out.println("Hing");
    }
}
