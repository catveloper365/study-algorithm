package problemSolving.boj.doIt.ch03;

import java.util.Scanner;

public class Boj2018 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-3. 수들의 합 5 문제(boj.2018)
	 */

	public static void main(String[] args) {
		/*
		 * 구현 방법1 - 내가 작성한 풀이
		 * 시간복잡도 O(n)보다 작음
		 */
		//[입력받기]
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		//[구간 합 배열 계산]
		int length = (int)Math.ceil(n/2.0);
		int[] s = new int[length]; //올림
		s[0] = 1;
		for(int i = 1; i < length; i++) {
			s[i] = s[i-1] + (i+1); 
		}
		
		int i = 0;
		int j = 0;
		int cnt = 1;
		while(n > 1 && j < length) { //n이 1일때는 계산 제외(자기 자신 밖에 없다, cnt가 1)
			int sum = i > 0 ? s[j] - s[i-1] : s[j];
			if(sum < n) {
				j++;
			}else if(sum == n) {
				cnt++;
				i++;
				j++;
			}else {
				i++;
			}
		}
		System.out.println(cnt);
	}
}
