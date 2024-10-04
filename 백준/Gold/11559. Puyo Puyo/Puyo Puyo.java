import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static String[][] map = new String[12][6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                map[i][j] = split[j];
            }
        }

        int puyo = 0;
        boolean finished = false;
        boolean[][] isVisited;
        while (!finished) {
            boolean isPuyoExist = false;
            isVisited = new boolean[12][6];
            for (int r = 11; r >= 0; r--) {
                for (int c = 0; c < 6; c++) {
                    if (!map[r][c].equals(".") && !isVisited[r][c]) {
                        List<Node> nodeList = findPuyo(r, c, isVisited);
                        if (nodeList.size() >= 4) {
                            isPuyoExist = true;
                            for (Node delete : nodeList) {
                                map[delete.r][delete.c] = ".";
                            }
                        }
                    }
                }
            }

            if (isPuyoExist) {
                puyo++;
                pullDownMap();
            } else {
                finished = true;
            }
        }

        System.out.println(puyo);
    }

    private static void pullDownMap() {
        for (int c = 0; c < 6; c++) {
            int index = 11;
            for (int r = 11; r >= 0; r--) {
                if (!map[r][c].equals(".")) {
                    map[index][c] = map[r][c];
                    if (index != r) {
                        map[r][c] = ".";
                    }
                    index--;
                }
            }
        }
    }

    private static List<Node> findPuyo(int r, int c, boolean[][] isVisited) {
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        q.add(new Node(r, c));
        isVisited[r][c] = true;
        String color = map[r][c];

        while (!q.isEmpty()) {
            Node poll = q.poll();
            list.add(poll);
            for (int d = 0; d < 4; d++) {
                int newR = poll.r + dr[d];
                int newC = poll.c + dc[d];
                if (isValid(newR, newC) && !isVisited[newR][newC] && map[newR][newC].equals(color)) {
                    isVisited[newR][newC] = true;
                    q.add(new Node(newR, newC));
                }
            }
        }

        return list;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < 12 && c >= 0 && c < 6;
    }
}