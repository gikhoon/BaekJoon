
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int dir;
    int len;

    public Node(int dir, int len) {
        this.dir = dir;
        this.len = len;
    }
}

public class Main {
    static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int total = 0;
        HashMap<String, Integer> count = new HashMap<>();
        while ((s = br.readLine()) != null) {
            total++;
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            names.add(entry.getKey());
        }

        Collections.sort(names);

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            int c = count.get(name) * 100;
            sb.append(name + " " + String.format("%.4f", (double) c / (double) total)).append("\n");
        }

        System.out.println(sb);
    }
}
