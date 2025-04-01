import java.util.*;

class Solution {
    static final int INF = 100_000_000;
    int maxAlp;
    int maxCop;
    public int solution(int alp, int cop, int[][] problems) {
        maxAlp = alp;
        maxCop = cop;
        
        for(int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        int[][] dp = new int[maxAlp+1][maxCop+1];
        
        for(int[] d : dp) {
            Arrays.fill(d, INF);
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp;i<=maxAlp;i++) {
            for(int j=cop;j<=maxCop;j++) {
                //알고력 올리기
                if(i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                //코딩력 올리기
                if(j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                //문제를 통한 풀이
                for(int[] problem : problems) {
                    if(problem[0] <= i && problem[1] <= j) {
                        int updateAlp = Math.min(maxAlp, i + problem[2]);
                        int updateCop = Math.min(maxCop,j + problem[3]);
                        dp[updateAlp][updateCop] = Math.min(dp[updateAlp][updateCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}