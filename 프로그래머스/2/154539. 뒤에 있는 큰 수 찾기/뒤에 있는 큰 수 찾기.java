import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        Arrays.fill(answer, -1);
        for(int i=1;i<len;i++) {
            while(!st.isEmpty()) {
                int index = st.pop();
                if(numbers[index] < numbers[i]) {
                    answer[index] = numbers[i];
                } else {
                    st.push(index);
                    break;
                }
            }
            st.push(i);
        }
        return answer;
    }
    
    //먼저 바로 뒤에 num을 찾기
    //더 크면 그냥 그값 넣고 끝
    //작으면 answer를 본다
    //-1이면 나도 -1
    //값이 크면 나도 answer
    //값이 작으면 인덱스를 찾는다
    //타고 들어가 또다시 함(다음 큰 수)
}