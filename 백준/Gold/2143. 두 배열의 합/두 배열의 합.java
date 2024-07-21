import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] A, B;

    static List<Integer> aSumList;
    static List<Integer> bSumList;

    static BufferedReader br;

    static int T;

    static boolean[] isChecked;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int a = Integer.parseInt(br.readLine());
        A = new int[a];
        aSumList = new ArrayList<>(a * a);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < a; i++) {
            int sum = 0;
            for (int j = i; j < a; j++) {
                sum += A[j];
                aSumList.add(sum);
            }
        }



        int b = Integer.parseInt(br.readLine());
        B = new int[b];
        bSumList = new ArrayList<>(b * b);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < b; i++) {
            int sum = 0;
            for (int j = i; j < b; j++) {
                sum += B[j];
                bSumList.add(sum);
            }
        }

        Collections.sort(aSumList);
        Collections.sort(bSumList);

        int aIdx = 0;
        int bIdx = bSumList.size() - 1;
        long count = 0;
        while (aIdx < aSumList.size() && bIdx >= 0) {
            int aNum = aSumList.get(aIdx);
            int bNum = bSumList.get(bIdx);

            if (aNum + bNum < T) {
                aIdx++;
            } else if (aNum + bNum > T) {
                bIdx--;
            } else {
                long aCount = 0;
                long bCount = 0;

                while (aIdx < aSumList.size() && aSumList.get(aIdx) == aNum) {
                    aIdx++;
                    aCount++;
                }

                while (bIdx >= 0 && bSumList.get(bIdx) == bNum) {
                    bIdx--;
                    bCount++;
                }

                count += aCount * bCount;
            }

        }

        System.out.println(count);

    }
}
