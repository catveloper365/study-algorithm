package problemSolving.boj.doIt.ch04_정렬.sec01_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1377 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch04-1. 버블 소트 문제(boj.1377)
	 * 실패 케이스(구현 방법 1) : 시간복잡도 O(n)
	 * 성공 케이스(구현 방법 2) : 시간복잡도 O(nlogn)
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		/*
		 * 구현 방법1. 내가 작성한 풀이(실패)
		 */
//		int[] A = new int[N];
//		int cnt = 0;
//		int minIdx = 0;
//		boolean minSwap = false;
//		
//		for(int i = 0; i < N; i++) {
//			A[i] = Integer.parseInt(br.readLine());
//			if(i > 0) {
//				if(A[minIdx] > A[i]) {
//					minIdx = i;
//				}
//				if(A[i-1] > A[i]) {
//					cnt++;
//					if(i == 1) {
//						minSwap = true;
//					}
//				}
//			}
//		}
//		
//		if(cnt < N-1) {
//			cnt++;
//			if(cnt > 1) { //swap이 발생하고
//				if(minIdx > 0) { //minIdx가 0이 아님
//					if(minIdx == 1) {
//						if(!minSwap) cnt++;
//					}else {
//						cnt++;
//					}
//				}
//			}			
//		}
//		
//		System.out.println(cnt);
		
		/*
		 * 구현 방법2. 교재 풀이
		 */
		mData[] A = new mData[N];
		for(int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()),i);
		}
		Arrays.sort(A); //A배열 정렬 O(nlogn)
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < A[i].index - i) { //정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
				max = A[i].index - i;
			}
		}
		System.out.println(max + 1);
		
		br.close();
	}
}

class mData implements Comparable<mData>{
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o) { //value 기준 오름차순 정렬하기
		return this.value - o.value;
	}
}
