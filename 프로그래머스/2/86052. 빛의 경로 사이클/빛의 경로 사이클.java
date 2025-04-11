import java.util.*;

class Solution {
    char[][] map;
    boolean[][][] isVisit;
    int sizeR, sizeC;
    int[] dr = {0,-1,0,1};
    int[] dc = {1,0,-1,0};
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        sizeR = grid.length;
        sizeC = grid[0].length();
        isVisit = new boolean[sizeR][sizeC][4];
        map = new char[sizeR][sizeC];
        
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length();j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }
        
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[i].length;j++) {
                for(int d=0;d<4;d++) {
                    if(!isVisit[i][j][d]) {
                        answer.add(getAnswer(i,j,d));
                    }
                }
            }
        }
        
        int[] ans = new int[answer.size()];
        for(int i=0;i<answer.size();i++) {
            ans[i] = answer.get(i);
        }
        Arrays.sort(ans);
        
        return ans;
    }
    
    private int getAnswer(int i, int j, int dir) {
        int answer = 0;
        int r = i; int c = j; int d = dir;
        while(true) {
            isVisit[r][c][d] = true;
            if(map[r][c] == 'S') {
                r = getR(r+dr[d]);
                c = getC(c+dc[d]);
            } else if(map[r][c] == 'L') {
                d = (d+1) % 4;
                r = getR(r+dr[d]);
                c = getC(c+dc[d]);
            } else {
                if(d==0) d = 3;
                else d -= 1;
                r = getR(r+dr[d]);
                c = getC(c+dc[d]);
            }
            
            answer++;
            if(r==i && c==j && d==dir) break;
        }
        return answer;
    }
    
    private int getR(int d) {
        if(d==-1) return sizeR-1;
        return (d % sizeR);
    }
    
    private int getC(int d) {
        if(d==-1) return sizeC-1;
        return (d % sizeC);
    }
    
    //S => d=0 
    //0 => 왼->오 1 => 아 -> 위 2 => 오->왼 3=>위->아래
}