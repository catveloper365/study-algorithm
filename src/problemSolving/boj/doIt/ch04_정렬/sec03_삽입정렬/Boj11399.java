package problemSolving.boj.doIt.ch04_정렬.sec03_삽입정렬;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class Boj11399 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch04-3. ATM 문제(boj.11399)
	 * 성공 케이스(구현 방법 1, 2) : 시간복잡도 O(n^2)
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		 * 구현 방법1. 내가 작성한 풀이
		 */
//		int N = Integer.parseInt(scan.nextLine());
//		LinkedList<Integer> list = new LinkedList<>();
//		for(int i = 0; i < N; i++) {
//			list.add(Integer.parseInt(scan.next()));
//		}
//		
//		//삽입정렬로 오름차순 정렬 O(n^2)
//		for(int i = 1; i < N; i++) {
//			for(int j = 0; j <= i-1; j++) {
//				if(list.get(j) > list.get(i)) {
//					int temp = list.get(i);
//					list.remove(i);
//					list.add(j, temp);
//					break;
//				}
//			}
//		}
//		
//		//합 배열 구하기
//		int[] sArr = new int[N];
//		sArr[0] = list.get(0);
//		for(int i = 1; i < N; i++) {
//			sArr[i] = sArr[i-1] + list.get(i);
//		}
//		
//		//결과 계산
//		int result = 0;
//		for(int num : sArr) {
//			result += num;
//		}
//		System.out.println(result);
		
		/*
		 * 구현 방법2. 교재 풀이
		 */
		//입력 & 필요한 자료구조 생성
		int N = scan.nextInt();
		int[] A = new int[N];
		int[] S = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		//삽입 정렬 O(n^2)
		for(int i = 1; i < N; i++) {
			int insert_point = i;
			int insert_value = A[i];
			for(int j = i - 1; j >= 0; j--) { //삽입 위치 탐색
				if(A[j] < A[i]) {
					insert_point = j + 1;
					break;
				}
				if(j == 0) {
					insert_point = 0;
				}
			}
			for(int j = i; j > insert_point; j--) {
				A[j] = A[j-1];
			}
			A[insert_point] = insert_value; //삽입
		}
		
		//합 배열 만들기
		S[0] = A[0];
		for(int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];
		}
		
		//합 배열 총합 구하기
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += S[i];
		}
		System.out.println(sum);
		
		scan.close();
	}
}
