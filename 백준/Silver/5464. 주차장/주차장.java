import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] Rs;
    static int[] carW;
    static boolean[] isFull;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Rs = new int[N];
        isFull = new boolean[N];
        carW = new int[M + 1];

        for (int i = 0; i < N; i++) {
            Rs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= M; i++) {
            carW[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> q = new LinkedList<>();
        int cost = 0;
        for (int i = 0; i < M * 2; i++) {
            int car = Integer.parseInt(br.readLine());
            if (car > 0) {
                int index = getIndex();
                //자리가 없으면 q에 넣는다
                if (index == -1) {
                    q.add(car);
                    continue;
                }
                //자리가 있으면 차를 넣는다
                putCar(index, car);
                //돈 계산
                cost += Rs[index] * carW[car];
            } else {
                int index = map.get(car * -1);
                isFull[index] = false;
                map.remove(car);

                //자가 있는지 확인
                if (!q.isEmpty()) {
                    int waitingCar = q.poll();
                    putCar(index, waitingCar);
                    cost += Rs[index] * carW[waitingCar];
                }
            }
        }

        System.out.println(cost);
    }

    private static void putCar(int index, int car) {
        isFull[index] = true;
        map.put(car, index);
    }

    private static int getIndex() {
        for (int i=0;i<Rs.length;i++) {
            if (!isFull[i]) return i;
        }
        return -1;
    }
}



