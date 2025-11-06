import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long sumA = 0;
        long sumB = 0;
        long[] A = new long[N];
        long[] B = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sumA += A[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            sumB += B[i];
        }

        int aIndex = N - 1;
        int bIndex = N - 1;
        while (K > 0) {
            if (sumA > sumB) {
                sumA -= A[aIndex--];
            } else {
                sumB -= B[bIndex--];
            }
            K--;
        }

        System.out.println(Math.max(sumA, sumB));
    }
}
