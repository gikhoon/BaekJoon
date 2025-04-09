import java.util.*;

class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<places.length;i++) {
            answer[i] = isGood(places[i]);
        }
        return answer;
    }
    
    private int isGood(String[] place) {
        char[][] map = new char[5][5];
        for(int i=0;i<5;i++) {
            String s = place[i];
            for(int j=0;j<5;j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(map[i][j] == 'P' && !canSit(map,i,j)) {
                    return 0;
                }
            }
        }
        
        return 1;
    }
    
    private boolean canSit(char[][] map,int r, int c) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        for(int d=0;d<4;d++) {
            int newR = r+dr[d];
            int newC = c+dc[d];
            if(newR < 0 || newC < 0 || newR == 5 || newC == 5) continue;
            if(map[newR][newC] == 'X') continue;
            if(map[newR][newC] == 'P') return false;
            rq.add(newR);
            cq.add(newC);
        }
        
        while(!rq.isEmpty()) {
            int curR = rq.poll();
            int curC = cq.poll();
            for(int d=0;d<4;d++) {
                int newR = curR+dr[d];
                int newC = curC+dc[d];
                if(newR < 0 || newC < 0 || newR == 5 || newC == 5) continue;
                if(newR == r && newC == c) continue;
                if(map[newR][newC] == 'P') return false;
            }
        }
        
        return true;
    }
}