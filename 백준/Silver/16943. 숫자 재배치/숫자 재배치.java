import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer  = -1;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] split = st.nextToken().split("");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        isVisited = new boolean[arr.length];
        String Bs = st.nextToken();
        int B = Integer.parseInt(Bs);

        if (split.length > Bs.length()) {
            System.out.println(-1);
            return;
        }

        findAnswer(arr, B,"");

        System.out.println(answer);
    }

    private static void findAnswer(int[] arr, int B, String num) {
        if (num.length() == arr.length) {
            int C = Integer.parseInt(num);
            if (B > C) {
                answer = Math.max(answer, C);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isVisited[i]) {
                if (num.isEmpty() && arr[i] == 0) {
                    continue;
                }
                isVisited[i] = true;
                findAnswer(arr, B, num + arr[i]);
                isVisited[i] = false;
            }
        }
    }
}