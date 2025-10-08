import java.util.*;

class Sam {
    int start;
    int duration;
    int end;
    
    public Sam(int start, int duration) {
        this.start = start;
        this.duration = duration;
        end = start + duration;
    }
}

class LastTime implements Comparable<LastTime>{
    int sam;
    int dur;
    int num;
    
    public LastTime(int sam, int dur, int num) {
        this.sam = sam;
        this.dur = dur;
        this.num = num;
    }
    
    @Override
    public int compareTo(LastTime l) {
        return l.dur - this.dur;
    }
}

class Solution {
    static HashMap<Integer, List<Sam>> samList = new HashMap<>();
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        for(int[] req : reqs) {
            if(!samList.containsKey(req[2])) {
                samList.put(req[2], new ArrayList<>());
 
            }
            samList.get(req[2]).add(new Sam(req[0], req[1]));
        }
        
        List<LastTime> pq = new ArrayList<>();
        
        for(int i=1;i<=k;i++) {
            if(samList.containsKey(i)) {
                pq.add(ofTime(i, 1));
            }
        }
        int count = n - k;
        while(count > 0) {
            int index = 0;
            int smallSize = -1;
            
            for(LastTime cur : pq) {
                LastTime newLastTime = ofTime(cur.sam, cur.num +1);
                if(cur.dur - newLastTime.dur > smallSize) {
                    index = cur.sam;
                    smallSize = cur.dur - newLastTime.dur;
                }
            }
            
            for(LastTime cur : pq) {
                if(cur.sam == index) {
                    cur.dur-= smallSize;
                    cur.num++;
                }
            }      
            count--;
        }
        
        for(LastTime cur : pq) {
            answer += cur.dur;
        }
        
        return answer;
    }
    
    private LastTime ofTime(int sam, int num) {
        List<Sam> sams = samList.get(sam);
        Collections.sort(sams, (o1, o2) -> o1.start - o2.start);
        //System.out.println(sams.size());
        
        int wait = 0;
        int index = 0;
        PriorityQueue<Sam> q = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        q.add(sams.get(index++));
        
        while(index < sams.size()) {
            Sam newTask = sams.get(index++);
            Sam lastSam =  q.peek();
            if(newTask.start >= lastSam.end) {
                q.poll();
                q.add(new Sam(newTask.start, newTask.duration));
            } else if(q.size() == num) {
                q.poll();
                q.add(new Sam(lastSam.end, newTask.duration));
                wait += (lastSam.end - newTask.start);
            } else {
                q.add(new Sam(newTask.start, newTask.duration));
            }
        }
        
        return new LastTime(sam,wait,num);
    }
}