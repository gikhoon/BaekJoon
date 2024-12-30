import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Fish {
    int x, y, weight, dir;
    boolean isAlive = true;

    Fish(int x, int y, int weight, int dir) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.dir = dir;
    }

    Fish(Fish other) {
        this.x = other.x;
        this.y = other.y;
        this.weight = other.weight;
        this.dir = other.dir;
        this.isAlive = other.isAlive;
    }
}

class Shark {
    int x, y, dir, sum;

    Shark(int x, int y, int dir, int sum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.sum = sum;
    }
}

public class Main {
    private static int MAX = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[4][4];
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int weight = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                Fish fish = new Fish(i, j, weight, dir);
                fishList.add(fish);
                arr[i][j] = weight;
            }
        }

        Collections.sort(fishList, Comparator.comparingInt(o -> o.weight));

        Fish eat = fishList.get(arr[0][0] - 1);
        eat.isAlive = false;
        Shark shark = new Shark(0, 0, eat.dir, eat.weight);
        arr[0][0] = -1;

        DFS(arr, shark, fishList);
        System.out.println(MAX);
    }

    private static void DFS(int[][] arr, Shark shark, List<Fish> fishList) {
        MAX = Math.max(MAX, shark.sum);

        // 깊은 복사
        int[][] copyArr = deepCopyArray(arr);
        List<Fish> copyFishList = deepCopyFishList(fishList);

        // 물고기 이동
        for (Fish fish : copyFishList) {
            moveFish(fish, copyArr, copyFishList);
        }

        // 상어 이동
        for (int i = 1; i < 4; i++) {
            int nx = shark.x + dx[shark.dir] * i;
            int ny = shark.y + dy[shark.dir] * i;

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && copyArr[nx][ny] > 0) {
                int[][] nextArr = deepCopyArray(copyArr);
                List<Fish> nextFishList = deepCopyFishList(copyFishList);

                nextArr[shark.x][shark.y] = 0;

                Fish target = nextFishList.get(copyArr[nx][ny] - 1);
                Shark newShark = new Shark(target.x, target.y, target.dir, shark.sum + target.weight);
                target.isAlive = false;
                nextArr[target.x][target.y] = -1;

                DFS(nextArr, newShark, nextFishList);
            }
        }
    }

    static void moveFish(Fish fish, int[][] arr, List<Fish> fishes) {
        if (!fish.isAlive) return;

        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.dir + i) % 8;
            int nx = fish.x + dx[nextDir];
            int ny = fish.y + dy[nextDir];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] != -1) {
                arr[fish.x][fish.y] = 0;

                if (arr[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish temp = fishes.get(arr[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    arr[fish.x][fish.y] = temp.weight;

                    fish.x = nx;
                    fish.y = ny;
                }

                arr[nx][ny] = fish.weight;
                fish.dir = nextDir;
                return;
            }
        }
    }

    static int[][] deepCopyArray(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }

    static List<Fish> deepCopyFishList(List<Fish> fishes) {
        List<Fish> copy = new ArrayList<>();
        for (Fish fish : fishes) {
            copy.add(new Fish(fish));
        }
        return copy;
    }
}
