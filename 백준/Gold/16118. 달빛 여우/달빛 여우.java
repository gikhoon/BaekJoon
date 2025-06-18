import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int num;
    long weight;
    boolean even;

    public Node(int num, long weight, boolean even) {
        this.num = num;
        this.weight = weight;
        this.even = even;
    }

    public Node(int num, long weight) {
        this.num = num;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return (int) (weight - n.weight);
    }
}

public class Main {
    static List<Node>[] graph;
    static int N;
    static long[] aDist;
    static long[] bDist;
    static final long INF = 5_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w * 2L));
            graph[b].add(new Node(a, w * 2L));
        }

        fox();
        wolf();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (aDist[i] < bDist[i]) {
                sum++;
            }
        }

        System.out.println(sum);

    }

    private static void wolf() {
        bDist = new long[N + 1];
        long[][] dist = new long[N + 1][2]; // 0: 홀수 차례, 1: 짝수 차례
        boolean[][] visit = new boolean[N + 1][2];

        for (int i = 1; i <= N; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        dist[1][1] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0, true));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int idx = cur.even ? 1 : 0;

            if (visit[cur.num][idx]) continue;
            visit[cur.num][idx] = true;

            for (Node next : graph[cur.num]) {
                long weight = next.weight;
                int nextIdx = cur.even ? 0 : 1;

                if (cur.even) {
                    weight /= 2;
                } else {
                    weight *= 2;
                }

                if (dist[next.num][nextIdx] > dist[cur.num][idx] + weight) {
                    dist[next.num][nextIdx] = dist[cur.num][idx] + weight;
                    q.add(new Node(next.num, dist[next.num][nextIdx], !cur.even));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bDist[i] = Math.min(dist[i][0], dist[i][1]);
        }
    }

    private static void fox() {
        aDist = new long[N + 1];
        boolean[] visit = new boolean[N + 1];

        Arrays.fill(aDist, INF);

        aDist[1] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(visit[cur.num]) continue;

            visit[cur.num] = true;
            for (Node next : graph[cur.num]) {
                if (aDist[next.num] > aDist[cur.num] + next.weight) {
                    aDist[next.num] = aDist[cur.num] + next.weight;
                    q.add(new Node(next.num, aDist[next.num]));
                }
            }
        }

    }
}