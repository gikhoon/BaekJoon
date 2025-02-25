import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
class House {
    int index;
    int people;

    public House(int index, int people) {
        this.index = index;
        this.people = people;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<House> houses = new ArrayList<>();

        long sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            houses.add(new House(index, people));
            sum += people;
        }

        sum = (sum + 1) / 2;
        Collections.sort(houses, Comparator.comparingInt(o -> o.index));

        for (int i = 0; i < N; i++) {
            sum -= houses.get(i).people;
            if (sum <= 0) {
                System.out.println(houses.get(i).index);
                return;
            }
        }
    }
}
