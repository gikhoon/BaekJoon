import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0;i<want.length;i++) {
            map.put(want[i], number[i]);
        }
        int lastIndex = 0;
        for(;lastIndex<10;lastIndex++) {
            putWant(discount[lastIndex]);
        }
        if(isFull()) answer++;
        
        for(;lastIndex < discount.length;lastIndex++) {
            popWant(discount[lastIndex-10]);
            putWant(discount[lastIndex]);
            if(isFull()) answer++;
        }
        return answer;
    }
    
    private void putWant(String want) {
        if(!map.containsKey(want)) return;
        
        map.put(want, map.get(want) -1);
    }
    
    private void popWant(String want) {
        if(!map.containsKey(want)) return;
        
        map.put(want, map.get(want) +1);
    }
    
    private boolean isFull() {
        Collection<Integer> values = map.values();
        for(int value : values) {
            if(value > 0) {
                return false;
            }
        }
        return true;
    }
    
    //처음에 HashMap으로 갯수를 넣는다.
    //number가 10이니까 그냥 다 저장해 안 없애고 -1
    //계산하고 다 0보다 작은지 확인 맞으면 그 때 ㄱㄱ
    //
}