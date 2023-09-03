package problemSolving.boj.doIt.ch03_자료구조.sec05_스택과큐;

import java.util.Scanner;
import java.util.Stack;

public class Boj1874 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-5. 스택 수열 문제(boj.1874)
	 * 성공 케이스(구현 방법 1,2) : 시간복잡도 O(n)
	 */

	public static void main(String[] args) {
		//입력
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) { //O(n)
			A[i] = scan.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		
		/*
		 * 구현 방법1. 내가 작성한 풀이
		 */
		StringBuilder sb = new StringBuilder();
		int addNum = 1;
		for(int i = 0; i < N; i++) { //O(n)보다 조금 큼
			int top = stack.isEmpty()? 0 : stack.peek();
			if(top == A[i]) {
				stack.pop();
				sb.append("-\n");
			}else if(top < A[i]) {
				while(addNum <= A[i]) {
					stack.push(addNum++);
					sb.append("+\n");
				}
				
				stack.pop();
				sb.append("-\n");
			}else { //top > A[i]
				sb.delete(0, sb.length()); //초기화
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb.toString());
		
		/*
		 * 구현 방법2. 교재 풀이
		 */
//		StringBuffer bf = new StringBuffer();
//		int num = 1; //오름차순 수
//		boolean result = true;
//		for(int i = 0; i < A.length; i++) {
//			int su = A[i]; //현재 수열의 수
//			if (su >= num) { //현재 수열 값 >= 오름차순 자연수, 값이 같아질 때 까지 push() 수행
//				while(su >= num) {
//					stack.push(num++);
//					bf.append("+\n");
//				}
//				stack.pop();
//				bf.append("-\n");
//			}else { //현재 수열 값 < 오름차순 자연수, pop()을 수행해 수열 원소를 꺼냄
//				int n = stack.pop();
//				//스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
//				if(n > su) {
//					System.out.println("NO");
//					result = false;
//					break;
//				}else {
//					bf.append("-\n");
//				}
//				
//			}
//			
//		}
//		if(result)
//			System.out.println(bf.toString());
	}
}
