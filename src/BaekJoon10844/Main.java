package BaekJoon10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] list = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            list[1][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            list[i][0] = list[i - 1][1];
            list[i][9] = list[i - 1][8];
            for (int j = 1; j < 9; j++) {
                list[i][j] = (list[i - 1][j - 1] + list[i - 1][j + 1]) % 1000000000;
            }
        }

        int answer = 0;
        for (int i = 1; i < 10; i++) {
            answer = (answer + list[N][i]) % 1000000000;
        }

        System.out.println(answer);

    }
}
