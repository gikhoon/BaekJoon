/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(); // 흰 종이
            int x3 = sc.nextInt(), y3 = sc.nextInt(), x4 = sc.nextInt(), y4 = sc.nextInt(); // 검은 종이 1
            int x5 = sc.nextInt(), y5 = sc.nextInt(), x6 = sc.nextInt(), y6 = sc.nextInt(); // 검은 종이 2
            
            long whiteSize = (long) (x2 - x1) * (y2 - y1);
            
            long a1 = areaSize(x1,y1,x2,y2, x3, y3, x4, y4);
            long a2 = areaSize(x1,y1,x2,y2, x5, y5, x6, y6);
            
            // 검은 종이 1과 검은 종이 2의 교집합을 먼저 구하고
            int overlapX1 = Math.max(x3, x5);
            int overlapY1 = Math.max(y3, y5);
            int overlapX2 = Math.min(x4, x6);
            int overlapY2 = Math.min(y4, y6);

            // 교집합이 실제 존재할 때만
            long a3 = 0;
            if (overlapX1 < overlapX2 && overlapY1 < overlapY2) {
                // 그 교집합과 흰 종이의 교집합 면적을 다시 구함
                a3 = areaSize(x1, y1, x2, y2, overlapX1, overlapY1, overlapX2, overlapY2);
            }
            
           if((a1+a2-a3) < whiteSize) {
               System.out.println("YES");
           } else {
               System.out.println("NO");
           }
           
		}
	}
    
private static long areaSize(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
    int left = Math.max(x1, x3);
    int right = Math.min(x2, x4);
    int bottom = Math.max(y1, y3);
    int top = Math.min(y2, y4);
    
    if (left >= right || bottom >= top) {
        return 0L;
    }
    return (long)(right - left) * (top - bottom);
}

    
}