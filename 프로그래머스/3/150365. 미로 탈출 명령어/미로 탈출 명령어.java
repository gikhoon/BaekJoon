import java.util.*;

class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] ds = {"d", "l", "r", "u"};
    static String answer = "impossible";
    static int N, M, R, C;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m; R = r; C =c;
        findAnswer(x, y, k, "");
        return answer;
    }
    
    private boolean findAnswer(int r, int c, int left, String cur) {
        //left가 0이면 같은지 확인 후 return;
        if(left == 0) {
            if(r == R && c == C) {
                answer = cur;
                return true;
            }
            return false;
        }
        
        //이동해서 갈 수 있는지 확인
        if(Math.abs(R-r) + Math.abs(C-c) > left) {
            return false;
        }
        
        if((Math.abs(R-r) + Math.abs(C-c)) % 2 != left % 2) {
            return false;
        }
        
        boolean success = false;
        for(int d=0;d<4;d++) {
            int nR = r + dr[d];
            int nC= c + dc[d];
            if(nR <= 0 || nR > N || nC <= 0 || nC > M) continue;
            if(findAnswer(nR, nC,left-1, cur + ds[d])) {
                success = true;
                break;
            }
        }
        
        return success;
        
        //d로 이동
    }
}