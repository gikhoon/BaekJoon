import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    /**
     * 노드 끼리를 다 연결시켜 놓는다
     * parentNode를 다 0으로 초기화하고 1 노드부터 BFS를 한다
     * 만약 parentNode가 0이 아니면 부모 노드이니까 스킵
     * 0이라면 더 밑에 있는 노드기 때문에 연결된 값이 부모 노드
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int[] parentNode = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parentNode[1] = 1;
        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            for (Integer i : tree.get(n)) {
                if (parentNode[i] == 0) {
                    parentNode[i] = n;
                    queue.add(i);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parentNode[i]);
        }

    }

}
