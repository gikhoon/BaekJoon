import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    static long[] cards;
    static ReadCard[] readCards;

    static class ReadCard implements Comparable<ReadCard> {
        private long num;
        private int order;

        public ReadCard(long num, int order) {
            this.num = num;
            this.order = order;
        }
        @Override
        public int compareTo(ReadCard o) {
            return Long.compare(num, o.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        readCards = new ReadCard[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            readCards[i] = new ReadCard(Long.parseLong(st.nextToken()), i);
        }

        Arrays.sort(cards);
        Arrays.sort(readCards);

        boolean[] answer = new boolean[M];

        int wantCard = 0;
        int lo = 0;
        while (wantCard < M) {
            int index = findIndex(lo, N, readCards[wantCard].num);
            if (index < 0) {
                answer[readCards[wantCard].order] = false;
            } else {
                answer[readCards[wantCard].order] = true;
                lo = index + 1;
            }
            wantCard++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (answer[i]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        sb.append("\n");
        System.out.println(sb);
    }


    static int findIndex(int lo, int hi, long num) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (cards[mid] == num) {
                return mid;
            }
            if (cards[mid] < num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return -1;
    }
}
