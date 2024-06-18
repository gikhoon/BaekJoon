import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int commandCount = Integer.parseInt(bf.readLine());
        int lastData = -1;
        while(commandCount-->0){
            String command=bf.readLine();
            String[] commands = command.split(" ");
            switch (commands[0]){
                case "push":
                    q.offer(Integer.parseInt(commands[1]));
                    lastData = Integer.parseInt(commands[1]);
                    break;
                case "pop":
                    if(q.isEmpty()) System.out.println("-1");
                    else{
                        System.out.println(q.poll());
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty()){System.out.println("1");}
                    else{System.out.println("0");}
                    break;
                case "front":
                    if(q.isEmpty()) {
                        System.out.println("-1");
                    }else{
                        System.out.println(q.peek());
                    }
                    break;
                case "back":
                    if(q.isEmpty()) {
                        System.out.println("-1");
                    }else{
                        System.out.println(lastData);
                    }
                    break;
                default:
            }
        }
    }
}
