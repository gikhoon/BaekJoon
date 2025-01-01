import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int N, M , COIN;
    static int start, end;
    static ArrayList<Node>[] link;
    static int[] dist;
    static final int INF = 20_000_000;
    static int cost = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];

        link = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            link[i] = new ArrayList<>();
        }

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        COIN = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            link[start].add(new Node(end, weight));
            link[end].add(new Node(start, weight));
        }
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        dfs(start, 0, 0, visited);
        if (cost == INF) {
            System.out.println(-1);
        } else {
            System.out.println(cost);
        }
    }

    private static void dfs(int node, int maxCoin, int totalCoin, boolean[] visited) {
        if (totalCoin > COIN) {
            return;
        }
        if (node == end) {
            cost = Math.min(cost, maxCoin);
            return;
        }

        for (Node next : link[node]) {
            if (!visited[next.end]) {
                visited[next.end] = true;
                dfs(next.end, Math.max(maxCoin, next.weight), totalCoin + next.weight, visited);
                visited[next.end] = false;
            }
        }
    }
}