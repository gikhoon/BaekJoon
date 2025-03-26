import java.util.*;

class Solution {
    private int answer = 0;
    private List<Integer>[] connectedNodes;
    
    private int dfs(int node, int prev) {
        if (connectedNodes[node].size() == 1 && connectedNodes[node].get(0) == prev)
            return 1;
        int net = 0;
        for (int i = 0; i < connectedNodes[node].size(); i++) {
            int next = connectedNodes[node].get(i);
            if (next == prev) continue;
            net += dfs(next, node);
        }
        if (net == 0)
            return 1;
        answer++;
        return 0;
    }
    
    public int solution(int n, int[][] lighthouse) {
        connectedNodes = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) connectedNodes[i] = new ArrayList<>();
        for (int[] edge : lighthouse) {
            int a = edge[0]; int b = edge[1];
            connectedNodes[a].add(b);
            connectedNodes[b].add(a);
        }
        dfs(1, 0);
        return answer;
    }
}