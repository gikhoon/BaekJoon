import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int dest;
        int weight;
        
        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;
    static int maxDistance;
    static int farthestNode;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        // First DFS to find one endpoint of the longest path
        visited = new boolean[n + 1];
        maxDistance = 0;
        farthestNode = 1;
        dfs(1, 0);

        // Second DFS from the farthest node found
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }
    
    static void dfs(int node, int distance) {
        visited[node] = true;
        
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }
        
        for (Node neighbor : tree.get(node)) {
            if (!visited[neighbor.dest]) {
                dfs(neighbor.dest, distance + neighbor.weight);
            }
        }
    }
}