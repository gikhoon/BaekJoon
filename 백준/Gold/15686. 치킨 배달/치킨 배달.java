import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Node> chicken = new ArrayList<>();
    static List<Node> home = new ArrayList<>();
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String s = st.nextToken();
                if (s.equals("1")) {
                    home.add(new Node(i, j));
                } else if (s.equals("2")) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        isVisited = new boolean[chicken.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int index) {
        if (depth == M) {
            findDist();
        }


        //7개인데 지금 5야 => 2개만 가능 남은 갯수
        //총 5개 뽑아야 하는데 지금 3까지만 가능
        if(isVisited.length - index < M - depth) return;
        for (int i = index; i < isVisited.length; i++) {
            isVisited[i] = true;
            dfs(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }

    static void findDist() {
        int sum = 0;
        for (Node house : home) {
            if(sum > answer) return;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if(!isVisited[i]) continue;
                Node ch = chicken.get(i);
                min = Math.min(min, dist(house, ch));
            }
            sum += min;
        }

        answer = Math.min(sum, answer);
    }

    static int dist(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
