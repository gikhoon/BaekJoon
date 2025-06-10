import java.io.*;
import java.util.*;

class Node {
    int num;
    int time;

    public Node(int num, int time) {
        this.num = num;
        this.time = time;
    }
}

public class Main {
    static int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Node>[] link = new ArrayList[n + 1];
            int[] dist = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dist[i] = INF;
                link[i] = new ArrayList<>();
            }
            boolean[] isCheck = new boolean[n + 1];

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                link[b].add(new Node(a, s));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1.time));
            pq.add(new Node(c, 0));
            dist[c] = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (!isCheck[cur.num]) {
                    isCheck[cur.num] = true;

                    for (Node next : link[cur.num]) {
                        if (dist[next.num] > dist[cur.num] + next.time) {
                            dist[next.num] = dist[cur.num] + next.time;
                            pq.add(new Node(next.num, dist[next.num]));
                        }
                    }
                }
            }

            int count = 0;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    count++;
                    total = Math.max(total, dist[i]);
                }
            }

            sb.append(count + " " + total).append("\n");
        }

        System.out.println(sb);
    }
}
