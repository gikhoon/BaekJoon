import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static List<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for (int j=1;j<count;j++) {
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                parent[b]++;
                a = b;
            }
        }

        visited = new boolean[N + 1];

        addNode();

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append("\n");
            for (int v : graph[u]) {
                if (!visited[v]) {
                    parent[v]--;
                }
            }

            addNode();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);
    }

    static void addNode() {
        for (int i=1;i<parent.length;i++) {
            if (parent[i] == 0 && !visited[i]) {
                q.add(i);
                visited[i] = true;
            }
        }
    }
}
