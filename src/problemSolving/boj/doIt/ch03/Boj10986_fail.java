package problemSolving.boj.doIt.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj10986_fail {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-2. 나머지 합 문제(boj.10986)
	 * 시간 초과 실패 케이스(구현 방법1,2) : 시간복잡도 O(n^2)
	 * 내가 작성한 풀이
	 */

	public static void main(String[] args) throws IOException{
		//[입력받기]
		//입력 개수가 많아 Scanner 대신 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//숫자 입력 받기 & 구간 합 계산하기
		//계산 편의 위해 배열 크기를 n+1로 생성
		long[] a = new long[n+1]; //원본 숫자 배열
		long[] d = new long[n+1]; //구간 합 배열
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++){
			a[i] = Integer.parseInt(st.nextToken());
			d[i] = d[i-1] + a[i];
		}
		
		/*
		 * 구현 방법1. 최초 생각. 시간 초과로 실패
		 * 사용자 정의 타입(Index 클래스)을 사용
		 * But 순서쌍 값 자체는 필요없고 갯수만 구하면 됨
		 */
		
		//인덱스 정보 구하기
//		List<Index> result = new ArrayList<>();
//		for(int i = 1; i <= n; i++) {
//			for(int j = i; j <= n; j++) {
//				if((d[j]-d[i-1]) % m == 0) {
//					//인덱스 쌍(i,j)값을 담기 위한 클래스 정의하여 사용
//					Index idx = new Index(i,j);
//					result.add(idx);
//				}
//			}
//		}
//		//[결과 출력]
//		System.out.println(result.size());
		
		/*
		 * 구현 방법2. 시간 초과로 실패
		 * (i,j) 순서쌍 값 자체는 필요없기때문에
		 * 인덱스 정보를 저장안하고 if 만족하는 횟수 카운트만 함
		 */
		//인덱스 정보 구하기
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j++) {
				if((d[j]-d[i-1]) % m == 0) {
					cnt++;
				}
			}
		}
		//[결과 출력]
		System.out.println(cnt);		
	}

}

class Index {
	private int sIdx; //시작 인덱스 i
	private int eIdx; //끝 인덱스 j
	
	public Index(int sIdx, int eIdx) {
		super();
		this.sIdx = sIdx;
		this.eIdx = eIdx;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public int geteIdx() {
		return eIdx;
	}

	public void seteIdx(int eIdx) {
		this.eIdx = eIdx;
	}
}
