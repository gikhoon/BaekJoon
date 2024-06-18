import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /**
     * ( 경우
     * 스택에 넣는다
     * ) 경우
     * 앞이 (이면 레이저 스택 수 많큼 더하고 stack에서 하나를 pop한다
     * (이 아니면 stack에서 pop하고 +1한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String commandLine = br.readLine();
        Stack<Character> stack = new Stack<>();
        stack.add(commandLine.charAt(0));
        int pipe = 0;
        for (int i = 1; i < commandLine.length(); i++) {
            char command = commandLine.charAt(i);
            if (command == ')') {
                stack.pop();
                if (commandLine.charAt(i - 1) == '(') {
                    pipe += stack.size();
                } else {
                    pipe += 1;
                }
            } else {
                stack.add(command);
            }
        }

        System.out.println(pipe);
    }
}
