
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class PassWord {
    int num;
    int count;

    PassWord(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Main {
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        calculatePrime();

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
            return String.valueOf(0);
        }
        boolean[] isVisited = new boolean[10000];
        Queue<PassWord> queue = new LinkedList<>();
        queue.add(new PassWord(A, 0));
        isVisited[A] = true;
        while (!queue.isEmpty()) {
            PassWord passWord = queue.poll();

            for (int i = 1; i < 10; i++) {
                int newPassword = passWord.num % 1000 + i * 1000;
                if (isPrime[newPassword] && !isVisited[newPassword]) {
                    if (newPassword == B) {
                        return String.valueOf(passWord.count + 1);
                    }
                    isVisited[newPassword] = true;
                    queue.add(new PassWord(newPassword, passWord.count + 1));
                }
            }

            for (int mod = 1; mod <= 100; mod *= 10) {
                for (int i = 0; i < 10; i++) {
                    int newPassword = (passWord.num / (mod * 10)) * (mod * 10) + passWord.num % mod + i * mod;
                    if (isPrime[newPassword] && !isVisited[newPassword]) {
                        if (newPassword == B) {
                            return String.valueOf(passWord.count + 1);
                        }
                        isVisited[newPassword] = true;
                        queue.add(new PassWord(newPassword, passWord.count + 1));
                    }
                }
            }
        }

        return "Impassible";
    }

    static void calculatePrime() {
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(9999); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
