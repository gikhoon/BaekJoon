import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0;i<balls.length;i++){
            int[] ball = balls[i];
            int min = Integer.MAX_VALUE;
            
            if(startX == ball[0]){
                if(startY > ball[1]){
                    min = Math.min(min, getDistance(2 * n - startY - ball[1], startX - ball[0]));
                } else{
                    min = Math.min(min, getDistance(startY + ball[1], startX - ball[0]));
                }
            } else{
                min = Math.min(min, getDistance(2 * n - startY - ball[1], startX - ball[0]));
                min = Math.min(min, getDistance(startY + ball[1], startX - ball[0]));
            }
            
            
            if(startY == ball[1]){
                if(startX > ball[0]){
                    min = Math.min(min, getDistance(2 * m-startX - ball[0], startY - ball[1]));
                } else{
                    min = Math.min(min, getDistance(startX + ball[0], startY - ball[1]));
                }
            } else{
                min = Math.min(min, getDistance(2 * m-startX - ball[0], startY - ball[1]));
                min = Math.min(min, getDistance(startX + ball[0], startY - ball[1]));
            }
            
            answer[i] = min;
        }
        return answer;
    }
    
    private int getDistance(int a, int b){
        return (int) Math.pow(a,2) + (int) Math.pow(b,2);
    }
}