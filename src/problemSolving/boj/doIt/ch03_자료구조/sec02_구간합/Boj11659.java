package problemSolving.boj.doIt.ch03_자료구조.sec02_구간합;

import java.io.IOException;
import java.util.Scanner;

public class Boj11659 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-2. 구간 합 구하기 4 문제(boj.11659)
	 * 시간복잡도 O(n)
	 */

	public static void main(String[] args) throws IOException{

		/*
		 * 구현 방법1 - 내가 작성한 풀이
		 * n,m,숫자를 
		 * > case1. scan.nextInt()로 받았을 때는 시간초과
		 * > case2. Integer.parseInt(scan.next())로는 통과
		 */
//		//[입력 받기]
//		Scanner scan = new Scanner(System.in);
//		//nextInt()보다 next()로 String값을 받은 다음 Integer.parseInt()로 형 변환하는게 근소하게 더 빠름
//		int n = Integer.parseInt(scan.next()); //수의 개수 n
//		int m = Integer.parseInt(scan.next()); //구해야하는 구간 합의 개수 m
//		
//		//입력받은 수를 하나씩 저장할 int형 배열 nums 생성, 계산 편의를 위해 n+1 크기로 생성
//		int[] nums = new int[n+1];
//		//구간 합을 계산할 int형 배열 sums 생성, nums의 길이와 동일하게 생성
//		int[] sums = new int[nums.length];
//
//		//[문제 해결 위한 구간 합 구하기]
//		//입력받은 수 n개를 차례대로 nums에 저장 & 구간 합 계산, 이때 index는 1부터 사용
//		for(int i = 1; i < nums.length; i++) { //최대 n만큼 반복
//			nums[i] = Integer.parseInt(scan.next());
//			sums[i] = sums[i-1] + nums[i];
//		}
//		
//		scan.nextLine(); //남아있는 개행 문자 날리기
//		
//		String[] ranges = new String[m]; //구간을 입력받을 배열 생성
//		for(int j = 0; j < ranges.length; j++) { //최대 구간 입력 배열 길이(m)만큼 반복
//			ranges[j] = scan.nextLine();
//		}
//
//		//[구간 합 계산하여 결과 출력]
//		for(int k = 0; k < ranges.length; k++) { //최대 m만큼 반복
//			String[] range = ranges[k].split(" ");
//			System.out.println(sums[Integer.parseInt(range[1])] - sums[Integer.parseInt(range[0])-1]);
//		}
		
		/*
		 * 구현 방법2 - 방법1 로직 정리(불필요한 로직 제거하여 반복문 줄임)
		 */
		//[입력 받기]
		Scanner scan = new Scanner(System.in);
		//nextInt()보다 next()로 String값을 받은 다음 Integer.parseInt()로 형 변환하는게 근소하게 더 빠름
		int n = Integer.parseInt(scan.next()); //수의 개수 n
		int m = Integer.parseInt(scan.next()); //구해야하는 구간 합의 개수 m
		
		//합 배열로 사용할 int형 배열 sums 생성, 계산 편의를 위해 n+1 크기로 생성
		int[] sums = new int[n+1];

		//[문제 해결 위한 구간 합 구하기]
		//sums[i-1]과 입력받은 수를 차례대로 합하여 합 배열 생성, 이때 index는 1부터 n까지 사용
		for(int i = 1; i <= n; i++) { //최대 n만큼 반복
			sums[i] = sums[i-1] + Integer.parseInt(scan.next());
		}

		//[구간 합 계산하여 결과 출력]
		for(int k = 0; k < m; k++) { //최대 m만큼 반복
			int i = Integer.parseInt(scan.next()); //구간 인덱스 i 입력 받기
			int j = Integer.parseInt(scan.next()); //구간 인덱스 j 입력 받기
			System.out.println(sums[j] - sums[i-1]);
		}		
		
		/*
		 * 구현 방법3 - 교재 답안(입력 더 빠른 BufferedReader 사용)
		 */
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//		int suNo = Integer.parseInt(stringTokenizer.nextToken());
//		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
//		long[] s = new long[suNo + 1];
//		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//		for(int i = 1; i <= suNo; i++) {
//			s[i] = s[i-1] + Integer.parseInt(stringTokenizer.nextToken());
//		}
//		for(int q = 0; q < quizNo; q++) {
//			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//			int i = Integer.parseInt(stringTokenizer.nextToken());
//			int j = Integer.parseInt(stringTokenizer.nextToken());
//			System.out.println(s[j] - s[i-1]);
//		}
		
	}

}
