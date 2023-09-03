package problemSolving.boj.doIt.ch03_자료구조.sec03_투포인터;

import java.util.Scanner;

public class Boj2018 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-3. 수들의 합 5 문제(boj.2018)
	 * 시간복잡도 O(n)
	 */

	public static void main(String[] args) {
		//[입력받기]
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		/*
		 * 구현 방법1 - 내가 작성한 풀이
		 * 시간복잡도 O(n)보다 작음
		 */
//		//[구간 합 배열 계산]
//		int length = (int)Math.ceil(n/2.0);
//		int[] s = new int[length]; //올림
//		s[0] = 1;
//		for(int i = 1; i < length; i++) {
//			s[i] = s[i-1] + (i+1); 
//		}
//		
//		int i = 0;
//		int j = 0;
//		int cnt = 1;
//		while(n > 1 && j < length) { //n이 1일때는 계산 제외(자기 자신 밖에 없다, cnt가 1)
//			int sum = i > 0 ? s[j] - s[i-1] : s[j];
//			if(sum < n) {
//				j++;
//			}else if(sum == n) {
//				cnt++;
//				i++;
//				j++;
//			}else {
//				i++;
//			}
//		}
		
		/*
		 * 구현 방법2 - 교재 답안
		 * 시간복잡도 O(n)
		 */
		//연속된 자연수의 합을 구하기때문에 굳이 배열을 사용할 필요없음
		int start_index = 1;
		int end_index = 1;
		int sum = 1; //자연수 1의 최솟값은 1, 1부터1까지의 합 1이 sum의 초기값
		int cnt = 1; //자기 자신(n = n)이 무조건 포함되므로 초기값 1
		while(end_index != n) {
			if(sum == n) { //현재 연속 합이 N과 같은 경우
				cnt++;
				end_index++;
				sum += end_index;
			}
			else if(sum > n) { //현재 연속 합이 N보다 더 큰 경우
				sum -= start_index;
				start_index++;
			}
			else { //현재 연속 합이 N보다 작은 경우
				end_index++;
				sum += end_index;
			}
		}
		
		//[결과 출력]
		System.out.println(cnt);
	}
}
