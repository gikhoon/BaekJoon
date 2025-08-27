import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

class Bug {
	int dir;   // 1:상, 2:하, 3:좌, 4:우
	int size;

	public Bug(int dir, int size) {
		this.dir = dir;
		this.size = size;
	}
}

class N {
	int r, c;

	public N(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(r, c);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof N))
			return false;
		N n = (N)obj;
		return r == n.r && c == n.c;
	}
}

public class Solution {
	static Bug[][] map;
	static int[] dr = {0, -1, 1, 0, 0}; // 0, 상, 하, 좌, 우
	static int[] dc = {0, 0, 0, -1, 1};
	static int[] REV = {0, 2, 1, 4, 3}; // 반대 방향 매핑

	static class Cell {
		int total;
		int max;
		int dir;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int Nsize = Integer.parseInt(st.nextToken()); // 격자 크기 N
			int M = Integer.parseInt(st.nextToken());     // 시간
			int K = Integer.parseInt(st.nextToken());     // 군집 수

			map = new Bug[Nsize][Nsize];
			List<N> list = new ArrayList<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[r][c] = new Bug(dir, count);
				list.add(new N(r, c));
			}

			// 시뮬레이션 M번
			for (int step = 0; step < M; step++) {
				Cell[][] acc = new Cell[Nsize][Nsize];
				boolean[][] touched = new boolean[Nsize][Nsize];
				List<N> newList = new ArrayList<>();

				for (N cur : list) {
					Bug bug = map[cur.r][cur.c]; // 존재 보장
					int nr = cur.r + dr[bug.dir];
					int nc = cur.c + dc[bug.dir];

					// 가장자리 도달 시 방향 반전 + 절반 감소
					if (nr == 0 || nr == Nsize - 1 || nc == 0 || nc == Nsize - 1) {
						bug.dir = REV[bug.dir];
						bug.size /= 2;
						if (bug.size == 0)
							continue; // 소멸
					}

					if (acc[nr][nc] == null)
						acc[nr][nc] = new Cell();
					Cell cell = acc[nr][nc];

					// 총합 누적
					cell.total += bug.size;

					// 개별 최댓값 기준으로 방향 선택
					if (bug.size > cell.max) {
						cell.max = bug.size;
						cell.dir = bug.dir;
					}

					// 위치 목록(중복 방지)
					if (!touched[nr][nc]) {
						touched[nr][nc] = true;
						newList.add(new N(nr, nc));
					}
				}

				map = new Bug[Nsize][Nsize];
				for (N p : newList) {
					Cell cell = acc[p.r][p.c];
					map[p.r][p.c] = new Bug(cell.dir, cell.total);
				}
				list = newList;
			}

			int answer = 0;
			for (N p : list) {
				answer += map[p.r][p.c].size;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
