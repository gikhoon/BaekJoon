import java.util.*;
public class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][] intArrays = new int[101][101]; 

        List<Robot> list = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int index = routes[i][0] - 1;
            Pos pos = new Pos(points[index][0], points[index][1]);
            Robot robot = new Robot(pos);

            intArrays[pos.y][pos.x]++;

            for (int j = 1; j < routes[i].length; j++) {
                index = routes[i][j] - 1;
                pos = new Pos(points[index][0], points[index][1]);
                robot.posList.add(pos);
            }

            list.add(robot);
        }

        for (int[] row : intArrays) {
            for (int val : row) {
                if (val > 1) {
                    answer++;
                }
            }
        }

        while (list.size() > 1) {
            List<Integer> removeList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                boolean b = list.get(i).movePos(intArrays);

                if (!b) {
                    removeList.add(i);
                }
            }

            for (int idx : removeList) {
                list.remove(idx);
            }

            for (int[] row : intArrays) {
                for (int val : row) {
                    if (val > 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static class Robot {
        public Pos pos;
        public List<Pos> posList;

        public Robot(Pos pos) {
            this.pos = pos;
            posList = new ArrayList<>();
        }

        public boolean movePos(int[][] intArrays) {
            if (posList.size() > 0 && posList.get(0).y == pos.y && posList.get(0).x == pos.x) {
                posList.remove(0);
            }

            intArrays[pos.y][pos.x]--;

            if (posList.size() == 0) {
                return false;
            }

            if (posList.get(0).y != pos.y) {
                if (posList.get(0).y > pos.y) {
                    pos.y++;
                } else {
                    pos.y--;
                }
            } else if (posList.get(0).x != pos.x) {
                if (posList.get(0).x > pos.x) {
                    pos.x++;
                } else {
                    pos.x--;
                }
            }

            intArrays[pos.y][pos.x]++;
            return true;
        }
    }
    
    public static class Pos {
        public int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}