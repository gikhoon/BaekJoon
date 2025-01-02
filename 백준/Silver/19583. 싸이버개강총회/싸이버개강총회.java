import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
    int hour;
    int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Time o) {
        if (hour != o.hour) {
            return hour - o.hour;
        }
        return minute - o.minute;
    }
}

public class Main {
    private static HashSet<String> attendance = new HashSet<>();
    static Time start, end, streamingEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = toTime(st.nextToken());
        end = toTime(st.nextToken());
        streamingEnd = toTime(st.nextToken());

        int total = 0;
        while (true) {
            String s = br.readLine();
            if (s==null || s.isEmpty()) {
                break;
            }
            String[] split = s.split(" ");
            Time time = toTime(split[0]);
            String name = split[1];
            if (time.compareTo(start) <= 0) {
                attendance.add(name);
                continue;
            }
            if (time.compareTo(end) < 0) {
                continue;
            }
            if (time.compareTo(streamingEnd) > 0) {
                break;
            }

            if (attendance.contains(name)) {
                attendance.remove(name);
                total++;
            }
        }
        System.out.println(total);
    }

    private static Time toTime(String timeStr) {
        String[] timeSplit = timeStr.split(":");
        return new Time(Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]));
    }
}
