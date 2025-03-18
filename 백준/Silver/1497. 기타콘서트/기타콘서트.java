import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int minCount = Integer.MAX_VALUE;
    static int maxGit = 0;
    static long[] bit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bit = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] chars= st.nextToken().toCharArray();

            for (int j = 0; j < M; j++) {
                if (chars[j] == 'Y') {
                    bit[i] |= 1L << j;
                }
            }
        }

        search(0, 0, 0);
        if (minCount == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }
    }

    static void search(int index, long mask, int current) {
        int bitCount = Long.bitCount(mask);

        if (bitCount == maxGit && current < minCount) {
            minCount = current;
        }

        if (bitCount > maxGit) {
            minCount = current;
            maxGit = bitCount;
        }

        if (index == N || bitCount == M) {
            return;
        }

        search(index + 1, mask | bit[index], current + 1);
        search(index + 1, mask, current);
    }
}