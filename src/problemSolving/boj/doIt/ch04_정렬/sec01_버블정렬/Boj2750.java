package problemSolving.boj.doIt.ch04;

import java.util.Scanner;
import java.util.LinkedList;

public class Boj2750 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch04-1. 수 정렬하기 문제(boj.2750)
	 * 성공 케이스(구현 방법 1,2) : 시간복잡도 O(n^2)
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		/*
		 * 구현 방법1. 내가 작성한 풀이
		 */		
//		LinkedList<Integer> list = new LinkedList<>();
//		for(int i = 0; i < N; i++) {
//			list.add(scan.nextInt());
//		}
//		
//		for(int l = 0; N-l > 1; l++) {
//			boolean swapYn = false;
//			for(int i = 0; i + 1 < N-l; i++) {
//				if(list.get(i) > list.get(i+1)) {
//					int temp = list.get(i);
//					list.remove(i);
//					list.add(i+1, temp);
//					
//					swapYn = true;
//				}
//			}
//			if(!swapYn) break;
//		}
//		
//		for(Integer num : list) {
//			System.out.println(num);
//		}
		
		/*
		 * 구현 방법2. 교재 풀이
		 */		
		int[] A = new int[N]; //자료구조로 배열을 사용
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		for(int i = 0; i < N - 1; i++) { //반복 횟수(회차)
			for(int j = 0; j < N - 1 - i; j++) { //인덱스 반복
				if(A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(A[i]);
		}

		scan.close();		
	}

}
