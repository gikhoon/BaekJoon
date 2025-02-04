import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> list = new ArrayList<>();
    public static long[] stack = new long[1001];
    public static int head = 0;
    public static int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            list.clear();

            String line = br.readLine();
            if (line.equals("QUIT")) {
                break;
            }

            while (!line.equals("END")) {
                String[] splitLine = line.split(" ");
                if (splitLine.length == 1) {
                    list.add(splitLine[0]);
                } else {
                    list.add(splitLine[0]);
                    list.add(splitLine[1]);
                }

                line = br.readLine();
            }

            int test = Integer.parseInt(br.readLine());
            for (int t = 0; t < test; t++) {
                int num = Integer.parseInt(br.readLine());

                if (run(num)) {
                    sb.append(stack[0]).append("\n");
                } else {
                    sb.append("ERROR\n");
                }
            }

            sb.append("\n");
            br.readLine();
        }
        System.out.println(sb);
    }

    private static boolean run(int num) {
        int listSize = list.size();

        head = 0;
        stack[head++] = num;

        for (int i = 0; i < listSize; i++) {
            String command = list.get(i);

            switch (command) {
                case "NUM":
                    stack[head++] = Long.parseLong(list.get(i+1));
                    i++;
                    break;
                case "POP":
                    if (head < 1) {
                        return false;
                    }
                    head--;
                    break;
                case "INV":
                    if (head < 1) {
                        return false;
                    }
                    stack[head - 1] *= -1;
                    break;
                case "DUP":
                    if (head < 1) {
                        return false;
                    }
                    stack[head] = stack[head - 1];
                    head++;
                    break;
                case "SWP":
                    if (head < 2) {
                        return false;
                    }
                    long tmp = stack[head - 1];
                    stack[head - 1] = stack[head - 2];
                    stack[head - 2] = tmp;
                    break;
                case "ADD":
                    if (head < 2) {
                        return false;
                    }
                    if (Math.abs(stack[head - 1] + stack[head - 2]) > MAX) {
                        return false;
                    }

                    stack[head - 2] += stack[head - 1];
                    head--;
                    break;
                case "SUB":
                    if (head < 2) {
                        return false;
                    }
                    if (Math.abs(stack[head - 2] - stack[head - 1]) > MAX) {
                        return false;
                    }
                    stack[head - 2] -= stack[head - 1];
                    head--;
                    break;
                case "MUL":
                    if (head < 2) {
                        return false;
                    }
                    if (Math.abs(stack[head - 1] * stack[head - 2]) > MAX) {
                        return false;
                    }
                    stack[head - 2] *= stack[head - 1];
                    head--;
                    break;
                case "DIV":
                    if (head < 2) {
                        return false;
                    }
                    if (stack[head - 1] == 0) {
                        return false;
                    }
                    long a = stack[head - 2];
                    long b = stack[head - 1];
                    long res = Math.abs(a) / Math.abs(b);
                    if ((a < 0) ^ (b < 0)) res = -res;
                    stack[head - 2] = res;
                    head--;
                    break;
                default:
                    if (head < 2) {
                        return false;
                    }
                    if (stack[head - 1] == 0) {
                        return false;
                    }
                    a = stack[head - 2];
                    b = stack[head - 1];
                    res = Math.abs(a) % Math.abs(b);
                    if (a < 0) res = -res;
                    stack[head - 2] = res;
                    head--;
                    break;
            }
        }
        return head == 1;
    }
}
