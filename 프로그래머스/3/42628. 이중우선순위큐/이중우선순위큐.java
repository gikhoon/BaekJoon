import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(String operation : operations) {
            String[] op = operation.split(" ");
            if(op[0].equals("I")) {
                int num = Integer.parseInt(op[1]);
                if(!numbers.containsKey(num)) {
                    numbers.put(num, 0);
                }
                numbers.put(num, numbers.get(num) + 1);
                maxQ.add(num);
                minQ.add(num);
            } else {
                int num = Integer.parseInt(op[1]);
                if(num == 1) {
                    while(!maxQ.isEmpty()) {
                        int cur = maxQ.poll();
                        if(!numbers.containsKey(cur)) {
                            continue;
                        }
                        if(numbers.get(cur) == 1) {
                            numbers.remove(cur);
                        } else {
                            numbers.put(cur, numbers.get(cur) -1);
                        }
                        break;
                    }
                } else {
                    while(!minQ.isEmpty()) {
                        int cur = minQ.poll();
                        if(!numbers.containsKey(cur)) {
                            continue;
                        }
                        if(numbers.get(cur) == 1) {
                            numbers.remove(cur);
                        } else {
                            numbers.put(cur, numbers.get(cur) -1);
                        }
                        break;
                    }
                }
                
            }
        }
        int[] answer = new int[2];
        while(true) {
            if(minQ.isEmpty()) {
                answer[0] = 0;
                answer[1] = 0;
                return answer;
            }
            int cur = minQ.poll();
            if(numbers.containsKey(cur)) {
                answer[1] = cur;
                break;
            }
        }
        
        while(!maxQ.isEmpty()) {
            int cur = maxQ.poll();
            if(numbers.containsKey(cur)) {
                answer[0] = cur;
                break;
            }
        }
        return answer;
    }
    
    //SET을 통해 유효한 값 관리
    
}