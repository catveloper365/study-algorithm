package problemSolving.boj.doIt.ch03_자료구조.sec02_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-2. 나머지 합 문제(boj.10986)
	 * 성공 케이스(구현 방법 3,4) : 시간복잡도 O(n)
	 */

	public static void main(String[] args) throws IOException{

		/*
		 * 구현 방법3. 교재 답안
		 * 시간복잡도 O(n)
		 */
		//[입력 받기]
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		long[] S = new long[N];
//		long[] C = new long[M];
//		long answer = 0;
//		
//		S[0] = sc.nextInt();
//		for(int i = 1; i < N; i++) { //수열 합 배열 만들기
//			S[i] = S[i - 1] + sc.nextInt();
//		}
//		for(int i = 0; i < N; i++) { //합 배열의 모든 값에 % 연산 수행하기
//			int remainder = (int) (S[i] % M);
//			//0~i까지의 구간 합 자체가 0일 때 정답에 더하기
//			if(remainder == 0) answer++;
//			//나머지가 같은 인덱스의 갯수 카운팅하기
//			C[remainder]++;
//		}
//		for(int i = 0; i < M; i++) {
//			if(C[i] > 1) {
//				//나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
//				answer = answer + (C[i] * (C[i] - 1) / 2);
//			}
//		}
//		System.out.println(answer);	
		
		/*
		 * 구현 방법4. 교재 답안 내 방식으로 수정
		 * 시간 복잡도 O(n)
		 */
		//[입력받기]
		//입력 데이터가 많기 때문에 Scanner 보다 빠른 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //수의 갯수
		int m = Integer.parseInt(st.nextToken()); //구간 합을 나눌 수
		
		long[] d = new long[n]; //구간 합 배열
		
		//구간 합을 M으로 나눈 나머지의 값이 같은 인덱스의 개수 카운팅할 배열
		long[] c = new long[m]; //M으로 나눈 나머지의 값을 0 ~ M-1까지 총 M개임
		long cnt = 0; //구간 합이 M으로 나누어 떨어지는 순서쌍 갯수
		
		st = new StringTokenizer(br.readLine());

		//구간 합 배열 계산, 나머지가 같은 인덱스 개수 계산
		for(int i = 0; i < n; i++){
			//구간 합 배열 계산
			if(i == 0) {
				d[i] = Integer.parseInt(st.nextToken());
			}else {
				d[i] = d[i-1] + Integer.parseInt(st.nextToken()); //구간 합 배열 계산
			}
			
			//나머지가 같은 인덱스 개수 계산
			//반드시 괄호 붙여 나머지 먼저 구한 다음 형 변환해야함
			int remainder = (int) (d[i] % m); 
			if(remainder == 0) { //0부터 i까지의 구간 합이 m으로 나누어떨어짐
				cnt++;
			}
			c[remainder]++; //나머지의 값이 같은 인덱스의 갯수 세기
		}
		
		//나머지 값이 같은 인덱스 갯수에서 순서 상관없이 2개씩 뽑는 모든 경우의 수 구하기
		for(int i = 0; i < m; i++) {
			if(c[i] > 1) { //2개를 뽑아야하므로 인덱스 갯수가 2개 이상인 경우에만 계산해야함
				cnt += (c[i] * (c[i]-1) / 2);
			}
		}
		//[결과 출력]
		System.out.println(cnt);
	}
}
