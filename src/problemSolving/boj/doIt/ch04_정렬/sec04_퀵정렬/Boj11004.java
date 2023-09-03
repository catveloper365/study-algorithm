package problemSolving.boj.doIt.ch04_정렬.sec04_퀵정렬;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11004 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch04-4. K번째 수 문제(boj.11004)
	 * 성공 케이스(구현 방법 2) : 시간복잡도 O(nlogn)
	 * 실패 케이스(구현 방법 1) : 시간복잡도 O(nlogn)
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * 구현 방법1. 내가 작성한 풀이
		 * 런타임 에러(ArrayIndexOutOfBounds)로 실패
		 */
//		quickSort(A, 0, N-1);
//		System.out.println(Arrays.toString(A));	

		/*
		 * 구현 방법2. 교재 풀이
		 */
		quickSort(A, 0, N - 1, K - 1);
		

		System.out.println(A[K-1]);
	}
	
	/*
	 * 구현 방법1. 내가 작성한 풀이
	 * 런타임 에러(ArrayIndexOutOfBounds)로 실패
	 */
//	static void quickSort(int[] arr, int sIdx, int eIdx) {
//		if(sIdx == eIdx) {
//			return;
//		}
//		
//		int pivot = eIdx;
//		int end = pivot - 1;
//		int start = sIdx;
//		
//		while(start != end) {
//			if(arr[start] > arr[pivot] && arr[end] < arr[pivot]) {
//				//swap
//				int temp = arr[start];
//				arr[start] = arr[end];
//				arr[end] = temp;
//				
//				start++;
//				end--;
//			}else {
//				if(arr[start] < arr[pivot]) {
//					start++;
//				}
//				if(arr[end] > arr[pivot]) {
//					end--;
//				}				
//			}
//
//		}
////		int insert_point = start - 1;
//		int insert_point = start;
//		int insert_value = arr[pivot];
//		if(start == 0) {
//			insert_point = 0;
//		}
//		else if(arr[start] < arr[pivot]) {
//			insert_point = start + 1;
//		}
//		//swift 후 삽입, 현재 위치와 삽입 위치가 다를 때만
//		if(insert_point != pivot) {
//			for(int i = pivot; i > insert_point; i--) {
//				arr[i] = arr[i-1];
//			}
//			arr[insert_point] = insert_value;		
//		}
//		
//		//재귀호출을 통해 정렬 수행
////		if(insert_point > 0 && sIdx <= insert_point - 1)
//		if(sIdx <= insert_point - 1)
//			quickSort(arr, sIdx, insert_point - 1); //pivot보다 작은 데이터
//		if(insert_point < pivot)
//			quickSort(arr, insert_point + 1, eIdx); //pivot보다 큰 데이터			
//	}
	
	/*
	 * 구현 방법2. 교재 풀이
	 */
	public static void quickSort(int[] A, int S, int E, int K) {
		if(S < E) {
			int pivot = partition(A, S, E);
			if(pivot == K) {
				return; //K번째 수가 pivot이면 더 이상 구할 필요 없음. 정렬 종료
			}else if(K < pivot) {
				quickSort(A, S, pivot - 1, K); //K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
			}else {
				quickSort(A, pivot + 1, E, K); //K가 pivot보다 크면 오른쪽 그룹만 정렬 수행하기
			}
		}
	}
	
	public static int partition(int[] A, int S, int E) {
		if(S + 1 == E) {
			if(A[S] > A[E]) swap(A, S, E);
			return E;
		}
		int M = (S + E) / 2;
		swap(A, S, M); //중앙값을 1번째 요소로 이동하기
		int pivot = A[S];
		int i = S + 1, j = E;
		while(i <= j) {
			while(pivot < A[j] && j > 0) {
				j--; //피벗보다 작은 수가 나올 때 까지 j--
			}
			while(pivot > A[i] && i < A.length - 1) {
				i++; //피벗보다 큰 수가 나올 때까지 i++
			}
			if(i <= j) {
				swap(A, i++, j--);
			}
		}
		//i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
		A[S] = A[j];
		A[j] = pivot;
		return j;
	}
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
