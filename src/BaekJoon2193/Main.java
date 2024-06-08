package BaekJoon2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] list = new long[N + 2][2];

        //글자 수 + 0으로 끝나는 거 / 1로 끝나는거
        list[1][0] = 0;
        list[1][1] = 1;

        for (int i = 2; i < N + 1; i++) {
            list[i][0] = list[i - 1][1] + list[i - 1][0];
            list[i][1] = list[i - 1][0];
        }

        System.out.println(list[N][0] + list[N][1]);
    }
}
