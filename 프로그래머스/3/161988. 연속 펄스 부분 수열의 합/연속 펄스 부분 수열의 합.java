import java.util.*;

class Solution {
    static long[][] dp;
    public long solution(int[] sequence) {
        dp = new long[sequence.length][2]; //0은 -1로 시작 1은 1로 시작
        dp[0][0] = sequence[0] * -1;
        dp[0][1] = sequence[0];
        
        long answer = 0;
        answer = Math.max(answer, dp[0][0]);
        answer = Math.max(answer, dp[0][1]);
        for(int i=1;i<sequence.length;i++) {
            dp[i][0] = sequence[i] * -1 + Math.max(0, dp[i-1][1]);
            dp[i][1] = sequence[i] + Math.max(0, dp[i-1][0]);
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }
        
        return answer;
    }
    
    /**
    -4 4
    2 2
    3 
    **/
}