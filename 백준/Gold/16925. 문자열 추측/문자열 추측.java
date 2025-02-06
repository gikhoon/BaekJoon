import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static String[] origin = new String[2];
    static String[] subString;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        subString = new String[2 * N - 2];

        String s1 = null, s2 = null;
        for (int i = 0; i < 2 * N - 2; i++) {
            subString[i] = br.readLine();
            if (subString[i].length() == N - 1) {
                if (s1 == null) {
                    s1 = subString[i];
                } else {
                    s2 = subString[i];
                }
            }
        }

        origin[0] = s1 + s2.charAt(s2.length() - 1);
        origin[1] = s2 + s1.charAt(s1.length() - 1);

        for (String s : origin) {
            set.clear();
            sb = new StringBuilder();
            for (String fix : subString) {
                if (s.indexOf(fix) == 0) {
                    if (!set.contains(fix)) {
                        set.add(fix);
                        sb.append("P");
                    } else {
                        sb.append("S");
                    }
                } else {
                    if (fix.charAt(fix.length() - 1) == s.charAt(s.length() - 1)) {
                        sb.append("S");
                    }
                }
            }

            if (sb.length() == 2 * N - 2) {
                System.out.println(s);
                System.out.println(sb);
                return;
            }
        }
        System.out.println(origin[1]);
        System.out.println(sb);
    }
}
