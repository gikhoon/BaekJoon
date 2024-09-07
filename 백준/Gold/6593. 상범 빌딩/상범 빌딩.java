import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int r;
    int c;
    int h;
    int dist;

    public Node(int h, int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.h = h;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object obj) {
        Node o = (Node) obj;

        return r == o.r && c == o.c && h == o.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c, h);
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][][] map;
    static boolean[][][] isVisited;
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dr = {1, 0, 0, -1, 0, 0};
    static int[] dc = {0, 1, -1, 0, 0, 0};
    static Node start;
    static Node exit;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (h == 0) {
                break;
            }
            map = new boolean[h+2][r+2][c+2];
            isVisited = new boolean[h+2][r+2][c+2];

            initMap(h,r,c);
            int minute = shortestPath();
            if (minute == 0) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in ").append(minute).append(" minute(s).").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int shortestPath() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        isVisited[start.h][start.r][start.c] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 6; i++) {
                int newH = node.h + dh[i];
                int newR = node.r + dr[i];
                int newC = node.c + dc[i];
                if(!isVisited[newH][newR][newC] && map[newH][newR][newC]){
                    Node newNode = new Node(newH, newR, newC, node.dist + 1);
                    if (newNode.equals(exit)) {
                        return node.dist + 1;
                    }
                    isVisited[newH][newR][newC] = true;
                    q.add(newNode);
                }
            }
        }
        return 0;
    }

    private static void initMap(int hLength, int rLength, int cLength) throws IOException {
        for (int h = 1; h <= hLength; h++) {
            for (int r = 1; r <= rLength; r++) {
                String[] split = br.readLine().split("");
                for (int i = 1; i <= cLength; i++) {
                    if (split[i-1].equals("S")) {
                        start = new Node(h, r, i, 0);
                    } else if (split[i-1].equals(".")) {
                        map[h][r][i] = true;
                    } else if (split[i-1].equals("E")) {
                        exit = new Node(h, r, i, 0);
                        map[h][r][i] = true;
                    }
                }
            }
            br.readLine();
        }
    }
}