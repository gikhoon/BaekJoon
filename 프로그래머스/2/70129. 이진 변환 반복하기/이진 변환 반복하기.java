class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int round = 0;
        while(!s.equals("1")) {
            int length = s.length();
            int zero = 0;
            String[] split = s.split("");
            for(String c : split) {
                if(c.equals("0")) {
                    zero++;
                }
            }
            answer[0]++;
            answer[1] += zero;
            s = Integer.toBinaryString(length - zero);
        }
        return answer;
    }
}