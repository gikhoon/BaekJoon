
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] list;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        change(0);

        System.out.println(answer);

    }

    static void change(int index) {
        if (index == N - 1) {
            answer = Math.max(answer, getAnswer());
            return;
        }
        for (int i = index; i < N; i++) {
            swap(index, i);
            change(index+1);
            swap(index,i);
        }
    }

    private static void swap(int index, int i) {
        int tmp = list[index];
        list[index] = list[i];
        list[i] = tmp;
    }

    static int getAnswer() {
        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            answer += Math.abs(list[i] - list[i + 1]);
        }
        return answer;
    }
}
