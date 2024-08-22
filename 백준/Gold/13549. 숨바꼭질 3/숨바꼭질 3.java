import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x;
    int count;

    public Node(int x, int count) {
        this.x = x;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return count - o.count;
    }
}

public class Main {
    static int MAX = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == M) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[MAX+1];
        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(N, 0));
        visited[N] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.x] = true;
            int x1 = cur.x + 1;
            int x2 = cur.x - 1;
            int x3 = cur.x * 2;
            if (cur.x == M) {
                System.out.println(cur.count);
                break;
            }

            if (x1 <= MAX && !visited[x1]) {
                q.add(new Node(x1, cur.count+1));
            }

            if (x2 >= 0 && !visited[x2]) {
                q.add(new Node(x2, cur.count+1));
            }

            if (x3 <= MAX && !visited[x3]) {
                q.add(new Node(x3, cur.count));
            }
        }
    }
}