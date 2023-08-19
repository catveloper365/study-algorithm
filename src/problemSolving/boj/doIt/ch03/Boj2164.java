package problemSolving.boj.doIt.ch03;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Boj2164 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-5. 카드2 문제(boj.2164)
	 * 성공 케이스(구현 방법 1,2) : 시간복잡도 O(n)
	 */
	public static void main(String[] args) {

		//입력
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		/*
		 * 구현 방법1. 내가 작성한 풀이
		 */		
//		int idx = 1;
//		while(queue.size() > 1) {
//			if(idx % 2 != 0) {
//				queue.poll();
//			}else {
//				int temp = queue.poll();
//				queue.add(temp);
//			}
//			idx++;
//		}
//		System.out.println(queue.peek());
		
		/*
		 * 구현 방법2. 교재 풀이
		 */
		while(queue.size() > 1) { //카드가 1장 남을 때까지
			queue.poll(); //맨 위의 카드를 버림
			queue.add(queue.poll()); //맨 위의 카드를 가장 아래 카드 밑으로 이동
		}
		System.out.println(queue.poll()); //마지막으로 남은 카드 출력 

	}

}
