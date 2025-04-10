import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int startR = (int)(left / n); int startC = (int)(left % n);
        int endR = (int)(right / n); int endC = (int)(right % n);
        int index = 0;
        if(startR == endR) {
            for(int i=startC;i<=endC;i++) {
                answer[index++] = getData(startR, i);
            }
        } else {
            for(int i=startC;i<n;i++) answer[index++] = getData(startR, i);
            for(int i=startR+1;i<endR;i++) {
                for(int j=0;j<n;j++) answer[index++] = getData(i,j);
            }
            
            for(int i=0;i<=endC;i++) answer[index++] = getData(endR, i);
        }
        return answer;
    }
    
    private int getData(int r, int c) {
        return Math.max(r, c) + 1;
    }
    
    /**
    (0,0) % 4 = 1
    (1,1) % 4 = 2 나눈 것의 (max+1)
    (2,0) (2,1) (2,2) (1,2) => 3
    
    left의 번지수를 구한다 => 7: 1,3 ~ 14(3,2)
    하나씩 계산 4,3,3,3,4,4,4
    **/
    
}