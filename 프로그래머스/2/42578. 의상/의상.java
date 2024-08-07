import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap();
        for(String[] cloth: clothes){
            if(map.containsKey(cloth[1])){
                map.put(cloth[1], map.get(cloth[1])+1);
            } else{
                map.put(cloth[1], 2);
            }
        }
        int answer = 1;
        Iterator<Integer> iter = map.values().iterator();
        while(iter.hasNext()){
            answer *= iter.next();
        }
        
        return answer-1;
    }
}