import java.util.*;
class Solution {
    static final int MAX = 1000000;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        t1 += 10; t2 += 10; int temp = temperature + 10;
        
        int[][] dp = new int [onboard.length][51];
        for(int i = 0; i < onboard.length; i++){
            Arrays.fill(dp[i], MAX);
        }
        
        dp[0][temp] = 0;
        
        for(int i = 0; i < onboard.length - 1; i++){
            for(int j = 0; j <= 50; j++){
                if(onboard[i] == 1 && (j < t1 || t2 < j)) continue;
                
                // 에어컨 ON + 현재 온도 유지 - use b
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + b);
                // 에어컨 ON + 현재 온도에서 down - use a
                if(j >= 1) dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                // 에어컨 ON + 현재 온도에서 up - use a
                if(j < 50) dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                
                // 에어컨 OFF
                if(temp == j){     // 온도 유지 
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                }
                else if(temp > j && j < 50){ // 온도 up
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                }
                else if(temp < j && j >= 1){ // 온도 down 
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                }
            }
        }
        int min = MAX;
        int last = onboard.length - 1;
        for(int i = 0; i <= 50; i++){
            if(onboard[last] == 1 && (i < t1 || t2 < i)) continue; // 마지막에 승객이 탑승했다면 적정 온도만 가능 
            min = Math.min(min, dp[last][i]);
        }
        return min;
    }
}