import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> left = new HashSet<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        int leftC = 0;
        int rightC = 0;
        for(int top: topping) {
            if(!right.containsKey(top)) {
                right.put(top, 1);
                rightC++;
            } else {
                right.put(top, right.get(top)+1);
            }
        }
        
        int answer = 0;
        for(int i=0;i<topping.length-1;i++) {
            int cur = topping[i];
            int cnt = right.get(cur);
            if(cnt == 1) {
                right.remove(cur);
                rightC--;
            } else {
                right.put(cur, cnt-1);
            }
            if(!left.contains(cur)) {
                left.add(cur);
                leftC++;
            }
            if(rightC < leftC) break;
            if(rightC == leftC) answer++;
        }

        return answer;
    }
    
    /**넣기 백만
    
    **/
}