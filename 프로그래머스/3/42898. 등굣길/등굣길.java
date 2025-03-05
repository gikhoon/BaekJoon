class Solution {
    static int DIV = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] route = new int[m + 1][n + 1];
        boolean[][] isPuddle = new boolean[m + 1][n + 1];
        
        for(int[] puddle : puddles) {
            isPuddle[puddle[0]][puddle[1]] = true;
        }
        
        route[1][1] = 1;
        
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(isPuddle[i][j]) continue;
                if(i==1 && j == 1) continue;
                route[i][j] = (route[i-1][j] + route[i][j-1]) % DIV;
            }
        }
        return route[m][n];
    }
}