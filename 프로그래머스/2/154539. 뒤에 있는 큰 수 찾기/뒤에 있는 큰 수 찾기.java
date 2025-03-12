import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        int[] index = new int[len];
        Arrays.fill(answer, -1);
        for(int i=len-2;i>=0;i--) {
            int num = numbers[i];
            if(num < numbers[i+1]) {
                answer[i] = numbers[i+1];
                index[i] = i+1;
                continue;
            }
            
            int idx = i+1;
            while(answer[idx] != -1) {
                if(answer[idx] > num) {
                    answer[i] = answer[idx];
                    index[i] = index[idx];
                    break;
                }
                idx = index[idx];
            }
        }
        return answer;
    }
    
    //먼저 바로 뒤에 num을 찾기
    //더 크면 그냥 그값 넣고 끝
    //작으면 answer를 본다
    //-1이면 나도 -1
    //값이 크면 나도 answer
    //값이 작으면 인덱스를 찾는다
    //타고 들어가 또다시 함(다음 큰 수)
}