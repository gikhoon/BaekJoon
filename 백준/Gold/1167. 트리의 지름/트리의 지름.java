import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.Stack;

/**
 * 계속 DFS로 찾아
 * 자식 노드가 있으면 들어가
 * 없으면 다음을 실행
 * 자신 weight + 자식 노드 중 최대 length = 본인의 최대 lengh
 * 자식의 최대 length를 하나씩 가져와 가장 작은 값 + 가장 큰 값을 더한 값이 최종 길이보다 큰지 확인
 * stack에서 뺀다.
 */
public class Main {
    static class Node {
        private int num;
        private int weight;

        public Node(int num, int weight) {
            this.weight = weight;
            this.num = num;
        }
    }

    static long answer;
    static ArrayList<Node>[] tree;
    static int N;
    static int farthestNode;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                int y = Integer.parseInt(st.nextToken());
                tree[n].add(new Node(x, y));
                tree[x].add(new Node(n, y));
            }
        }
        visited = new boolean[N + 1];
        answer = 0;
        farthestNode = 1;
        dfs(1, 0);

        visited = new boolean[N + 1];
        answer = 0;
        dfs(farthestNode, 0);

        System.out.println(answer);
    }

    static void dfs(int node, long distance) {
        visited[node] = true;

        if (distance > answer) {
            answer = distance;
            farthestNode = node;
        }

        for (Node near : tree[node]) {
            if (!visited[near.num]) {
                dfs(near.num, distance + near.weight);
            }
        }
    }

}
