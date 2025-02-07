import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Node {
    int r;
    int c;

    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return r == node.r && c == node.c;
    }

    @Override
    public int hashCode(){
        return Objects.hash(r, c);
    }
    public Node move(int r, int c) {
        this.r += r;
        this.c += c;
        return this;
    }
}

class Data {
    Node red;
    Node blue;
    int count;
    String command;

    public Data(Node red, Node blue, int count, String command){
        this.red = red;
        this.blue = blue;
        this.count = count;
        this.command = command;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(red, data.red) && Objects.equals(blue, data.blue) && Objects.equals(count, data.count);
    }

    @Override
    public int hashCode(){
        return Objects.hash(red, blue);
    }
}

public class Main {
    private static int[][] map;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static String[] dCommand = {"L", "D", "R", "U"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        map = new int[N][M];
        Node blue = null, red = null;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String s = split[j];
                if (s.equals("#")) map[i][j] = -1;
                else if (s.equals("O")) map[i][j] = 1;
                else if (s.equals("B")) blue = new Node(i, j);
                else if (s.equals("R")) red = new Node(i, j);
            }
        }

        Queue<Data> queue = new LinkedList<>();
        Set<Data> visited = new HashSet<>();
        Data init = new Data(red, blue, 0, "");
        queue.add(init);
        visited.add(init);

        while (!queue.isEmpty()) {
            Data data = queue.poll();

            if (data.count >= 10) continue;
            for (int i = 0; i < 4; i++) {
                boolean blueGoal = false;
                boolean redGoal = false;
                Node newRed = new Node(data.red.r, data.red.c);
                Node newBlue = new Node(data.blue.r, data.blue.c);
                while (true) {
                    if (!canMove(newRed, newBlue, i, redGoal)) {
                        break;
                    }

                    if (map[newRed.r + dr[i]][newRed.c + dc[i]] == 1) {
                        redGoal = true;
                        break;
                    } else if (map[newRed.r + dr[i]][newRed.c + dc[i]] == 0) {
                        newRed = newRed.move(dr[i], dc[i]);
                    }

                    if (map[newBlue.r + dr[i]][newBlue.c + dc[i]] == 1) {
                        blueGoal = true;
                        break;
                    } else if (map[newBlue.r + dr[i]][newBlue.c + dc[i]] == 0) {
                        newBlue = newBlue.move(dr[i], dc[i]);
                    }
                }

                if (redGoal) {
                    while (blueCanMove(newBlue, i)) {
                        if (map[newBlue.r + dr[i]][newBlue.c + dc[i]] == 1) {
                            blueGoal = true;
                            break;
                        } else if (map[newBlue.r + dr[i]][newBlue.c + dc[i]] == 0) {
                            newBlue = newBlue.move(dr[i], dc[i]);
                        }
                    }
                }

                if (redGoal && !blueGoal) {
                    System.out.println(data.count+1);
                    System.out.println(data.command + dCommand[i]);
                    return;
                }

                Data newNode = new Data(newRed, newBlue, data.count + 1, data.command + dCommand[i]);
                if (!blueGoal && !visited.contains(newNode)) {
                    queue.add(newNode);
                    visited.add(newNode);
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean blueCanMove(Node blueP, int i) {
        int newBlueR = blueP.r + dr[i];
        int newBlueC = blueP.c + dc[i];

        return map[newBlueR][newBlueC] != -1;
    }
    private static boolean canMove(Node redP, Node blueP, int i, boolean redGoal) {
        int newBlueR = blueP.r + dr[i];
        int newBlueC = blueP.c + dc[i];
        int newRedR = redP.r + dr[i];
        int newRedC = redP.c + dc[i];
        if (map[newBlueR][newBlueC] == -1 && map[newRedR][newRedC] == -1) return false;
        else if (map[newBlueR][newBlueC] == -1) {
            return blueP.r != newRedR || blueP.c != newRedC;
        } else if (!redGoal && map[newRedR][newRedC] == -1) {
            return redP.r != newBlueR || redP.c != newBlueC;
        }

        return true;
    }
}
