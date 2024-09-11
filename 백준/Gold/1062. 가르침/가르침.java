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

        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int alpha, int len) {
        if(len == K - 5) {
            int count = 0;
            for(int i = 0; i < words.length; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(!isVisit[words[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = alpha; i < 26; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                backtracking(i, len + 1);
                isVisit[i] = false;
            }
        }
    }
}