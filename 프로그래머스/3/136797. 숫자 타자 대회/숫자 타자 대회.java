import java.util.*;

class Solution {
    int[][][] dp;
    private final int cost[][] = { { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
                                    { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
                                    { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
                                    { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
                                    { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
                                    { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
                                    { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
                                    { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
                                    { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
                                    { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 } };
    String number;
    public int solution(String numbers) {
        number = numbers;
        
        dp = new int[number.length()][10][10];
        
        for(int i=0;i<number.length();i++) {
            for(int j=0;j<10;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(0,4,6);
    }
    
    private int dfs(int idx, int left, int right) {
        if(idx == number.length()) {
            return 0;
        }
        
        if(dp[idx][left][right] != -1) {
            return dp[idx][left][right];
        }
        
        int index = number.charAt(idx) - '0';
        
        
        int min = Integer.MAX_VALUE;
        
        //right랑 같지 않으면 left 이동 가능
        if(right != index) {
            min = Math.min(min, dfs(idx+1, index, right) + cost[left][index]);
        }
        
        if(left != index) {
            min = Math.min(min, dfs(idx+1, left, index) + cost[right][index]);
        }
        
        dp[idx][left][right] = min;
        dp[idx][right][left] = min;
        
        return dp[idx][left][right];
    }
}