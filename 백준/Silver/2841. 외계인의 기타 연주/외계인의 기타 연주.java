import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int musicNum, fret = 0;
        int move = 0;
        int nowLine, nowFret;

        Stack<Integer>[] stack = new Stack[7];

        StringTokenizer st = new StringTokenizer(br.readLine());

        musicNum = Integer.parseInt(st.nextToken());
        fret = Integer.parseInt(st.nextToken());

        for (int x = 0; x <= 6; x++) {
            stack[x] = new Stack<Integer>();
        }

        for (int x = 0; x < musicNum; x++) {
            st = new StringTokenizer(br.readLine());

            nowLine = Integer.parseInt(st.nextToken());
            nowFret = Integer.parseInt(st.nextToken());

            // 현재 프렛보다 크면 손 똄
            while(!stack[nowLine].isEmpty() && stack[nowLine].peek() > nowFret ){
                stack[nowLine].pop();
                move++;
            }

            //  현재 줄 에서 잡은 프렛이 없거나 현재 줄에서 잡은 프렛이 현재 프렛보다 작을 경우 프렛을 새로 잡음
            if (stack[nowLine].isEmpty() || stack[nowLine].peek() < nowFret) {
                stack[nowLine].push(nowFret);
                move++;
            }


        }

        bw.write(String.valueOf(move));
        bw.flush();


    }


}