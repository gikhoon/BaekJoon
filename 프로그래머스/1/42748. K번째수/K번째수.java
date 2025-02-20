import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0;i<commands.length;i++) {
            answer[i] = getAnswer(array, commands[i]);
        }
        return answer;
    }
    
    private int getAnswer(int[] array, int[] command) {
        int[] data = new int[command[1] - command[0]+1];
        int j=0;
        for(int i=command[0]-1; i<command[1] ; i++) {
            data[j++] = array[i];
        }
        Arrays.sort(data);
        return data[command[2] -1];
    }
}