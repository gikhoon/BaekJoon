import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if(computers[i][j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        int network = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                network++;
                findNeighbor(i);
            }
        }
        
        return network;
    }
    
    private void findNeighbor(int root) {
        Queue<Integer> q = new LinkedList<>();
        visited[root] = true;
        q.add(root);
        
        while(!q.isEmpty()) {
            int data = q.poll();
            for(int next : graph[data]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        
    }
}