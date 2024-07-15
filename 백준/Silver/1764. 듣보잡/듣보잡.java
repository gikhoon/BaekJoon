import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> NList = new HashSet<>();

        for (int i = 0; i < N; i++) {
            NList.add(br.readLine());
        }

        PriorityQueue<String> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (NList.contains(name)) {
                queue.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(queue.size()).append("\n");
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }

        System.out.println(sb);
    }
}

