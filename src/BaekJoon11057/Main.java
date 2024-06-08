package BaekJoon11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //길이, 시작 번호 일 때 가능 갯수
        int[][] list = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            list[1][i] = 10 - i;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = j; k < 10; k++) {
                    sum += list[i - 1][k];
                }
                list[i][j] = sum % 10007;
            }
        }

        System.out.println(list[N][0]);
    }
}
