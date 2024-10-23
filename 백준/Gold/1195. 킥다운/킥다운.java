import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] A;
	static boolean[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("");
		A = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals("2")) {
				A[i] = true;
			}
		}

		a = br.readLine().split("");
		B = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals("2")) {
				B[i] = true;
			}
		}

		int min = A.length + B.length;
		for (int i = 0; i < B.length; i++) {
			if(!isCombinable(i, A, B)) continue;
			min = Math.min(min, Math.max(A.length + i, B.length));
		}

		for (int i = 0; i < A.length; i++) {
			if(!isCombinable(i, B, A)) continue;
			min = Math.min(min, Math.max(B.length + i, A.length));
		}

		System.out.println(min);
	}

	private static boolean isCombinable(int idx, boolean[] movePart, boolean[] staticPart) {
		for(int i=0;i<Math.min(movePart.length, staticPart.length -  idx);i++) {
			if (movePart[i] && staticPart[i + idx]) {
				return false;
			}
		}
		return true;
	}
}