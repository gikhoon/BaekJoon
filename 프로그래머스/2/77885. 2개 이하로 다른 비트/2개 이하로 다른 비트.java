import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<answer.length;i++) {
            answer[i] = solve(numbers[i]);
        }
        return answer;
    }
    
    private long solve(long n) {
        if(n%2 == 0) return n+1;
        String target = Long.toBinaryString(n);
        
        int idx = target.lastIndexOf("0");
        
        if(idx == -1) {
            String tmp = "10" + target.substring(1, target.length());
            return Long.parseLong(tmp, 2);
        }
        
        String tmp = target.substring(0, idx) + "10" + target.substring(idx + 2, target.length());
        return Long.parseLong(tmp, 2);
        
        //1의 마지막을 찾는다
        //3번째 이상이면 두개를 스위치
        //1 2면 그냥 +1
        //0011 -> 0100
        //0111 -> 1000 -> 1011
    }
}