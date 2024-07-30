import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
    
        Stack<Character> st = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (c == '('){
                st.push(c);
            }
            else {
                if(st.isEmpty()){answer = false; break;}
                else st.pop();
            }
        }
        
        if (!st.isEmpty()) answer = false; 

        return answer;
    }
}