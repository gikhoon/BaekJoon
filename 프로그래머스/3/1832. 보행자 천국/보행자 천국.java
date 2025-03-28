class Solution {
    int MOD = 20170805;
    static int N, M; // 행, 열 
    static int [] arx = {0, -1}; // 왼쪽 아래 
    static int [] ary = {-1, 0};
    public int solution(int m, int n, int[][] cityMap) {
        N = m;
        M = n;
        // 0: 왼쪽에서 온 경우의 수 // 1: 위에서 온 경우의 수 
        int [][][] dp = new int [N][M][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        cityMap[0][0] = 2;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(cityMap[i][j] == 1) continue;
                for(int k = 0; k < 2; k++){
                    int nx = i + arx[k];
                    int ny = j + ary[k];
                    if(!validation(nx, ny) || cityMap[nx][ny] == 1) continue;
                    if(cityMap[nx][ny] == 2){ // 2
                        dp[i][j][k] += dp[nx][ny][k];
                    }
                    else{
                        dp[i][j][k] += dp[nx][ny][0] + dp[nx][ny][1];
                    }
                    dp[i][j][k] %= MOD;
                }
            }
        }
        return (dp[N-1][M-1][0] + dp[N-1][M-1][1]) % MOD;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < N && ny < M) return true;
        return false;
    }
}