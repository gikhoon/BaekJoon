import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new  PriorityQueue<>();
        int answer = 0;
        for(int i : scoville){
            queue.add(i);
        }
        
        while(queue.size() > 1){
            int a = queue.peek();
            if (a >= K) break;
            queue.poll();
            int b = queue.poll();
            queue.add(a + 2 * b);
            answer++;
        }
        
        if (queue.peek() < K) return -1;
    
        return answer;
    }
}