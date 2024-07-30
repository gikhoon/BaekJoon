import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        for(int i=0;i<progresses.length;i++){
            int leftDay = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) leftDay++;
            progresses[i] = leftDay;
        }
        List<Integer> progressCount = new ArrayList<>();
        int target = 0;
        while(target < progresses.length){
            int day = progresses[target];
            int count = 1;
            while(++target < progresses.length){
                if (progresses[target] <= day) count++;
                else break;
            }
            progressCount.add(count);
        }
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[progressCount.size()];
        
        for (int i=0;i<progressCount.size();i++){
            answer[i] = progressCount.get(i);
        }
        
        return answer;
    }
}