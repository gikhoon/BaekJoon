import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Water{
    int[] waterList = new int[3];

    Water(int waterA, int waterB, int waterC) {
        this.waterList[0] = waterA;
        this.waterList[1] = waterB;
        this.waterList[2] = waterC;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Water water = (Water) obj;
        return waterList[0] == water.waterList[0] && waterList[1] == water.waterList[1]
                && waterList[2] == water.waterList[2];
    }

    @Override
    public int hashCode() {
        return Objects.hash(waterList[0], waterList[1], waterList[2]);
    }
}
public class Main {
    /**
     * 00C를 visited에 넣는다. 방법 2가지 10/0/0으로 하던지 Node로 A=10 B=0, C=0으로 하던지 이걸로 하자 편할 듯 A -> B,C B->A,C C -> A,B로 물을 옮긴다 옮긴
     * 값이 visited에 있는지 확인한다. 있으면 넘긴다 없으면 visited에 넣고 queue에 넣는다 A=0이면 C 값을 answer에 넣는다 => Set으로 넣자 중복이 있을 수 있으니까 Queue로 넣읍시다!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maxWater = new int[3];

        for (int i = 0; i < 3; i++) {
            maxWater[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> answerSet = new HashSet<>();
        Queue<Water> queue = new LinkedList<>();
        Set<Water> visited = new HashSet<>();

        Water initWater = new Water(0, 0, maxWater[2]);
        queue.add(initWater);
        visited.add(initWater);
        answerSet.add(maxWater[2]);

        while (!queue.isEmpty()) {
            Water currentWater = queue.poll();

            /** i -> j로 물을 주자**/
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i==j) continue;
                    if (currentWater.waterList[i] != 0 && currentWater.waterList[j] != maxWater[j]) {
                        int[] waterList = currentWater.waterList.clone();
                        int canMove = Math.min(maxWater[j] - waterList[j],waterList[i]);

                        waterList[i] -= canMove;
                        waterList[j] += canMove;

                        Water newWater = new Water(waterList[0], waterList[1], waterList[2]);

                        if (!visited.contains(newWater)) {
                            visited.add(newWater);
                            queue.add(newWater);
                            if (waterList[0] == 0) {
                                answerSet.add(waterList[2]);
                            }
                        }
                    }
                }
            }
        }

        List<Integer> setList = new ArrayList<>(answerSet);
        Collections.sort(setList);

        StringBuilder sb = new StringBuilder();
        for (Integer cWater : setList) {
            sb.append(cWater).append(" ");
        }

        System.out.println(sb);
    }
}
