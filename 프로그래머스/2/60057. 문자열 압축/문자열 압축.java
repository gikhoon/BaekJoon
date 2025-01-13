import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=s.length() / 2 ;i>0;i--){
            answer = Math.min(answer,findLength(s, i));
        }
        return answer;
    }
    
    private int findLength(String s, int index) {
        StringBuilder sb = new StringBuilder();
        String base = s.substring(0,index);
        int count = 1;
        for(int i=index;i<=s.length();i+=index) {
            int lastIndex = Math.min(s.length(),i+index);
            String part = s.substring(i, lastIndex);
            if(base.equals(part)) {
                count++;
            } else {
                if(count>=2) {
                    sb.append(count);
                }
                sb.append(base);
                count = 1;
                base = part;
            }
        }
        sb.append(base);
        return sb.toString().length();
    }
}