import java.util.*;

class Index {
    int r;
    int c;
    
    public Index(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private Character[][] map;
    private int[] dr = {0,0,1,-1};
    private int[] dc = {1,-1,0,0};
    public int solution(String[] storage, String[] requests) {
        map = new Character[storage.length + 2][storage[0].length() + 2];
        for(int i=1;i<=storage.length;i++) {
            for(int j=1;j<=storage[0].length();j++) {
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        int answer = storage.length * storage[0].length();
        for(String request : requests) {
            List<Index> deleteIndex = new ArrayList<>();
            boolean isCrain = false;
            Character str = request.charAt(0);
            if(request.length() == 2) {
                isCrain = true;
            }
            for(int i=1;i<=storage.length;i++) {
                for(int j=1;j<=storage[0].length();j++) {
                    if(map[i][j] == str) {
                        if(isCrain || isOut(i,j)) {
                            deleteIndex.add(new Index(i,j));
                        }
                    }
                }
            }
            
            System.out.println(request+" "+deleteIndex.size());
            
            for(Index idx : deleteIndex) {
                map[idx.r][idx.c] = null;
                answer--;
            }
        }
        
        return answer;
    }
    
    private boolean isOut(int r, int c) {
        boolean flag = false;
        boolean[][] visit = new boolean[map.length][map[0].length];
        Queue<Index> q = new LinkedList<>();
        q.add(new Index(r,c));
        while(!q.isEmpty()) {
            Index cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            for(int d=0;d<4;d++) {
                int newR = curR+dr[d];
                int newC = curC+dc[d];
                if(!visit[newR][newC] && map[newR][newC]==null) {
                    if((newR == 0 || newR == map.length-1) || (newC == 0 || newC == map[0].length -1)) {
                        flag = true;
                        break;
                    }
                    visit[newR][newC] = true;
                    q.add(new Index(newR, newC));
                }
            }
            if(flag) break;
        }
        
        return flag;
    }
}