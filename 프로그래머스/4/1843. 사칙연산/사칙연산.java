import java.util.*;

class Solution {
    private int[][] max_dp;
    private int[][] min_dp;
    public int solution(String arr[]) {
        int len = arr.length / 2 + 1;
        max_dp = new int[len][len];
        min_dp = new int[len][len];
        for(int i=0;i<max_dp.length;i++) {
            Arrays.fill(max_dp[i], Integer.MIN_VALUE);
            Arrays.fill(min_dp[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<arr.length;i=i+2) {
            max_dp[i/2][i/2] = Integer.parseInt(arr[i]);
            min_dp[i/2][i/2] = Integer.parseInt(arr[i]);
        }
        
        for(int cnt = 1;cnt<len;cnt++) {
            for(int i=0;i<len - cnt;i++) {
                int j = i + cnt;
                for(int k=i;k<j;k++) {
                    if(arr[k*2+1].equals("+")) {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                    }
                }
            }
        }
        
        return max_dp[0][len-1];
    }
    
    //max_dp[i][j], min_dp => i ~ j의 최대값, 최소값
    //1개는 그냥
    //2개 먼저 채우기
    // 새로 들어오는 부분이 + 면 max + max, min + min
    // - 면 max - min ,min - max 
}