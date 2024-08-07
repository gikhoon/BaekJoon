import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String bomb = br.readLine();
        Stack<Character> st = new Stack<>();
        char lastBomb = bomb.charAt(bomb.length() - 1);
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            st.push(c);
            if (c == lastBomb && st.size() >= bomb.length()) {
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (st.get(st.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int l = 0; l < bomb.length(); l++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : st) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}
