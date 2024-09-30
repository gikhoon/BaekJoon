import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static boolean[] isTruthParty;
    static Set<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        isTruthParty = new boolean[M];
        party = new HashSet[M];



        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.add(num);
            isVisited[num] = true;
        }

        for (int i = 0; i < M; i++) {
            party[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                party[i].add(num);
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < M; i++) {
                if(isTruthParty[i] || !party[i].contains(poll)) continue;
                isTruthParty[i] = true;
                for (Integer member : party[i]) {
                    if(isVisited[member]) continue;
                    isVisited[member] = true;
                    q.add(member);
                }
            }
        }

        int lie = 0;
        for (boolean isTruth : isTruthParty) {
            if(!isTruth) lie++;
        }

        System.out.println(lie);
    }
}