import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[10];

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 10; i++) {
            list[i] = (int) Math.pow(i, P);
        }

        List<Integer> s = new ArrayList<>();
        s.add(A);
        int index = 0;
        while (true) {
            int i = s.get(index);
            int sum = 0;
            while (i > 0) {
                sum += list[i % 10];
                i /= 10;
            }
            if (s.contains(sum)) {
                System.out.println(s.indexOf(sum));
                break;
            }
            s.add(sum);
            index++;
        }
    }
}
