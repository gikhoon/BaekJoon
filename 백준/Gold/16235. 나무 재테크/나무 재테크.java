import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
    int r;
    int c;
    int age;

    public Tree(int r, int c, int age) {
        this.r = r;
        this.c = c;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return age - o.age;
    }
}


public class Main {
    static int[][] soil;
    static int[][] plusSoil;
    static PriorityQueue<Tree> liveTree = new PriorityQueue<>();
    static List<Tree> deadTree = new LinkedList<>();
    static int N, M;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        soil = new int[N][N];
        plusSoil = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(soil[i], 5);
            for (int j = 0; j < N; j++) {
                plusSoil[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            liveTree.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken())));
        }

        for (int k = 0; k < K; k++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(liveTree.size());
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                soil[i][j] += plusSoil[i][j];
            }
        }
    }

    private static void fall() {
        List<Tree> liveTrees = liveTree.stream().collect(toList());
        for (Tree tree : liveTrees) {
            if (tree.age % 5 != 0) {
                continue;
            }
            for (int d = 0; d < 8; d++) {
                int newR = tree.r + dr[d];
                int newC = tree.c + dc[d];
                if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                    liveTree.add(new Tree(newR, newC, 1));
                }
            }
        }
    }

    private static void summer() {
        for (Tree deadTree : deadTree) {
            soil[deadTree.r][deadTree.c] += deadTree.age / 2;
        }

        deadTree.clear();
    }

    private static void spring() {
        PriorityQueue<Tree> newLiveTree = new PriorityQueue<>();

        while (!liveTree.isEmpty()) {
            Tree tree = liveTree.poll();
            if (tree.age > soil[tree.r][tree.c]) {
                deadTree.add(tree);
            } else {
                soil[tree.r][tree.c] -= tree.age;
                tree.age++;
                newLiveTree.add(tree);
            }
        }

        liveTree = newLiveTree;
    }
}