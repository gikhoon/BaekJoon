import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Data implements Comparable<Data> {
    int data;

    public Data(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(Data o) {
        if (Math.abs(o.data) == Math.abs(data)) {
            return data - o.data;
        }
        return Math.abs(data) - Math.abs(o.data);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data == 0) {
                if (pq.isEmpty()) {
                    sb.append("0").append('\n');
                } else {
                    sb.append(pq.poll().data).append('\n');
                }
            } else {
                pq.add(new Data(data));
            }
        }

        System.out.println(sb);
    }
}
