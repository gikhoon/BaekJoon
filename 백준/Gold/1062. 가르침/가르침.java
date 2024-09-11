import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit = new boolean[26];
    static String[] words;
    static int K;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        isVisit['a' - 'a'] = true;
        isVisit['c' - 'a'] = true;
        isVisit['n' - 'a'] = true;
        isVisit['t' - 'a'] = true;
        isVisit['i' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        backTracking(0, 5);
        System.out.println(max);
    }

    static void backTracking(int start, int length) {
        if (length == K) {
            countWord();
            return;
        }

        for (int i = start; i < 26 + length - K + 1; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                backTracking(i + 1, length + 1);
                isVisit[i] = false;
            }
        }
    }

    private static void countWord() {
        int count = 0;
        for (String word : words) {
            boolean read = true;
            for (int c = 0; c < word.length(); c++) {
                if (!isVisit[word.charAt(c) - 'a']) {
                    read = false;
                    break;
                }
            }
            if (read) {
                count++;
            }
        }

        max = Math.max(max, count);
    }
}