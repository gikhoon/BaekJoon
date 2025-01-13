import java.util.*;

class Solution {
    public String solution(String p) {
        return convert(p);
    }
    
    private String convert(String s) {
        if(s.equals("")) return "";
        int lastIndex = findLastIndex(s);
        String u = s.substring(0,lastIndex);
        String v = s.substring(lastIndex, s.length());
        
        if(isPerfect(u)) {
            return u + convert(v);
        }

        String newS = "(" + convert(v) + ")";
        for(int i=1;i<u.length()-1;i++){
            char a = u.charAt(i);
            if(a == '(') newS = newS + ")";
            else newS = newS + "(";
        }
        return newS;
    }
    
    private boolean isPerfect(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                st.push(1);
            } else {
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        return true;
        
    }
    
    private int findLastIndex(String s) {
        int count = 0;
        int i;
        if (s.charAt(0) == '('){
            count++;
        }
        else { 
            count--;
        }
        for(i=1;i<s.length();i++){
            char a = s.charAt(i);
            if (a == '('){
                count++;
            }
            else { 
                count--;
            }
            if(count == 0) break;
        }
        
        if(i==s.length()) return s.length();
        return i + 1;
    }
}