package problemSolving.boj.doIt.ch03_자료구조.sec03_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1940 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-3. 주몽 문제(boj.1940)
	 * 성공 케이스(구현 방법 2,3) : 시간복잡도 O(n)
	 * 실패 케이스(구현 방법 1) : 시간복잡도 O(n^2) 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //재료 갯수
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); //갑옷 생성 조건
		
		/*
		 * 구현 방법1. 최초 생각 (시간초과로 실패)
		 * 시간복잡도 O(n^2)
		 */
//		//재료 고유번호 입력받기
//		List<Integer> list = new LinkedList<>();
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < n; i++) {
//			list.add(Integer.parseInt(st.nextToken()));
//		}
//		
//		int cnt = 0; //만들 수 있는 갑옷의 갯수
//		if(n < 2) { //재료 갯수 확인
//			System.out.println(cnt);
//		}else {
//			Collections.sort(list); //오름차순 정렬
//			
//			int i = 0; //시작 인덱스
//			int j = list.size() - 1; //종료 인덱스
//			while(i < j && list.size() > 0) {
//				int sum = (int)list.get(i) + (int)list.get(j);
//				if(sum == m) {
//					cnt++;
//					list.remove(j); //j를 먼저 빼야함
//					list.remove(i);
//					//인덱스 초기화
//					i = 0;
//					j = list.size() - 1;
//				}else if(sum < m) {
//					i++;
//				}else {
//					j--;
//				}
//			}
//			System.out.println(cnt);
//		}
		
		/*
		 * 구현 방법2. 배열 사용, sum==m일때 인덱스 초기화 안함
		 * 시간복잡도 O(n)
		 */
//		//재료 고유 번호 입력받기
//		int[] nums = new int[n];
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < n; i++) {
//			nums[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int cnt = 0; //만들 수 있는 갑옷의 갯수
//		Arrays.sort(nums); //오름차순 정렬
//		
//		int i = 0; //시작 인덱스
//		int j = n - 1; //종료 인덱스
//		while(i < j) {
//			int sum = nums[i] + nums[j];
//			if(sum == m) {
//				cnt++;
//				i++;
//				j--;
//			}else if(sum < m) {
//				i++;
//			}else {
//				j--;
//			}
//		}
//		System.out.println(cnt);
		
		/*
		 * 구현 방법3. 교재 답안
		 * 시간복잡도 O(n)
		 */
		//재료의 고유 번호를 배열에 저장
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a); //재료 배열 정렬
		int i = 0;
		int j = n - 1;
		int cnt = 0;
		while(i < j) { //투 포인터 이동 원칙 따라 포인터를 이동하며 처리
			int sum = a[i] + a[j];
			if(sum < m) {
				i++;
			}else if(sum > m) {
				j--;
			}else {
				cnt++;
				i++;
				j--;
			}
		}
		System.out.println(cnt);
		br.close(); //자원 해제
	}

}
