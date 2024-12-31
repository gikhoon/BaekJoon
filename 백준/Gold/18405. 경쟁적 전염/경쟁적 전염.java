import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x;
    int y;
    int second;
    int num;

    public Node(int x, int y, int second, int num) {
        this.x = x;
        this.y = y;
        this.second = second;
        this.num = num;
    }

    @Override
    public int compareTo(Node n) {
        if (second != n.second) {
            return second - n.second;
        }
        return num - n.num;
    }
}

public class Main {
    static int N, K;
    static int S, X, Y;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    map[i][j] = num;
                    pq.add(new Node(i, j, 0, num));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        while (!pq.isEmpty() && pq.peek().second < S) {
            Node node = pq.poll();
            for (int d = 0; d < 4; d++) {
                int newX = node.x + dx[d];
                int newY = node.y + dy[d];
                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }
                if (map[newX][newY] == 0) {
                    map[newX][newY] = node.num;
                    pq.add(new Node(newX, newY, node.second + 1, node.num));
                }
            }
            if(map[X][Y] != 0) break;
        }

        System.out.println(map[X][Y]);
    }
}