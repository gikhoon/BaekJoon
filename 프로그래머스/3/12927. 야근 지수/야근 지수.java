import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int work : works) {
            q.add(work);
            answer += (work * work);
        }
        
        
        while(n > 0 && !q.isEmpty()) {
            int cur = q.poll();
            answer -= (cur * cur);
            cur--;
            if(cur > 0) {
                q.add(cur);
            }
            answer += (cur * cur);
            n--;
        }
        return answer;
    }
    
    //
}