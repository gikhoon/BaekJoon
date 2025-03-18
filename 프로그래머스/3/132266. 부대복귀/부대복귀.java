import java.util.*;
class Path {
    int index;
    int len;
    
    public Path(int index, int len) {
        this.index = index;
        this.len = len;
    }
}

class Solution {
    private ArrayList<Integer>[] roadList;
    private int[] cost;
    private int n;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        roadList = new ArrayList[n+1];
        this.n = n;
        for(int i=1;i<=n;i++) {
            roadList[i] = new ArrayList<>();
        }
        
        for(int[] road : roads) {
            roadList[road[0]].add(road[1]);
            roadList[road[1]].add(road[0]);
        }
        
        cost = new int[n+1];
        Arrays.fill(cost, -1);
        searchCost(destination);
        
        int[] answer = new int[sources.length];
        for(int i=0;i<answer.length;i++) {
            answer[i] = cost[sources[i]];
        }
        return answer;
    }
    
    private void searchCost(int start) {
        boolean[] isVisited = new boolean[n+1];
        Queue<Path> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(new Path(start, 0));
        cost[start] = 0;
        while(!q.isEmpty()) {
            Path cur = q.poll();
            for(int next : roadList[cur.index]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    cost[next] = cur.len + 1;
                    q.add(new Path(next, cur.len + 1));
                }
            }
        }
    }
}