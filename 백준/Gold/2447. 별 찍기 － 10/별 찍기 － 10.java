
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder[] sb;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            sb[i] = new StringBuilder();
        }
        star(N, 0);

        for (StringBuilder s : sb) {
            System.out.println(s);
        }
    }

    private static void star(int n, int row) {
        if (n == 3) {
            sb[row].append("***");
            sb[row + 1].append("* *");
            sb[row + 2].append("***");
        } else {
            star(n / 3, row);
            star(n / 3, row);
            star(n / 3, row);
            star(n / 3, row + n / 3);
            empty(n / 3, row + n / 3);
            star(n / 3, row + n / 3);
            star(n / 3, row + 2 * (n / 3));
            star(n / 3, row + 2 * (n / 3));
            star(n / 3, row + 2 * (n / 3));
        }
    }

    private static void empty(int i, int row) {
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                sb[row + j].append(" ");
            }
        }
    }
}
