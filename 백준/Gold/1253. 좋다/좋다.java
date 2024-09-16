import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//-10 -9 -7 -1 0 0 0 1 2 3 4 5 7
public class Main {
    static int N;
    static int[] nums;
    static int answer = 0;
    static int count0 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == 0) count0++;
        }

        Arrays.sort(nums);

        for (int index=0;index<N;index++) {
            boolean flag = false;
            int num = nums[index];
            if (num < 0) {
                if (isGood(index + 1, N - 1, num)) {
                    flag = true;
                }
               ;
            } else if (num > 0) {
                if (isGood(0, index - 1, num)) {
                    flag = true;
                }
            } else {
                if (count0 >= 3) {
                    flag = true;
                }
            }

            if (!flag && isGoodMiddle(index, num)) {
                ;flag = true;
            }

            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isGoodMiddle(int index, int num) {
        int start = 0;
        int end = N - 1;
        while (start < index && end > index) {
            int sum = nums[start] + nums[end];
            if (sum == num) {
                return true;
            }
            if (sum < num) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    private static boolean isGood(int start, int end, int num) {
        while (start < end && end < N && start >=0) {
            int sum = nums[start] + nums[end];
            if (sum == num) {
                return true;
            }
            if (sum < num) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }
}