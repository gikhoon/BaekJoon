import java.io.*;
import java.util.*;

public class Main {
    static long[] dist;
    static ArrayList<Integer>[] link;
    static boolean[] isVisited;
    static long INF = Long.MAX_VALUE - 300_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        link = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            link[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        dijkstra(X);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                count++;
                sb.append(i).append("\n");
            }
        }

        if (count == 0) {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        isVisited[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : link[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
