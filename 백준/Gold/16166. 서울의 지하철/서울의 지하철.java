import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int train;
    int len;

    public Node(int train, int len) {
        this.train = train;
        this.len = len;
    }
}

public class Main {
    static HashMap<Long, List<Integer>> mapPerStation = new HashMap<>(); //역, 지하철
    static ArrayList<Long>[] train;
    static Set<Integer> trainSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        train = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            train[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                long t = Long.parseLong(st.nextToken());
                put(t, i);
                train[i].add(t);
            }
        }

        //0번 역이 지나는 지하철 목록들을 넣는다
        Queue<Node> q = new LinkedList<>();
        for (int train : mapPerStation.get(0L)) {
            trainSet.add(train);
            q.add(new Node(train, 0));
        }

        long destination = Long.parseLong(br.readLine());

        while (!q.isEmpty()) {
            Node cur = q.poll(); //호선 긁어오기
            for (long stat : train[cur.train]) {
                if(stat == destination) {
                    System.out.println(cur.len);
                    return;
                }
                List<Integer> trainList = mapPerStation.get(stat);
                for(int tr : trainList) {
                    if(!trainSet.contains(tr)) {
                        trainSet.add(tr);
                        q.add(new Node(tr, cur.len + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static void put(long station, int train) {
        if (!mapPerStation.containsKey(station)) {
            mapPerStation.put(station, new ArrayList<>());
        }
        mapPerStation.get(station).add(train);
    }

    //HashMap으로 각 역번호마다 다니는 지하철을 넣는다.
    //Queue<>()에 0의 호선을 넣는다.
    //Set에 넣은 호선 확인
    //
}
