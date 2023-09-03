package problemSolving.boj.doIt.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj11286 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-5. 절댓값 힙 문제(boj.11286)
	 * 성공 케이스(구현 방법 1) : 시간복잡도 O(nlogn)
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * 구현 방법1. 교재 풀이
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs)
				return o1 > o2? 1 : -1; //절댓값이 같으면 음수 우선 정렬하기
			else
				return first_abs - second_abs; //절댓값을 기준으로 정렬하기
		});
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(queue.isEmpty())
					System.out.println("0");
				else
					System.out.println(queue.poll());
			}else {
				queue.add(request);
			}
		}
	}

}
