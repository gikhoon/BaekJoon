import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static ArrayList<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b) {
                continue;
            }
            map[a].add(new Node(b, c));
        }

        int[][] memo = new int[M + 1][N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int cnt = 1;
        while (!q.isEmpty() && cnt < M) {
            int size = q.size();
            while (size-- > 0) {
                Integer current = q.poll();
                for (Node next : map[current]) {
                    int index = next.index;
                    int weight = memo[cnt][current] + next.weight;

                    if (memo[cnt + 1][index] >= weight) {
                        continue;
                    }

                    memo[cnt + 1][index] = weight;
                    q.add(index);
                }
            }
            cnt++;
        }

        int answer = 0;
        for (int i = 2; i <= M; i++) {
            answer = Math.max(answer, memo[i][N]);
        }

        System.out.println(answer);
    }
}

class Node {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
