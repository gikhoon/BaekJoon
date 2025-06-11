import java.io.*;
import java.util.*;

public class Main {
    static int[] data = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        setData();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(data[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

    private static void setData() {
        data[1] = 3;
        for (int i = 2; i <= 1000; i++) {
            int count = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    count++;
                }
            }

            data[i] = data[i - 1] + count * 2;
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
