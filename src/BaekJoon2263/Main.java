package BaekJoon2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> inOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            inOrder.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            postOrder.add(Integer.parseInt(st.nextToken()));
        }


        FreeOrder(0,inOrder.size()-1,0,postOrder.size()-1);
        System.out.println(sb);
    }


    static void FreeOrder(int inOrderStart,int inOrderEnd,int postOrderStart, int postOrderEnd){
        if(inOrderStart>inOrderEnd||postOrderStart>postOrderEnd) return;


        int postOrderData = postOrder.get(postOrderEnd);
        sb.append(postOrderData + " ");
        int inOrderIndex= inOrder.indexOf(postOrderData);
        int left = inOrderIndex-inOrderStart;


        FreeOrder(inOrderStart,inOrderIndex-1,postOrderStart,postOrderStart+left-1);
        FreeOrder(inOrderIndex+1,inOrderEnd,postOrderStart+left,postOrderEnd-1);

    }
}
