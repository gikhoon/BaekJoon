import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] preorder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			int[] inorder = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				preorder[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inorder[j] = Integer.parseInt(st.nextToken());
			}

			postorder(0, 0, N - 1, inorder);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void postorder(int preStart, int inStart, int inEnd, int[] inorder) {
		if (inStart > inEnd) {
			return;
		}

		int root = preorder[preStart];
		int rootIndex = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root) {
				rootIndex = i;
				break;
			}
		}

		int leftSize = rootIndex - inStart;

		// 왼쪽 서브트리
		postorder(preStart + 1, inStart, rootIndex - 1, inorder);
		// 오른쪽 서브트리
		postorder(preStart + 1 + leftSize, rootIndex + 1, inEnd, inorder);

		sb.append(root).append(" ");
	}
}
