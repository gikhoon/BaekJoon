
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
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] seq = new Node[6];
        List<Integer>[] mapByDir =new List[5];
        for (int i = 1; i <= 4; i++) {
            mapByDir[i] = new ArrayList<>();
        }

        int minR = 0, minC = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            seq[i] = new Node(dir, length);
            mapByDir[dir].add(length);
            if (i >= 2 && seq[i].dir == seq[i - 2].dir) {
                if (seq[i - 1].dir <= 2) {
                    minR = seq[i - 1].len;
                } else {
                    minC = seq[i - 1].len;
                }
            }
        }

        if (seq[0].dir == seq[4].dir) {
            if (seq[5].dir <= 2) {
                minR = seq[5].len;
            } else {
                minC = seq[5].len;
            }
        }

        if (seq[1].dir == seq[5].dir) {
            if (seq[0].dir <= 2) {
                minR = seq[0].len;
            } else {
                minC = seq[0].len;
            }
        }

        //0 4비교 + 1 5 비교 해야함

        int size = 1;
        for (int i=1;i<=4;i++) {
            List<Integer> l = mapByDir[i];
            if (l.size() == 1) {
                size *= l.get(0);
            }
        }

        size -= (minC * minR);
        System.out.println(size * N);
    }

    //순서를 저장
    //앞 뒤의 방향이 같으면 min 갯수가 하나면 max
    //시작과 끝이 같을 수 있다. 5번쨰랑 1번째, 4번째랑 0번째
}
