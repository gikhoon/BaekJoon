import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (command == 2) {
                sb.append("yes").append("\n");
                continue;
            }

            if (graph[num].size() == 1) {
                sb.append("no").append("\n");
            } else {
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);

    }
}
