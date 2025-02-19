import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for(String person : participant) {
            if(map.containsKey(person)){
                map.put(person, map.get(person) + 1);
            } else {
                map.put(person, 1);
                set.add(person);
            }
        }
        
        for(String person : completion) {
            int count = map.get(person);
            if(count == 1) {
                map.remove(person);
                set.remove(person);
            } else {
                map.put(person, count-1);
            }
        }
        
        return set.iterator().next();
    }
}