import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int r;
    int c;
    int length;

    public Node(int r, int c, int length) {
        this.r = r;
        this.c = c;
        this.length = length;
    }

    @Override
    public int compareTo(Node node) {
        return length - node.length;
    }
}

public class Main {
    static boolean[][] isVisited;
    static boolean[][] map;
    static int N;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N][N];
        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] splits = br.readLine().split("");
            for (int j=0;j<N;j++) {
                if (splits[j].equals("1")) {
                    map[i][j] = true;
                }
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));
        isVisited[0][0] = true;
        Node current;

        while (!q.isEmpty()) {
            current = q.poll();

            if (current.r == N - 1 && current.c == N - 1) {
                System.out.println(current.length);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newR = current.r + dr[i];
                int newC = current.c + dc[i];

                if (isValid(newR) && isValid(newC) && !isVisited[newR][newC]) {
                    isVisited[newR][newC] = true;
                    int block = 0;
                    if(!map[newR][newC]) block++;
                    q.add(new Node(newR, newC, current.length + block));
                }
            }
        }
    }

    private static boolean isValid(int index) {
        return index >=0 && index < N;
    }
}