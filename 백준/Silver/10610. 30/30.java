
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Arrays.sort(split);

        int[] numList = new int[split.length];
        if (Integer.parseInt(split[0]) != 0) {
            System.out.println(-1);
            return;
        }
        numList[0] = 0;
        int sum = 0;
        for (int i = 1; i < split.length; i++) {
            numList[i] = Integer.parseInt(split[i]);
            sum += numList[i];
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = numList.length-1; i >= 0; i--) {
            sb.append(numList[i]);
        }

        System.out.println(sb);
    }
}
