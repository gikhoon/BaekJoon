import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    que.put(n, que.getOrDefault(n, 0) + 1);
                } else {
                    if (que.isEmpty())
                        continue;

                    int num = n == 1 ? que.lastKey() : que.firstKey();
                    if (que.put(num, que.get(num) - 1) == 1)
                        que.remove(num);
                }
            }

            System.out.println(que.isEmpty() ? "EMPTY" : que.lastKey() + " " + que.firstKey());
        }

    }

}