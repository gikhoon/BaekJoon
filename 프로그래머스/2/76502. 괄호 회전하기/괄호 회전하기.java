import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++) {
            if(isGood(s)) {
                answer++;
            }
            s = s.substring(1) + s.substring(0,1);
        }
        return answer;
    }
    
    private boolean isGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c2 = s.charAt(i);
            if(isFirst(c2)) {
                st.push(c2);
                continue;
            }
            if(st.isEmpty()) return false;
            
            char c1 = st.pop();
            if(!isPair(c1, c2)) return false;
        }
        return st.isEmpty();
    }
    
    private boolean isFirst(char c) {
        return c == '[' || c=='(' || c =='{';
    }
    
    private boolean isPair(char c1, char c2) {
        switch(c1) {
            case '[':
                return c2 == ']';
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
        }
        return false;
    }
}