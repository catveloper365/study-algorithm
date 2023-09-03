package problemSolving.boj.doIt.ch03_자료구조.sec02_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11660_fail {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-2. 구간 합 구하기 5 문제(boj.11660)
	 * 시간 초과 실패 케이스(구현 방법1,2) : 시간복잡도 O(mn)
	 */

	public static void main(String[] args) throws IOException {
		//[입력 받기]
		//입력 데이터가 많기 때문에 java.io.BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//표 크기(n), 합을 구해야하는 횟수(m) 각각 변수에 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//수를 담을 배열, 행 단위 합배열, 열 단위 합배열 선언
		int[][] nums = new int[n][n];
		int[][] rowSum = new int[n][n];
		int[][] colSum = new int[n][n];
		//수 입력받기
		for(int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < n; c++) {
				nums[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		//행 단위 합배열, 열 단위 합배열 계산
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(c > 0) {
					rowSum[r][c] = rowSum[r][c-1] + nums[r][c];
					colSum[c][r] = colSum[c-1][r] + nums[c][r];
				}else {
					rowSum[r][c] = nums[r][c];
					colSum[c][r] = nums[c][r];
				}
			}
		}
		
		//[구간 합 계산 및 출력]
		for(int idx = 0; idx < m; idx++) {
			//인덱스 정보 입력받기
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			/*
			 * 구현 방법1. 내가 작성한 풀이(최초 생각)
			 */
			//구간 합 계산하여 출력
//			if(y1 == y2) {
//				if(x1 == x2) {
//					System.out.println(nums[x1][y1]);
//				}else {
//					int i = Math.min(x1, x2);
//					int j = Math.max(x1, x2);
//					if(i == 0) {
//						System.out.println(colSum[j][y1]);
//					}else {
//						System.out.println(colSum[j][y1]-colSum[i-1][y1]);
//					}
//					
//				}
//			}else {
//				if(x1 == x2) {
//					int i = Math.min(y1, y2);
//					int j = Math.max(y1, y2);
//					if(i==0) {
//						System.out.println(rowSum[x1][j]);
//					}else {
//						System.out.println(rowSum[x1][j]-rowSum[x1][i-1]);
//					}
//					
//				}else {
//					int ri = Math.min(x1, x2);
//					int rj = Math.max(x1, x2);
//					int ci = Math.min(y1, y2);
//					int cj = Math.max(y1, y2);
//					long sum = 0;
//					for(int row = ri; row <= rj; row++) {
//						if(ci == 0) {
//							sum += rowSum[row][cj];
//						}
//						else {
//							sum += rowSum[row][cj] - rowSum[row][ci-1];
//						}
//					}
//					System.out.println(sum);
//				}
//			}
			/*
			 * 구현 방법2. 내가 작성한 풀이(방법1의 중복 코드 정리)
			 */
			long sum = 0; //구간 합 계산 결과 담을 변수 
			
			//구간 합 계산하여 출력
			if(y1 == y2) {
				if(x1 == x2) {
					sum = nums[x1][y1];
				}else {
					sum = oneEqualsSum(false, y1, x1, x2, colSum);					
				}
			}else {
				if(x1 == x2) {
					sum = oneEqualsSum(true, x1, y1, y2, rowSum);
				}else {
					int ri = Math.min(x1, x2);
					int rj = Math.max(x1, x2);
					for(int row = ri; row <= rj; row++) {
						sum += oneEqualsSum(true, row, y1, y2, rowSum);
					}
				}
			}
			
			System.out.println(sum);

		}

	}

	/**
	 * 행,열 둘 중에 하나가 같은 경우 구간 합 계산
	 * @param row 행이 같을 때 true
	 * @param equalIdx 서로 같은 인덱스 값 입력
	 * @param difIdx1 서로 다른 인덱스 값1 입력
	 * @param difIdx2 서로 다른 인덱스 값2 입력
	 * @param sumArr 행이 같을 때는 rowSum, 열이 같을 때는 colSum
	 * @return
	 */
	public static long oneEqualsSum(boolean row, int equalIdx, int difIdx1, int difIdx2, int[][] sumArr) {
		long result = 0;
		
		int i = Math.min(difIdx1, difIdx2);
		int j = Math.max(difIdx1, difIdx2);
		if(i == 0) {
			result = row? sumArr[equalIdx][j] : sumArr[j][equalIdx];
		}else {
			result = row? (sumArr[equalIdx][j]-sumArr[equalIdx][i-1]) : (sumArr[j][equalIdx]-sumArr[i-1][equalIdx]);
		}
				
		return result;
	}

}
