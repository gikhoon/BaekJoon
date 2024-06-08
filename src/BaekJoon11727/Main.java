package BaekJoon11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        list = new int[n + 2];
        list[1] = 1;
        list[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            list[i] = (list[i - 1] + list[i - 2] * 2) % 10007;
        }

        System.out.println(list[n]);
    }
}
