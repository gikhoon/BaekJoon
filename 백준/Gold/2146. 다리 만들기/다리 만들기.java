import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Node {
    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }
}

public class Main {
    static int[][] graph;
    static int[] xArray = {0, 0, 1, -1};
    static int[] yArray = {1, -1, 0, 0};
    static int N;
    static LinkedList<Queue<Node>> landList = new LinkedList<>();

    /**
     * 섬을 BFS로 만든다 N^2
     * 한 섬을 기준으로 거리 1, 거리 2... 이렇게 샌다. N^2
     * 있는 모든 섬에 대해 반복한다. N^2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = -1 * Integer.parseInt(st.nextToken());
            }
        }
        landList.add(new LinkedList<>());
        int land = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == -1) {
                    land++;
                    bridge(i, j, land);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < land + 1; i++) {
            int minD = findMin(i, min);
            if (minD == -1) {
                continue;
            }
            if (minD < min) {
                min = minD;
            }
        }

        System.out.println(min);

    }

    private static int findMin(int land, int min) {
        boolean[][] check = new boolean[N][N];
        Queue<Node> lands = landList.get(land);
        while (true) {
            Node currentNode = lands.poll();
            if (currentNode.getDistance() > min) {
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int newX = currentNode.getX() + xArray[i];
                int newY = currentNode.getY() + yArray[i];
                if (newX < 0 || newX > N - 1) continue;
                if (newY < 0 || newY > N - 1) continue;
                if (check[newX][newY]) continue;
                if ((graph[newX][newY] != land) && graph[newX][newY] != 0) {
                    return currentNode.getDistance();
                } else if (!check[newX][newY] && (graph[newX][newY] == 0)) {
                    check[newX][newY] = true;
                    lands.offer(new Node(newX, newY, currentNode.getDistance() + 1));
                }
            }
        }
    }

    private static void bridge(int x, int y, int land) {
        landList.add(new LinkedList<>());
        Queue<Integer> xList = new LinkedList<>();
        Queue<Integer> yList = new LinkedList<>();
        xList.offer(x);
        yList.offer(y);
        graph[x][y] = land;
        landList.get(land).offer(new Node(x, y, 0));
        while (!xList.isEmpty()) {
            Integer currentX = xList.poll();
            Integer currentY = yList.poll();
            for (int i = 0; i < 4; i++) {
                int newX = currentX + xArray[i];
                int newY = currentY + yArray[i];
                if (newX < 0 || newX > N - 1) continue;
                if (newY < 0 || newY > N - 1) continue;
                if (graph[newX][newY] == -1) {
                    graph[newX][newY] = land;
                    landList.get(land).offer(new Node(newX, newY, 0));
                    xList.offer(newX);
                    yList.offer(newY);
                }
            }
        }
    }
}
