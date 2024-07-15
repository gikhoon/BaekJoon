import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Node{
    int r;
    int c;

    Node(int r,int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] list;

    static List<Node> blankList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    blankList.add(new Node(i, j));
                } else {
                    list[i][j] = num;
                }
            }
        }

        fillBlank(0);
    }

    private static boolean fillBlank(int index) {
        if (index == blankList.size()) {
            printList();
            return true;
        }
        Node node = blankList.get(index);
        for (int i = 1; i <= 9; i++) {
            if (isBlankAvailable(node, i)) {
                list[node.r][node.c] = i;
                if(fillBlank(index + 1)) return true;
                list[node.r][node.c] = 0;
            }
        }

        return false;
    }

    private static boolean isBlankAvailable(Node node, int num) {
        for (int i = (node.r / 3) * 3; i < (node.r / 3) * 3 + 3; i++) {
            for (int j = (node.c / 3) * 3; j < (node.c / 3) * 3 + 3; j++) {
                if (list[i][j] == num) return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (list[node.r][i] == num) return false;
            if (list[i][node.c] == num) return false;
        }

        return true;
    }

    private static void printList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(list[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

