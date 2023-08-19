package problemSolving.boj.doIt.ch03;

import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj17298 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-5. 오큰수 문제(boj.17298)
	 * 성공 케이스(구현 방법 1,2) : 시간복잡도 O(n)
	 */
	
	public static void main(String[] args) throws IOException {
		/*
		 * 구현 방법1. 교재 학습 후 내가 작성한 풀이
		 * 입출력에 Scanner, System.out.print 사용하면 시간 초과로 실패함  
		 */
		//입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[N];
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				int pop = stack.pop();
				result[pop] = A[i];
			}
			stack.push(i); //인덱스를 push
		}
		
		for(Integer i : stack) {
			result[i] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(result[i] + " "); //출력
		}
		
		System.out.println(sb.toString());
		bf.close();
		
		/*
		 * 구현 방법2. 교재 풀이
		 */
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(bf.readLine());
//		int[] A = new int[N]; //수열 배열 생성
//		int[] ans = new int[N]; //정답 배열 생성
//		
//		//공백을 구분자로 수열의 n개 요소를 배열에 담기
//		//StringTokenizer을 사용하지않는 방법
//		String[] str = bf.readLine().split(" ");
//		for(int i = 0; i < N; i++) {
//			A[i] = Integer.parseInt(str[i]); //형변환
//		}
//		
//		Stack<Integer> myStack = new Stack<>();
//		//처음에는 항상 스택이 비어있으므로, 최초 값을 push해 초기화
//		myStack.push(0);
//		for(int i = 1; i < N; i++) {
//			//스택이 비어있지않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
//			while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
//				ans[myStack.pop()] = A[i]; //정답 배열에 오큰수를 현재 수열로 저장하기
//			}
//			myStack.push(i);
//		}
//		
//		while(!myStack.isEmpty()) {
//			//반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때까지
//			//스택에 쌓인 index에 -1을 넣는다
//			ans[myStack.pop()] = -1;
//		}
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		for(int i = 0; i < N; i++) {
//			bw.write(ans[i] + " "); //출력
//		}
//		bw.write("\n");
//		bw.flush();
	}

}
