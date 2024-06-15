import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();

        members.stream().sorted().forEach(
                member -> sb.append(member.age).append(" ").append(member.name).append("\n")
        );

        System.out.println(sb);
    }

    static class Member implements Comparable<Member> {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age > o.age) {
                return 1;
            } else if (this.age < o.age) {
                return -1;
            }
            return 0;
        }
    }
}
