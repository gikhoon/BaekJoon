import java.util.*;

class Time implements Comparable<Time> {
    boolean isExit;
    int hour;
    int minute;
    int endHour;
    int endMinute;
    
    public Time(int hour, int minute, int endHour, int endMinute) {
        this.isExit = false;
        this.hour = hour;
        this.minute = minute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }
    
    @Override
    public int compareTo(Time t) {
        if(t.hour != hour) {
            return hour - t.hour;
        }
        if(t.minute != minute) {
            return minute - t.minute;
        }
        if(t.isExit) return 1;
        return -1;
    }
        
}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Time> times = new PriorityQueue<>();
        for(String[] time : book_time) {
            times.add(parseTime(time));
        }
        int rooms = 0;
        while(!times.isEmpty()) {
            Time time = times.poll();
            if(time.isExit) {
                rooms--;
                continue;
            }
            
            rooms++;
            answer = Math.max(answer, rooms);
            time.hour = time.endHour;
            time.minute = time.endMinute;
            time.isExit = true;
            times.add(time);
            
        }
        return answer;
    }
    
    private Time parseTime(String[] str) {
        String[] start = str[0].split(":");
        String[] end = str[1].split(":");
        int[] endInt = addExit(new int[] {Integer.parseInt(end[0]), Integer.parseInt(end[1])});
        return new Time(Integer.parseInt(start[0]), Integer.parseInt(start[1]), endInt[0], endInt[1]);
    }
    
    private int[] addExit(int[] time) {
        int[] addTime = new int[2];
        addTime[1] = (time[1] + 10) % 60;
        addTime[0] = time[0];
        if(time[1] >= 50) {
            addTime[0]++;
        }
        return addTime;
    }
}