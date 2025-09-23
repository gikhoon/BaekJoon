import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    static String s;
    static char[] t;
    static boolean isTrue = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine().toCharArray();

        find(0, t.length - 1);

        if(isTrue) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void find(int start, int end) {
        if (Math.abs(start - end) + 1 == s.length()) {
            //start > end면 뒤집고 비교
            if (s.equals(makeString(start, end))) {
                isTrue = true;
            }
            return;
        }
        if (isTrue) {
            return;
        }

        if (t[start] == 'B') {
            //1 3 -> 3 2 /// 3 1 -> 1 2 BAA => AA
            if (start > end) {
                find(end, start - 1);
            } else {
                find(end, start + 1);
            }

        }
        if (t[end] == 'A') {
            if (start > end) {
                find(start, end + 1);
                // 3 1
            } else {
                find(start, end - 1);
            }
        }
    }

    private static String makeString(int start, int end) {
        String str = "";
        if (start > end) {
            for (int i = start; i >= end; i--) {
                str += t[i];
            }
        } else {
            for (int i = start; i <= end; i++) {
                str += t[i];
            }
        }


        return str;
    }
}
