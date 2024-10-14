import java.util.*;
import java.lang.*;

class Solution {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static boolean[][] isVisit;
    static int[] total;
    static int[][] staticLand;
    public int solution(int[][] land) {
        isVisit = new boolean[land.length][land[0].length];
        total = new int[land[0].length];
        staticLand = land;
        
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(!isVisit[i][j] && land[i][j] == 1){
                    BFS(i,j);
                }
            }
        }
        
        int answer = 0;
        for(int i=0;i<total.length;i++){
            answer = Math.max(total[i], answer);
        }
        
        return answer;
    }
    
    static void BFS(int r,int c){
        isVisit[r][c] = true;
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        Set<Integer> column = new HashSet<>();
        int sum = 0;
        column.add(c);
        qr.add(r);
        qc.add(c);
        
        while(!qr.isEmpty()){
            int currentR = qr.poll();
            int currentC = qc.poll();
            sum++;
            
            for(int d=0;d<4;d++){
                int newR = currentR + dr[d];
                int newC = currentC + dc[d];
                if(newR < 0 || newR >= isVisit.length || newC < 0 || newC >= isVisit[0].length) continue;
                
                if(!isVisit[newR][newC] && staticLand[newR][newC] == 1){
                    isVisit[newR][newC] = true;
                    qr.add(newR);
                    qc.add(newC);
                    
                    column.add(newC);
                }
            }
        }
        
        Iterator<Integer> it = column.iterator();
        while(it.hasNext())
            total[it.next()] += sum;
    }
}