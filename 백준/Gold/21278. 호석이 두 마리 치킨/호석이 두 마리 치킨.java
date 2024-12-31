import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int MIN = Integer.MAX_VALUE;
    static int minStart, minEnd;
    static ArrayList<Integer>[] link;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        link = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            link[start].add(end);
            link[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            calculatePath(i);
        }
        for (int start = 1; start <= N; start++) {
            for (int end = start + 1; end <= N; end++) {
                int sum = 0;
                for (int node = 1; node <= N; node++) {
                    sum += Math.min(map[start][node], map[end][node]);
                }
                if (sum < MIN) {
                    MIN = sum;
                    minStart = start;
                    minEnd = end;
                }
            }
        }

        System.out.println(minStart + " " + minEnd + " " + MIN * 2);
    }

    private static void calculatePath(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int neighbor : link[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    int newDist = map[start][current] + 1;
                    map[start][neighbor] = newDist;
                    map[neighbor][start] = newDist;
                    queue.add(neighbor);
                }
            }
        }
    }
}