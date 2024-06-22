import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] graph;
    static boolean[] isVisited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            isVisited = new boolean[N + 1];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 1; i <= N; i++) {
                if (!isVisited[i]) {
                    find(i);
                }
            }
            System.out.println(answer);
        }
    }

    private static void find(int i) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        while (true) {
            Integer currentNode = list.get(list.size() - 1);
            isVisited[currentNode] = true;
            int nextNode = graph[currentNode];
            if (isVisited[nextNode]) {
                int count = list.indexOf(nextNode);
                if (count == -1) {
                    answer += list.size();
                } else {
                    answer += count;
                }
                return;
            }
            list.add(nextNode);
        }
    }
}
