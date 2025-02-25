import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] inputs = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : inputs) {
            while (K > 0 && !deque.isEmpty() && deque.getLast() < c) {
                deque.removeLast();
                K--;
            }
            deque.addLast(c);
        }

        StringBuilder sb = new StringBuilder();

        while (deque.size() > K) {
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);
    }
}
