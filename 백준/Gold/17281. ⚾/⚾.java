import java.io.*;
import java.util.*;


public class Main {
	static int ans = 0;
	static int[][] arr;
	static int N;
	static boolean[] visited = new boolean[9];
	static int[] players = new int[9];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		players[3] = 0;
		visited[3] = true;
		find(1);
		System.out.print(ans);
	}
	
	static void find(int idx) {
		if(idx == 9) {
			ans = Math.max(playGame(), ans);
		}
		
		for(int i=0;i<9;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			players[i] = idx;
			find(idx+1);
			visited[i] = false;
		}
	}
	
	static int playGame() {
		int start = 0;
		int score = 0;
		for(int i=0;i<N;i++) {
			int[] base = {0,0,0,0,0};
			
			while(base[0] < 3) {
				run(base, arr[i][players[start]]);
				start = (start+1) % 9;
			}
			
			score += base[4];
		}
		
		return score;
	}
	
	static void run(int[] base, int n) {
		for(int i=0;i<n;i++) {
			base[4] += base[3];
			base[3] = base[2];
			base[2]= base[1];
			base[1] = 0;
		}
		
		base[n]++;
	}
}
