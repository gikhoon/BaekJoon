import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] isCheck;
    static List<Integer> data = new ArrayList<>();
    static boolean isTrue = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String kriii = br.readLine();
        countLength(kriii);

        backTracking(kriii, 0);

        for (int d : data) {
            System.out.print(d+" ");
        }
    }

    private static void backTracking(String str, int index) {
        if (index >= str.length()) {
            isTrue = true;
            return;
        }

        int one = Integer.parseInt(str.substring(index, index + 1));
        if (one > isCheck.length - 1) {
            return;
        }
        if (!isCheck[one]) {
            isCheck[one] = true;
            data.add(one);
            backTracking(str, index + 1);
            if (isTrue) {
                return;
            }
            data.remove(data.size() -1);
            isCheck[one] = false;
        }

        if (str.length() - 1 == index) {
            return;
        }

        int ten = Integer.parseInt(str.substring(index, index + 2));
        if (ten > isCheck.length - 1) {
            return;
        }
        if (!isCheck[ten]) {
            isCheck[ten] = true;
            data.add(ten);
            backTracking(str, index + 2);
            if (isTrue) {
                return;
            }
            data.remove(data.size() -1);
            isCheck[ten] = false;
        }
    }

    private static void countLength(String str) {
        if (str.length() <= 9) {
            isCheck = new boolean[str.length() + 1];
            return;
        }

        isCheck = new boolean[(str.length() - 9) / 2 + 10];
    }
}