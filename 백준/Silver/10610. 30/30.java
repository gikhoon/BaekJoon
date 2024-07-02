
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Arrays.sort(split);
        
        if (Integer.parseInt(split[0]) != 0) {
            System.out.println(-1);
            return;
        }
        
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = split.length -1; i >= 0; i--) {
            sum += Integer.parseInt(split[i]);
            sb.append(split[i]);
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}
