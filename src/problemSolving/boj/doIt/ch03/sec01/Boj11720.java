package problemSolving.boj.doIt.ch03;

import java.util.Scanner;

public class Boj11720 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-1. 숫자의 합 문제(boj.11720)
	 * 시간복잡도 O(n)
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //입력 받기 위해 Scanner 클래스 사용
		
		/*
		 * 입력 받기
		 * int n : 1번째 입력값 n(숫자 개수)
		 * String sNums : 2번째 입력값 n개의 숫자나열(공백x)
		 */
		
		//입력 방법1 : 교재 답안
//		int n = scan.nextInt();
//		String sNums = scan.next();
		
		//입력 방법2
		int n = Integer.parseInt(scan.nextLine());
		String sNums = scan.nextLine();	
		
		//입력 방법3
//		int n = scan.nextInt();
//		scan.nextLine(); //nextInt()에서 처리안된 개행문자 처리
//		String sNums = scan.nextLine();	

		int sum = 0; //합을 계산할 변수
		
		/*
		 * 문제 해결 위한 로직 구현
		 * 시간복잡도 O(n)
		 */
		
		//구현 방법1 : 제일 처음 생각, 배열 설명 후 나온 문제여서 배열을 사용해야만 한다고 생각해서 나온 로직	
//		int[] iNums = new int[n]; //2번째 입력값들을 하나씩 자르고 형 변환하여 넣을 int형 배열
//		for(int i = 0; i < iNums.length; i++) {
//			iNums[i] = sNums.charAt(i) - '0';
//		}
//		for(int j = 0; j < iNums.length; j++) {
//			sum += iNums[j];
//		}
		
		//구현 방법2 : 1보다 효율적, but 배열 사용x
		for(int i = 0; i < n; i++) {
			sum += sNums.charAt(i) - '0';
		}
		
		//구현 방법3 : 구현 방법2와 동일하지만 형 변환을 다르게
//		for(int i = 0; i < n; i++) {
//			sum += Integer.parseInt(sNums.substring(i, i+1));
//		}		
		
		//구현 방법4 : 교재 답안
//		char[] cNums = sNums.toCharArray();
//		for(int i = 0; i< cNums.length; i++) {
//			sum += cNums[i] - 48;
//		}
		
		System.out.println(sum); //결과 출력		
	}

}
