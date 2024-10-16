import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        List<Integer> countList = new ArrayList<>();
        
        int index = 0;
        while(index < tangerine.length){
            int count = 1;
            int data = tangerine[index];
            index++;
            
            while(index < tangerine.length){
                if(tangerine[index] != data) break;
                count++;
                index++;
            }
            
            countList.add(count);
        }
        
        Collections.sort(countList, Comparator.reverseOrder());
        
        for(int count : countList){
            if(k <= 0) break;
            answer++;
            k-=count;
        }
        
        return answer;
    }
}