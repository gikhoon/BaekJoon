import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<(int)Math.pow(2,i);j++){
                int sum = queue.poll();
                queue.add(sum+numbers[i]);
                queue.add(sum-numbers[i]);
            }
        }
        
        int answer = 0;
        while(!queue.isEmpty()){
            if(queue.poll() == target) answer++;
        }
        
        return answer;
    }
}