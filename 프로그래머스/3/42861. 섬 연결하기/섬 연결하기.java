import java.util.*;

class Solution {
    int[] parents;
    
    class Bridge implements Comparable<Bridge> {
        int from;
        int to;
        int cost;
        
        public Bridge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Bridge o) {
            return this.cost - o.cost;
        }
    }
    private int findParent(int n) {
        if(parents[n] != n) {
            parents[n] = findParent(parents[n]);
        }
        return parents[n];
    }
    
    private void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b){
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Bridge> bridges = new ArrayList<>();
        
        for(int[] cost : costs) {
            bridges.add(new Bridge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(bridges);
        
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for(Bridge bridge : bridges) {
            if (findParent(bridge.from) != findParent(bridge.to)) {
                union(bridge.from, bridge.to);
                answer += bridge.cost;
            }
        }
        
        
        return answer;
    }
}