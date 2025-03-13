import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<Integer>[] wins = new ArrayList[n+1];
        ArrayList<Integer>[] loses = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            wins[i] = new ArrayList<>();
            loses[i] = new ArrayList<>();
        }
        
        for(int[] result : results) {
            wins[result[0]].add(result[1]);
            loses[result[1]].add(result[0]);
        }
        
        int answer = 0;
        for(int i=1;i<=n;i++) {
            boolean[] visit = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            
            visit[i] = true;
            q.add(i);
            while(!q.isEmpty()) {
                int win = q.poll();
                for(int lose : wins[win]) {
                    if(!visit[lose]) {
                        visit[lose] = true;
                        q.add(lose);
                    }
                }
            }
            
            q.add(i);
            while(!q.isEmpty()) {
                int lose = q.poll();
                for(int win : loses[lose]) {
                    if(!visit[win]) {
                        visit[win] = true;
                        q.add(win);
                    }
                }
            }
            
            boolean flag = true;
            for(int j=1;j<=n;j++) {
                if(!visit[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }
        return answer;
    }
}