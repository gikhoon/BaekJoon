import java.util.*;

class Solution {
    static ArrayList<Integer>[] tree;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        tree = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            tree[a].add(b);
            tree[b].add(a);
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            tree[a].remove(Integer.valueOf(b));
            tree[b].remove(Integer.valueOf(a));
            answer = Math.min(answer, getDifference(a,b,n));
            tree[a].add(b);
            tree[b].add(a);
        }
        
        return answer;
    }
    
    private int getDifference(int a, int b, int n) {
        return Math.abs(2 * getChild(a) - n);
    }
    
    private int getChild(int root) {
        boolean[] visited = new boolean[tree.length];
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        visited[root] = true;
        q.add(root);
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next : tree[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}