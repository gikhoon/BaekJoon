import java.io.IOException;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int weight;

    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static ArrayList<Node>[] graph;
    static int N;

    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, weight));
            graph[y].add(new Node(x, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int r1 = 0;
        r1 += dijkstra(1, v1);
        r1 += dijkstra(v1, v2);
        r1 += dijkstra(v2, N);

        int r2 = 0;
        r2 += dijkstra(1, v2);
        r2 += dijkstra(v2, v1);
        r2 += dijkstra(v1, N);

        if (r1 >= INF && r2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(r1, r2));
        }
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] isVisit = new boolean[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curEnd = curNode.num;

            if (!isVisit[curEnd]) {
                isVisit[curEnd] = true;

                for (Node next : graph[curEnd]) {
                    if (dist[next.num] > dist[curEnd] + next.weight) {
                        dist[next.num] = dist[curEnd] + next.weight;
                        pq.add(new Node(next.num, dist[next.num]));
                    }
                }
            }
        }
        return dist[end];
    }
}