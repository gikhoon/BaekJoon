import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Member> members = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members.add(new Member(st.nextToken(), chInteger(st.nextToken()), chInteger(st.nextToken()), chInteger(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        members.stream().sorted()
                .forEach(
                        member -> sb.append(member.name).append("\n")
                );
        System.out.println(sb);
    }

    private static int chInteger(String s) {
        return Integer.parseInt(s);
    }

    static class Member implements Comparable<Member>{
        private String name;
        private int korean;
        private int english;
        private int math;

        public Member(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Member o) {
            if (this.korean < o.korean) {
                return 1;
            } else if (this.korean > o.korean) {
                return -1;
            }
            else {
                if (this.english > o.english) {
                    return 1;
                } else if (this.english < o.english) {
                    return -1;
                } else {
                    if (this.math < o.math) {
                        return 1;
                    } else if (this.math > o.math) {
                        return -1;
                    } else {
                        return this.name.compareTo(o.name);
                    }
                }
            }
        }
    }
}
