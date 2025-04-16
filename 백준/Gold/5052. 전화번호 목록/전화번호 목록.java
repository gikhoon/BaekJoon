import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] inputs = new String[n];
            for (int i = 0; i < n; i++) {
                inputs[i] = br.readLine();
            }
            Arrays.sort(inputs);
            if (isUnique(inputs)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);

    }

    private static boolean isUnique(String[] inputs) {
        for (int i=0; i < inputs.length-1; i++) {
            if (inputs[i+1].startsWith(inputs[i])) return false;
        }
        return true;
    }
}
