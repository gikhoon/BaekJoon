import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int r;
    int c;
    int count;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
        count = 0;
    }

    Node(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        if (count > o.count) {
            return 1;
        } else if (count < o.count) {
            return -1;
        }
        return 0;
    }
}

public class Main {
    static int N, M;

    static int[][] map;

    static boolean[][] isVisited;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];
        isVisited = new boolean[N + 2][M + 2];

        for (int i = 0; i < M + 2; i++) {
            map[0][i] = 1;
            isVisited[0][i] = true;
            map[N + 1][i] = 1;
            isVisited[N + 1][i] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            map[i][0] = 1;
            isVisited[i][0] = true;
            map[i][M + 1] = 1;
            isVisited[i][M + 1] = true;
        }

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        System.out.println(splitLand());
    }

    private static int splitLand() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    PriorityQueue<Node> queue = new PriorityQueue<>();
                    queue.add(new Node(i, j));
                    isVisited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int newR = poll.r + dr[d];
                            int newC = poll.c + dc[d];
                            if (newR == N && newC == M) {
                                return poll.count;
                            }
                            if (map[newR][newC] == 0 && !isVisited[newR][newC]) {
                                isVisited[newR][newC] = true;
                                queue.add(new Node(newR, newC, poll.count));
                            } else if (!isVisited[newR][newC]) {
                                isVisited[newR][newC] = true;
                                queue.add(new Node(newR, newC, poll.count + 1));
                            }

                        }
                    }
                }
            }
        }
        return 0;
    }
}

