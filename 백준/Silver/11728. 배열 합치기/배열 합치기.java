
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[Integer.parseInt(st.nextToken())];
        int[] b = new int[Integer.parseInt(st.nextToken())];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int k = 0;

        StringBuilder sb = new StringBuilder();
        while (i<a.length && k<b.length) {
            if (a[i] < b[k]) {
                sb.append(a[i]);
                i++;
            } else {
                sb.append(b[k]);
                k++;
            }
            sb.append(" ");
        }

        for (int j = i; j < a.length; j++) {
            sb.append(a[j]).append(" ");
        }

        for (int j = k; j < b.length; j++) {
            sb.append(b[j]).append(" ");
        }

        System.out.println(sb);
    }
}
