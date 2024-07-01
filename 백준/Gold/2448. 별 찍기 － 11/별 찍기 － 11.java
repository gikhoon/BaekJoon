
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] starList;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int k = 0;
        int sum = 3;
        if (N == 3) {
            k = 0;
        } else {
            for (int i = 1; i <= 10; i++) {
                sum *= 2;
                if (sum == N) {
                    k = i;
                    break;
                }
            }
        }

        int column = (int) ((5 * N / 3) + Math.pow(2, k) - 1);
        starList = new boolean[N][column];
        StringBuilder sb = new StringBuilder();
        star(N, 0, column / 2);
        for (boolean[] arr : starList) {
            for (boolean a : arr) {
                if (a) {
                    sb.append("*");
                } else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void star(int n, int row, int column) {
        if (n == 3) {
            starList[row][column] = true;
            starList[row + 1][column - 1] = true;
            starList[row + 1][column + 1] = true;
            for (int i = 0; i < 5; i++) {
                starList[row + 2][column - 2 + i] = true;
            }
        } else {
            star(n / 2, row, column);
            star(n / 2, row + n / 2, column - n / 2);
            star(n / 2, row + n / 2, column + n / 2);
        }
    }
}
