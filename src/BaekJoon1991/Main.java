package BaekJoon1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Child> hm = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            st = new StringTokenizer(br.readLine());
            hm.put(st.nextToken(), new Child(st.nextToken(), st.nextToken()));

        }
        First("A");
        sb.append("\n");
        Second("A");
        sb.append("\n");
        Third("A");
        System.out.println(sb);
    }
    static void First(String node){
        sb.append(node);
        if(!hm.get(node).leftChild.equals(".")){
            First(hm.get(node).leftChild);
        }
        if(!hm.get(node).rightChild.equals(".")){
            First(hm.get(node).rightChild);
        }
    }
    static void Second(String node){
        if(!hm.get(node).leftChild.equals(".")){
            Second(hm.get(node).leftChild);
        }
        sb.append(node);
        if(!hm.get(node).rightChild.equals(".")){
            Second(hm.get(node).rightChild);
        }
    }
    static void Third(String node){
        if(!hm.get(node).leftChild.equals(".")){
            Third(hm.get(node).leftChild);
        }
        if(!hm.get(node).rightChild.equals(".")){
            Third(hm.get(node).rightChild);
        }
        sb.append(node);
    }
}
class Child{
    String leftChild;
    String rightChild;
    Child(String a,String b){
        leftChild=a;
        rightChild=b;
    }
}

