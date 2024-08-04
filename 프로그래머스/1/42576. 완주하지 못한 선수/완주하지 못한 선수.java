import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        
        for(int i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                int replace = map.get(participant[i])+1;
                map.replace(participant[i], replace);
            } else{
                map.put(participant[i], 1);
            }
        }
        
        for(int i=0;i<completion.length;i++){
            if(map.get(completion[i]).equals(1)){
                map.remove(completion[i]);
            } else{
                int replace = map.get(completion[i])-1;
                map.replace(completion[i], replace);
            }
        }
        
        String answer = map.keySet().iterator().next();
        return answer;
    }
}