import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        Node n = (Node) obj;
        return n.r == r && n.c == c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}
public class Main {

    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] commands = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                switch (commands[j]) {
                    case "D" -> map[i][j] = 2;
                    case "R" -> map[i][j] = 1;
                    case "L" -> map[i][j] = 3;
                    default -> map[i][j] = 0;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        int safePlace = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c]) {
                    Set<Node> set = new HashSet<>();
                    int currentR = r;
                    int currentC = c;
                    while (!set.contains(new Node(currentR, currentC)) && !visited[currentR][currentC]) {
                        set.add(new Node(currentR, currentC));
                        int newR = currentR + dr[map[currentR][currentC]];
                        int newC = currentC + dc[map[currentR][currentC]];
                        currentR = newR;
                        currentC = newC;
                    }

                    if (!visited[currentR][currentC]) {
                        safePlace++;
                    }

                    for (Node node : set) {
                        visited[node.r][node.c] = true;
                    }
                }
            }
        }

        System.out.println(safePlace);
    }
}