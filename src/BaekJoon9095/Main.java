package BaekJoon9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    static int[] nList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        nList = new int[count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            nList[i] = Integer.parseInt(st.nextToken());
        }

        int maxN = Arrays.stream(nList).max().getAsInt();

        list = new int[maxN + 2];
        list[1] = 1;
        list[2] = 2;
        list[3] = 4;

        for (int i = 4; i < maxN +1 ; i++) {
            list[i] = list[i-3] + list[i-2] + list[i-1];
        }

        for (int n : nList) {
            System.out.println(list[n]);
        }
    }
}
