import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        return weight - o.weight;
    }
}
public class Main {
    static List<Jewel> jewels = new ArrayList<>();
    static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            jewels.add(new Jewel(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N) {
                if (bags[i] < jewels.get(j).weight) {
                    break;
                }
                    pq.add(jewels.get(j++).value);
            }

            if (!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);
    }
}
