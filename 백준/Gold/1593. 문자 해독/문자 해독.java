import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] WIndex = new int[52]; //0~25 => 대문자 26 ~ 51 => 소문자
        int[] windowIndex = new int[52];
        String W = br.readLine();
        String S = br.readLine();

        for (int index = 0; index < W.length(); index++) {
            WIndex[getIndex(W.charAt(index))]++;
        }

        for (int index = 0; index < g; index++) {
            windowIndex[getIndex(S.charAt(index))]++;
        }

        int total = 0;
        if (isSame(windowIndex, WIndex)) {
            total++;
        }

        for (int i = g; i < s; i++) {
            windowIndex[getIndex(S.charAt(i - g))]--;
            windowIndex[getIndex(S.charAt(i))]++;
            if (isSame(windowIndex, WIndex)) {
                total++;
            }
        }
        System.out.println(total);
    }

    private static int getIndex(char ch) {
        if ((int) ch > 'Z') {
            return 26 + (int) ch - 'a';
        }
        return (int) ch - 'A';
    }

    private static boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < 52; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
