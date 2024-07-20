import java.io.*;
import java.util.*;
class Main {
	static int N, M;
	static int[] house;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new int[N +1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M/3;i++){
			int[] addList = new int[N+1];
			for(int j=0;j<3;j++){
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for(int h=start;h<=end;h++){
					addList[h]++;
				}
			}
			for(int h=1;h<=N;h++){
				if(addList[h]!=0){
					house[h] += (addList[h]-1);
				}
			}
		}
		
		for(int i=(M/3)*3;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for(int h=start;h<=end;h++){
					house[h]++;
				}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++){
			sb.append(house[i] + " ");
		}
		
		System.out.println(sb);
	}
}