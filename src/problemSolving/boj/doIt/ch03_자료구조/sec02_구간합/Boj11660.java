package problemSolving.boj.doIt.ch03_자료구조.sec02_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-2. 구간 합 구하기 5 문제(boj.11660)
	 * 성공 케이스(구현 방법 3,4) : 시간복잡도 O(n^2)
	 */

	public static void main(String[] args) throws IOException{
		//[입력 받기]
		//입력 데이터가 많기 때문에 java.io.BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//표 크기(n), 합을 구해야하는 횟수(m) 각각 변수에 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		/*
		 * 구현 방법3. 내가 작성한 풀이(교재에서 구간 합 배열 정의 학습 후)
		 * 배열을 n*n으로 생성한 이유는 n이 꽤 크기때문에 메모리 낭비를 줄이고자 했음
		 * + 그만큼 더 반복해야되니까 시간도 더 걸린다고 생각
		 */
//		//수를 담을 배열 nums, 구간 합 배열 sums 선언
//		int[][] nums = new int[n][n];
//		int[][] sums = new int[n][n];
//		//수 입력받기, 구간 합 배열 계산
//		for(int r = 0; r < n; r++) {
//			st = new StringTokenizer(br.readLine());
//			for(int c = 0; c < n; c++) {
//				nums[r][c] = Integer.parseInt(st.nextToken());
//				
//				if(r == 0 && c == 0) {
//					sums[r][c] = nums[r][c];
//				}else if(r == 0) {
//					sums[r][c] = sums[r][c-1] + nums[r][c];
//				}else if(c == 0) {
//					sums[r][c] = sums[r-1][c] + nums[r][c];
//				}else {
//					sums[r][c] = sums[r-1][c] + sums[r][c-1] - sums[r-1][c-1] + nums[r][c];
//				}
//			}
//		}
////		System.out.println("nums : " + Arrays.deepToString(nums));
////		System.out.println("sums : " + Arrays.deepToString(sums));
//		
//		//[구간 합 계산 및 출력]
//		for(int idx = 0; idx < m; idx++) {
//			//인덱스 정보 입력받기
//			st = new StringTokenizer(br.readLine());
//			//배열 인덱스와 맞추기 위해 1씩 빼주기
//			int x1 = Integer.parseInt(st.nextToken()) - 1;
//			int y1 = Integer.parseInt(st.nextToken()) - 1;
//			int x2 = Integer.parseInt(st.nextToken()) - 1;
//			int y2 = Integer.parseInt(st.nextToken()) - 1;
//			
//			long sum = 0; //구간 합 계산 결과 담을 변수 
//			
//			//구간 합 계산
//			if(x1 == x2 && y1 == y2) {
//				sum = nums[x1][y1];
//			}else if(x1 == 0 && y1 == 0) {
//				sum = sums[x2][y2];
//			}else if(x1 == 0) {
//				sum = sums[x2][y2] - sums[x2][y1-1];
//			}else if(y1 == 0) {
//				sum = sums[x2][y2] - sums[x1-1][y2];
//			}else {
//				sum = sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1];
//			}
//			
//			System.out.println(sum);
//		} //end for
		
		/*
		 * 구현 방법4. 교재 답안
		 */
		//수를 담을 배열 a 선언, 계산 편의 위해 n+1*n+1 크기로 생성
		int[][] a = new int[n + 1][n + 1]; 
		//원본 배열 저장 O(n^2)
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구간 합 배열 d 선언, 계산 편의 위해 n+1*n+1 크기로 생성
		int[][] d = new int[n + 1][n + 1]; //int형이므로 0으로 초기화됨
		//구간 합 배열 저장 O(n^2)
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				//구간 합 구하기
				//배열을 n+1*n+1크기로 생성하고 인덱스를 1부터 시작해 i-1, j-1 부분도 해결됨
				d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + a[i][j];
			}
		}
		//구간 합 배열을 통해 질의 계산 및 출력 O(m)
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			//배열을 n+1*n+1 크기로 생성하고 인덱스 1부터 사용하기때문에 -1을 해줄 필요가 없음
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			//구간 합 배열로 질의에 답변하기
			int result = d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1];
			System.out.println(result);
		}

	}


}
