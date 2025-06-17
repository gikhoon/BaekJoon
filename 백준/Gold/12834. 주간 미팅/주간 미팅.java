import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class V implements Comparable<V> {
    int num;
    int length;

    public V(int num, int length) {
        this.num = num;
        this.length = length;
    }

    @Override
    public int compareTo(V o) {
        return length - o.length;
    }
}

public class Main {
    static List<V>[] graph;
    static int sum = 0;
    static int INF = 200_000_000;
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] people = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph[start].add(new V(end, length));
            graph[end].add(new V(start, length));
        }

        for (int person : people) {
            dijkstra(person, A, B);
        }

        System.out.println(sum);
    }

    private static void dijkstra(int start, int a, int b) {
        int[] dist = new int[V + 1];
        boolean[] isVisit = new boolean[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<V> q = new PriorityQueue<>();
        q.add(new V(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            V cur = q.poll();
            int num = cur.num;

            if (!isVisit[num]) {
                isVisit[num] = true;

                for (V next : graph[num]) {
                    if (dist[next.num] > dist[num] + next.length) {
                        dist[next.num] = dist[num] + next.length;
                        q.add(new V(next.num, dist[next.num]));
                    }
                }
            }
        }

        if (dist[a] == INF) {
            sum += -1;
        } else {
            sum += dist[a];
        }

        if (dist[b] == INF) {
            sum += -1;
        } else {
            sum += dist[b];
        }
    }
}