class Solution {
    static boolean[][] visited;
    static int zero = 0;
    static int one = 0;
    static int N;
    static int[][] map;
    public int[] solution(int[][] arr) {
        N = arr.length;
        visited = new boolean[arr.length][arr.length];
        map = arr.clone();
        int size = N;
        findAnswer(0,0, N);
        int[] answer = {zero, one};
        return answer;
    }
    
    private void findAnswer(int r, int c, int N) {
        boolean isSame = true;
        if(N==1) {
            if(map[r][c] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }
        int data = map[r][c];
        for(int i=r;i<r+N;i++) {
            if(!isSame) break;
            for(int j=c;j<c+N;j++) {
                if(map[i][j] != data) {
                    isSame=false;
                    break;
                }
            }
        }
        if(isSame) {
            if(data == 1) one++;
            else zero++;
            return;
        }
        
        for(int i=r;i<r+N;i+=N/2) {
            for(int j=c;j<c+N;j+=N/2) {
                findAnswer(i,j,N/2);
            }
        }
    }
}