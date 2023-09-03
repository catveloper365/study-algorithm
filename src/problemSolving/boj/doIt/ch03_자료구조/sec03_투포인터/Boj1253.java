package problemSolving.boj.doIt.ch03_자료구조.sec03_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj1253 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-3. 좋다 문제(boj.1253)
	 * 성공 케이스(구현 방법 4,5,6) : 시간복잡도 O(n^2)
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 구현 방법4. 교재 슈도코드 보고 직접 작성
		 */
//		//[입력 받기]
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt(); //수의 갯수
//
//		long[] a = new long[n]; //n개의 수
//		for(int i = 0; i < n; i++) {
//			a[i] = scan.nextLong();
//		}
//		
//		//[좋은 수 갯수 계산]
//		Arrays.sort(a); //정렬 O(nlogn)
//		int cnt = 0; //좋은 수의 갯수
//		for(int k = 0; k < n; k++) {
//			long find = a[k]; //찾는 값
//			int i = 0;
//			//배열의 길이가 n으로 명확하기 때문에, a.length를 통해 배열 길이를 구하는 것보다 n을 바로 사용하는 것이 더 빠름
//			int j = n - 1;
//			while(i < j) {
//				if(a[i] + a[j] == find) {
//					if(i == k) {
//						i++;
//					}else if(j == k) {
//						j--;
//					}else {
//						//i != k && j != k일 때
//						cnt++;
//						break;
//					}
//				}else if(a[i] + a[j] < find) {
//					i++;
//				}else {
//					j--;
//				}
//			}
//		}
//		
//		//[결과 출력]
//		System.out.println(cnt);	
//		scan.close();
		
		/*
		 * 구현 방법5. 교재 답안
		 */
		//[입력 받기]
		//Scanner보다 BufferedReader를 사용했을 때 속도가 더 빠름
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); //수의 개수
		int Result = 0; //좋은 수의 갯수
		long A[] = new long[N]; //N개의 수
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		//[좋은 수의 갯수 계산]
		Arrays.sort(A);
		for(int k = 0; k < N; k++) {
			//찾는 값, A[i]+A[j]가 find와 같으면 find는 좋은 수임
			long find = A[k]; 
			int i = 0;
			int j = N - 1;
			//투 포인터 알고리즘
			while(i < j) {
				if(A[i] + A[j] == find) {
					//find는 서로 다른 두 수의 합이어야 함을 체크
					if(i != k && j != k) {
						Result++;
						break;
					}else if(i == k) {
						i++;
					}else if(j == k) {
						j--;
					}
				}else if(A[i] + A[j] < find) {
					i++;
				}else {
					j--;
				}
			}
		}
		
		//[결과 출력]
		System.out.println(Result);
		bf.close();
		
		/*
		 * 구현 방법6. 교재 학습 후 구현 방법3을 보완
		 * 반복문의 방향만 빼고 교재 답안과 동일함
		 */
		//[입력 받기]
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt(); //수의 갯수		
//		long[] list = new long[n]; //크기 n
//		for(int i = 0; i < n; i++) {
//			list[i] = scan.nextLong();
//		}
//		
//		Arrays.sort(list); //오름차순 정렬
//		int cnt = 0;
//		for(int i = n - 1; i >= 0; i--) {
//			int s = 0;
//			int e = n - 1;
//			while(s < e) {
//				long sum = list[s] + list[e];
//				if(list[i] == sum) {
//					if(s == i) {
//						s++;
//					}else if(e == i) {
//						e--;
//					}else {
//						s++;
//						e--;
//						cnt++;
//						break;
//					}
//				}else if(list[i] < sum) {
//					e--;
//				}else {
//					s++;
//				}
//			}
//		}		
//		
//		//[결과 출력]
//		System.out.println(cnt);	
//		scan.close();
		
	}

}
