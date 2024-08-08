import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node2 implements Comparable<Node2> {
    int node;
    int startTime;
    int endTime;

    Node2(int node,int startTime, int endTime) {
        this.node = node;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Node2 o) {
        return endTime - o.endTime;
    }
}


public class Main {

    static List<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int[] buildingTime = new int[N + 1];
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                buildingTime[j] = Integer.parseInt(input[j-1]);
            }

            graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }
            int[] isParent = new int[N + 1];
            boolean[] isVisited = new boolean[N + 1];

            for (int j = 0; j < K; j++) {
                input = br.readLine().split(" ");
                graph[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
                isParent[Integer.parseInt(input[1])]++;
            }

            int targetPoint = Integer.parseInt(br.readLine());

            boolean found = false;
            PriorityQueue<Node2> queue = new PriorityQueue<>();
            for (int i = 1; i <= N; i++) {
                if (!isVisited[i] && isParent[i] == 0) {
                    isVisited[i] = true;
                    if (i == targetPoint) {
                        sb.append(buildingTime[i]).append("\n");
                        found = true;
                        break;
                    }
                    queue.add(new Node2(i,0, buildingTime[i]));
                }
            }


            while (!queue.isEmpty() && !found) {
                Node2 node = queue.poll();
                for (Integer link : graph[node.node]) {
                    if (isVisited[link]) {continue;}
                    isParent[link]--;
                    if (!isVisited[link] && isParent[link] == 0) {
                        isVisited[link] = true;
                        if (link == targetPoint) {
                            sb.append(node.endTime+buildingTime[link]).append("\n");
                            found = true;
                            break;
                        }
                        queue.add(new Node2(link, node.endTime, node.endTime+buildingTime[link]));
                    }
                }

                if (found) break;
            }


        }

        System.out.println(sb);
    }
}