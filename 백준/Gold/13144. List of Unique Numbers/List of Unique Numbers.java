import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> s = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int start = 0; int end = 0;

        //1 2 3 4 5
        while (end < n) {
            int newData = data[end];
            while (s.contains(newData)) {
                s.remove(data[start]);
                start++;
            }
            s.add(newData);
            answer += end - start + 1;
            end++;
        }

        System.out.println(answer);
    }
}
