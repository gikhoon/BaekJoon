import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class PassWord {
    int num;
    String command;

    PassWord(int num, String command) {
        this.num = num;
        this.command = command;
    }
}

public class Main {
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(primeChangeCount(A, B)).append("\n");
        }
        System.out.println(sb);
    }

    private static String primeChangeCount(int A, int B) {
        if (A == B) {
            return "";
        }
        boolean[] isVisited = new boolean[10000];
        Queue<PassWord> queue = new LinkedList<>();
        queue.add(new PassWord(A, ""));
        isVisited[A] = true;
        while (!queue.isEmpty()) {
            PassWord passWord = queue.poll();

            int d = D(passWord.num);
            if (!isVisited[d]) {
                if (d == B) {
                    return passWord.command + "D";
                }
                isVisited[d] = true;
                queue.add(new PassWord(d, passWord.command + "D"));
            }
            int s = S(passWord.num);
            if (!isVisited[s]) {
                if (s == B) {
                    return passWord.command + "S";
                }
                isVisited[s] = true;
                queue.add(new PassWord(s, passWord.command + "S"));
            }
            int l = L(passWord.num);
            if (!isVisited[l]) {
                if (l == B) {
                    return passWord.command + "L";
                }
                isVisited[l] = true;
                queue.add(new PassWord(l, passWord.command + "L"));
            }
            int r = R(passWord.num);
            if (!isVisited[r]) {
                if (r == B) {
                    return passWord.command + "R";
                }
                isVisited[r] = true;
                queue.add(new PassWord(r, passWord.command + "R"));
            }
        }

        return "";
    }

    private static int R(int passWord) {
        return (passWord / 10) + 1000 * (passWord % 10);
    }

    private static int L(int passWord) {
        return 10 * (passWord % 1000) + passWord / 1000;
    }

    private static int S(int passWord) {
        return (passWord + 9999) % 10000;
    }

    private static int D(int passWord) {
        return (passWord * 2) % 10000;
    }
}
