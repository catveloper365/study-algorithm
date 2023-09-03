package problemSolving.boj.doIt.ch03;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Boj11003 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-4. 최솟값 찾기 문제(boj.11003)
	 * 성공 케이스(구현 방법 1) : 시간복잡도 O(n)
	 */

	public static void main(String[] args) throws IOException {
		
		/*
		 * 구현 방법1. 교재 풀이 + a
		 * 교재에서는 출력값 저장에 BufferedWriter를 사용
		 * 나는 StringBuilder를 사용
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//출력값을 버퍼에 넣고 마지막에 한 번에 출력하기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //방법1. BufferedWriter 사용
//		StringBuilder sb = new StringBuilder(); //방법2. StringBuilder 사용
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //데이터의 갯수
		int L = Integer.parseInt(st.nextToken()); //윈도우 크기(인덱스 범위)
		
		Deque<Node> mydeque = new LinkedList<>(); //삽입,삭제 연산을 해야하므로 LinkedList 사용
		
		st = new StringTokenizer(br.readLine());		
		for(int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			//새로운 값이 들어올 때마다 정렬 대신, 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
			while(!mydeque.isEmpty() && (mydeque.getLast().value > now)) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(i,now));
			
			//범위에서 벗어난 값은 덱에서 제거
//			if(mydeque.getFirst().index <= i - L) { //교재 방법
			if(i - mydeque.getFirst().index + 1 > L) { //내 방법	
				mydeque.removeFirst();
			}
			
			bw.write(mydeque.getFirst().value + " ");
//			sb.append(mydeque.getFirst().value + " ");
		}
		
		bw.flush();
		bw.close();
		
//		System.out.println(sb.toString());
	}
	
	static class Node{
		int index;
		int value;
		
		Node(int index, int value){
			this.index = index;
			this.value = value;
		}
	}

}
