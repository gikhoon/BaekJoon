import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        int main = 1;
        for(int i=0;i<order.length;i++){
            int currentBox = order[i];
            
            if(main==currentBox){
                answer++;
                main++;
                continue;
            }
            
            if(main > currentBox) {
                if(sub.isEmpty() || sub.pop() != currentBox) break;
                answer++;
                continue;
            }
            
            while(main!=currentBox){
                sub.push(main++);
            }
            
            answer++;
            main++;
        }
        return answer;
    }
}