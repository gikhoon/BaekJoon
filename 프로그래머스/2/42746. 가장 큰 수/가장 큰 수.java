import java.util.*;
import java.lang.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberToString = new String[numbers.length];
        for (int i=0;i<numbers.length;i++){
            numberToString[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numberToString, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
            }
        });
                
        
        for(String s : numberToString){
            if(answer.equals("0") && s.equals("0")) continue;
            answer += s;
        }
        
        return answer;
    }
}