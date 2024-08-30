import java.io.IOException;
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split("");

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            switch(command) {
                case "(":
                    stack.push(-1);
                    break;
                case ")":
                    int tmp = 0;
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                    while (!stack.isEmpty()) {
                        Integer pop = stack.pop();
                        if (pop == -2) {
                            System.out.println(0);
                            return;
                        }
                        if (pop == -1) {
                            if (stack.isEmpty()) {
                                if (tmp == 0) answer += 2;
                                else answer += (tmp * 2);
                            } else{
                                if (tmp == 0) {
                                    stack.push(2);
                                } else {
                                    stack.push(tmp * 2);
                                }
                            }
                            break;
                        } else {
                            tmp += pop;
                        }
                    }
                    break;
                case "[":
                    stack.push(-2);
                    break;
                default:
                    int tmp2 = 0;
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                    while (!stack.isEmpty()) {
                        Integer pop = stack.pop();
                        if (pop == -1) {
                            System.out.println(0);
                            return;
                        }
                        if (pop == -2) {
                            if (stack.isEmpty()) {
                                if (tmp2 == 0) answer += 3;
                                else answer += (tmp2 * 3);
                            } else{
                                if (tmp2 == 0) {
                                    stack.push(3);
                                } else {
                                    stack.push(tmp2 * 3);
                                }
                            }
                            break;
                        } else {
                            tmp2 += pop;
                        }
                    }
                    break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(answer);
        } else{
            System.out.println(0);
        }

    }
}