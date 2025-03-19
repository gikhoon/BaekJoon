import java.util.*;

class Solution {
    private int[] dr = {1,-1,0,0};
    private int[] dc = {0,0,1,-1};
    private boolean[][] visit;
    int[][] map;
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++) {
            String[] s = maps[i].split("");
            for(int j=0;j<s.length;j++) {
                if(s[j].equals("X")) continue;
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        visit = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[i].length;j++) {
                if(!visit[i][j]) {
                    if(map[i][j] == 0) {
                        visit[i][j] = true;
                    } else {
                        answer.add(findSum(i,j));
                    }
                }
            }
        }
        
        if(answer.isEmpty()) {
            int[] a = {-1};
            return a;
        }
        
        Collections.sort(answer);
        return answer
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int findSum(int i, int j) {
        int sum = 0;
        visit[i][j] = true;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.add(i);
        cq.add(j);
        
        while(!rq.isEmpty()) {
            int r = rq.poll();
            int c = cq.poll();
            sum += map[r][c];
            for(int d=0;d<4;d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= map.length || nc < 0 || nc >=map[0].length) continue;
                if(!visit[nr][nc]) {
                    visit[nr][nc] = true;
                    if(map[nr][nc] == 0) continue;
                    rq.add(nr);
                    cq.add(nc);
                }
            }
        }
         return sum;
    }
    
   
}