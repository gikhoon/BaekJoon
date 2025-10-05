import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        int answer;
        for(answer = 1; answer < enemy.length + 1;answer++) {
            int e = enemy[answer-1];
            //System.out.println(e);
            sum += e;
            pq.add(e);
            if(sum <= n) {
                continue;
            }
            
            while(!pq.isEmpty() && k > 0 && sum > n) {
                int p = pq.poll();
                //System.out.println("poll" + p +" k= " + k);
                k--;
                sum -= p;
            }
            //System.out.println("sum= "+ sum);
            if(sum > n) {
                break;
            }
        }
        if(answer > enemy.length) {
            return enemy.length;
        }
        return answer - 1 ;
    }
}