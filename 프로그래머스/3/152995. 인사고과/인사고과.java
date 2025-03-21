import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int a = scores[0][0];
        int b = scores[0][1];
        
        Arrays.sort(scores, (o1,o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        int last = scores[0][1];
        for(int i=1;i<scores.length;i++) {
            if(scores[i][1] < last) {
                if(scores[i][0] == a && scores[i][1] == b) return -1;
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                last = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1,o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        int answer = 1;
        for(int i=0;i<scores.length;i++) {
            if(scores[i][0] + scores[i][1] > a + b) answer++;
            else break;
        }
        
        return answer;
    }
    
    //a, b 순으로 정렬 -> 이전 값과 a가 다르다 b도 다르면 삭제
    //(3,1), (3,2), (3,3), (2,1), (2,2), 
    //b, a 순으로 정렬 -> b에 따라
}