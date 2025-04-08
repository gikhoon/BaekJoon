import java.util.*;

class Solution {
    int basicTime, basicFee, unitTime, unitFee;
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> total = new HashMap<>();
        Map<Integer, Integer> enters = new HashMap<>();
        
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
        
        for(String record : records) {
            String[] split = record.split(" ");
            String time = split[0]; int car = Integer.parseInt(split[1]); String command = split[2];
            if(command.equals("IN")) {
                enters.put(car, toMinute(time));
                continue;
            }
            
            int maintainTime = toMinute(time) - enters.get(car);
            enters.remove(car);
            if(total.containsKey(car)) {
                total.put(car, total.get(car) + maintainTime);
            } else {
                total.put(car, maintainTime);
            }
        }
        
        int endTime = toMinute("23:59");
        for(Map.Entry<Integer, Integer> entry : enters.entrySet()) {
            int maintainTime = endTime - entry.getValue();
            int car = entry.getKey();
            if(total.containsKey(car)) {
                total.put(car, total.get(car) + maintainTime);
            } else {
                total.put(car, maintainTime);
            }
        }
        
        int[] answer = new int[total.size()];
        List<Integer> sortKey = new ArrayList<>(total.keySet());
        Collections.sort(sortKey);
        int index = 0;
        for(int car : sortKey) {
            answer[index++] = calculateFee(total.get(car));
        }
        return answer;
    }
    
    private int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    private int calculateFee(int time) {
        if(time <= basicTime) return basicFee;
        int addFee = (int)Math.ceil((time - basicTime) / unitTime) * unitFee;
        int t = (time - basicTime) / unitTime;
        if((time - basicTime) % unitTime != 0) t++;
        return basicFee + t * unitFee;
    }
}