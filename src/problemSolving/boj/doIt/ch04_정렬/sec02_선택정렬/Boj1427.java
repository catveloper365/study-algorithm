package problemSolving.boj.doIt.ch04;

import java.util.Scanner;

public class Boj1427 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch04-2. 소트인사이드 문제(boj.1427)
	 * 성공 케이스(구현 방법 1, 2) : 시간복잡도 O(n^2)
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String N = scan.nextLine();
		
		/*
		 * 구현 방법1. 내가 작성한 풀이
		 */		
		char[] cArr = N.toCharArray();
		for(int i = 0; i < cArr.length; i++) {
			int max = 0;
			for(int j = i; j < cArr.length; j++) {
				if(max < (cArr[j] - 48)) {
					max = cArr[j] - 48;
					
					//swap
					char temp = cArr[i];
					cArr[i] = cArr[j];
					cArr[j] = temp;
				}
			}
		}
		System.out.println(Integer.parseInt(String.valueOf(cArr)));

		/*
		 * 구현 방법2. 교재 풀이
		 */
		//입력받은 String 값을 int형 배열로 잘라서 넣기
//		int[] A = new int[N.length()];
//		for(int i = 0; i < N.length(); i++) {
//			A[i] = Integer.parseInt(N.substring(i, i+1));
//		}
//		
//		//선택 정렬
//		for(int i = 0; i < N.length(); i++) {
//			int max = i;
//			for(int j = i + 1; j < N.length(); j++) {
//				if(A[j] > A[max]) { //내림차순이므로 최댓값을 찾음
//					max = j;
//				}
//			}
//			if(A[i] < A[max]) {
//				int temp = A[i];
//				A[i] = A[max];
//				A[max] = temp;
//			}
//		}
//		
//		//출력
//		for(int i = 0; i < N.length(); i++) {
//			System.out.print(A[i]);
//		}
		
		scan.close();
	}
}
