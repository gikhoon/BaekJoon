import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int P = sc.nextInt();
            
            int sum = 0;
            int now = 0;
            boolean bomb = false;
            for (int i = 1; i <= N; i++) {
                now += i;
                if (now == P) {
                    bomb = true;
                }
                sum += i;
            }

            if (bomb) {
                sum--; // 1을 빼는거 맞음
            }
            
            System.out.println(sum);
        }
    }
}
