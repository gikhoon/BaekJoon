import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> st = new Stack<>();

        String str = br.readLine();
        for(int i=0;i<str.length();i++){
            String data = String.valueOf(str.charAt(i));
            int dataInt = priority(data);
            if(dataInt==-1){
                sb.append(data);
            }else if(dataInt==3){
                while(!st.isEmpty() && !st.peek().equals("(")) sb.append(st.pop());
                st.pop();
            }
            else{
                if(st.isEmpty()||dataInt==4) st.add(data);
                else{
                    while(!st.isEmpty()){
                        if(priority(st.peek())>dataInt){
                            break;
                        }
                        sb.append(st.pop());
                    }
                    st.add(data);
                }
            }
        }
        while(!st.isEmpty()){
            String s = st.pop();
            sb.append(s);
        }
        System.out.println(sb);
    }
    //(/*+-)
    static int priority(String a){
        if(a.equals("+")||a.equals("-")) return 2;
        if(a.equals("*")||a.equals("/")) return 1;
        if(a.equals("(")) return 4;
        if(a.equals(")")) return 3;
        return -1;
    }
}
