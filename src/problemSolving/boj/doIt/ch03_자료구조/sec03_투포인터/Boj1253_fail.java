package problemSolving.boj.doIt.ch03_자료구조.sec03_투포인터;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1253_fail {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-3. 좋다 문제(boj.1253)
	 * 실패 케이스(구현 방법 1,2,3) : 시간복잡도 O(n^2)
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		//[입력 받기]
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		/*
		 * 구현 방법1. 제출 결과 시간초과
		 * 시간 복잡도 O(n^2)
		 */
		//중복을 허용하고, indexOf() 메서드가 있는 ArrayList 사용
//		List<Long> list = new ArrayList<>(n); //크기 n
//		for(int i = 0; i < n; i++) {
//			list.add(scan.nextLong());
//		}
//		
//		//발견한 좋은 수 체크할 배열
//		//N개의 수 중 동일한 수가 있어도 서로 다른 수로 판단하므로, 각각 좋은 수인지 확인하기 위해 사용
//		boolean[] visit = new boolean[n]; 
//		
//		Collections.sort(list); //오름차순 정렬
//		int cnt = 0;
//		//두 개의 포인터를 사용하여 좋은 수 탐색
//		for(int i = 0; i < n; i++) { //포인터 i
//			for(int j = 0; j < n; j++) { //포인터 j
//				if(i == j) {
//					continue;
//				}
//				long sum = list.get(i) + list.get(j);
//				
//				//두 수의 합이 list에 있는 값이면 좋은 수임!
//				//문제점! n개의 수 중 동일한 수가 있으면 같은 인덱스 값을 반환하여 좋은 수 갯수에 포함이 안됨
//				int idx = list.indexOf(sum);
//				if(idx > -1 && visit[idx] == false) {
//					visit[idx] = true;
//					cnt++;
//				}
//			}
//		}
	
		
		/*
		 * 구현 방법2. 구현 방법1의 문제점 보완
		 * boolean 배열과 indexOf 메서드 대신 HashMap을 활용
		 * 제출 결과 틀림
		 * 시간 복잡도 O(n^2)
		 */
		//boolean[] 대신 HashMap을 사용
		Map<Long,Integer> map = new HashMap<>(n);
		long[] list = new long[n]; //크기 n
		for(int i = 0; i < n; i++) {
			Long num = scan.nextLong();
			list[i] = num;
			//n개의 수 중 동일한 수의 갯수를 카운팅해서 map의 value로 사용
			int cnt = map.getOrDefault(num, 0);
			map.put(num, ++cnt);
		}
		
		Arrays.sort(list); //오름차순 정렬
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				long sum = list[i] + list[j];
				if(map.containsKey(sum) && map.get(sum) > 0) {
					int val = map.get(sum);
					map.put(sum, --val);
					cnt++;
				}
			}
		}
		
	
		/*
		 * 구현 방법3. 제출 결과 틀림
		 * 투 포인터 초기화 로직 개선 필요
		 * 시간복잡도 O(n^2)
		 */
//		long[] list = new long[n]; //크기 n
//		for(int i = 0; i < n; i++) {
//			list[i] = scan.nextLong();
//		}
//		
//		Arrays.sort(list); //오름차순 정렬
//		int cnt = 0;
//		int s = 0;
//		int e = n - 2;
//		for(int i = n - 1; i > 0; i--) {
//			while(s < e) {
//				long sum = list[s] + list[e];
//				if(list[i] == sum) {
//					e--;
//					cnt++;
//					break;
//				}else if(list[i] < sum) {
//					e--;
//				}else {
//					s++;
//				}
//			}
//			if(i > 0) {
//				s = 0;
//				e = i - 1;
//			}
//			
//		}
		
	}

}
