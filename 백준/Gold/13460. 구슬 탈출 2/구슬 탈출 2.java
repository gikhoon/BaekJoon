import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node2 {
    Position blue;
    Position red;
    int count;

    public Node2(Position blue, Position red, int count) {
        this.blue = blue;
        this.red = red;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node2 node2 = (Node2) o;
        return Objects.equals(blue, node2.blue) && Objects.equals(red, node2.red);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blue, red);
    }
}

class Position implements Cloneable {
    int r;
    int c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return r == position.r && c == position.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }

    @Override
    protected Position clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e) {

        }
        return (Position) clone;
    }

    public Position move(int r, int c) {
        this.r += r;
        this.c += c;
        return this;
    }
}

public class Main {

    static int[][] graph;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        Position blue = null, red = null;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String s = split[j];
                if (s.equals("#")) graph[i][j] = -1;
                else if (s.equals("O")) graph[i][j] = 1;
                else if (s.equals("B")) blue = new Position(i, j);
                else if (s.equals("R")) red = new Position(i, j);
            }
        }

        Queue<Node2> queue = new LinkedList<>();
        Set<Node2> visited = new HashSet<>();
        Node2 initNode = new Node2(blue, red, 0);
        queue.add(initNode);
        visited.add(initNode);

        while (!queue.isEmpty()) {
            Node2 node = queue.poll();
            
            if (node.count >= 10) continue;
            for (int i = 0; i < 4; i++) {
                boolean blueGoal = false;
                boolean redGoal = false;
                Position redP = node.red.clone();
                Position blueP = node.blue.clone();
                while (true) {
                    if (!canMove(redP, blueP, i, redGoal)) {
                        break;
                    }

                    if (graph[redP.r + dr[i]][redP.c + dc[i]] == 1) {
                        redGoal = true;
                        break;
                    } else if (graph[redP.r + dr[i]][redP.c + dc[i]] == 0) {
                        redP = redP.move(dr[i], dc[i]);
                    }

                    if (graph[blueP.r + dr[i]][blueP.c + dc[i]] == 1) {
                        blueGoal = true;
                        break;
                    } else if (graph[blueP.r + dr[i]][blueP.c + dc[i]] == 0) {
                        blueP = blueP.move(dr[i], dc[i]);
                    }
                }

                if (redGoal) {
                    while (blueCanMove(blueP, i)) {
                        if (graph[blueP.r + dr[i]][blueP.c + dc[i]] == 1) {
                            blueGoal = true;
                            break;
                        } else if (graph[blueP.r + dr[i]][blueP.c + dc[i]] == 0) {
                            blueP = blueP.move(dr[i], dc[i]);
                        }
                    }
                }

                if (redGoal && !blueGoal) {
                    System.out.println(node.count+1);
                    return;
                }

                Node2 newNode = new Node2(blueP, redP, node.count + 1);
                if (!blueGoal && !visited.contains(newNode)) {
                    queue.add(newNode);
                    visited.add(newNode);
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean blueCanMove(Position blueP, int i) {
        int newBlueR = blueP.r + dr[i];
        int newBlueC = blueP.c + dc[i];

        return graph[newBlueR][newBlueC] != -1;
    }

    private static boolean canMove(Position redP, Position blueP, int i, boolean redGoal) {
        int newBlueR = blueP.r + dr[i];
        int newBlueC = blueP.c + dc[i];
        int newRedR = redP.r + dr[i];
        int newRedC = redP.c + dc[i];
        if (graph[newBlueR][newBlueC] == -1 && graph[newRedR][newRedC] == -1) return false;
        else if (graph[newBlueR][newBlueC] == -1) {
            return blueP.r != newRedR || blueP.c != newRedC;
        } else if (!redGoal && graph[newRedR][newRedC] == -1) {
            return redP.r != newBlueR || redP.c != newBlueC;
        }

        return true;
    }
}