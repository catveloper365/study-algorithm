package problemSolving.boj.doIt.ch03;

import java.util.Scanner;

public class Boj1546 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-1. 평균 문제(boj.1546)
	 * 시간복잡도 O(n)
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * 구현 방법1. 내가 작성한 풀이 - 시간복잡도 O(n)
		 */
		
//		//[입력]
//		int n = Integer.parseInt(scan.nextLine()); //과목 개수
//		String sScore = scan.nextLine(); //과목 점수들
//
//		//[문제 해결 로직]
//		String[] arrScore = sScore.split(" "); //공백을 구분자로 하여 각 과목 점수 분리
//		
//		//최댓값 찾기
//		int max = 0; //과목 점수는 0 이상 100 이하 정수, 적어도 한 개는 0보다 큼
//		for(int i = 0; i < arrScore.length; i++) { //최대 n번 수행
//			int score = Integer.parseInt(arrScore[i]); //점수 형 변환(String형->숫자형)
//			if(max < score) { 
//				max = score;
//			}
//		}
//		
//		//조작 점수 계산하여 합하기
//		double sum = 0.0; //조작한 점수를 합산할 변수(조작한 점수는 실수가 될 수 있음)
//		for(int j = 0; j < arrScore.length; j++) { //최대 n번 수행
//			double score = Double.parseDouble(arrScore[j]);
//			sum += score / max * 100; //점수 조작하여 합하기
//		}
//		
//		//[결과 출력]
//		System.out.println(sum/n); 
		
		/*
		 * 구현 방법2. 교재 슈도코드 보고 작성 + 답안 결과 합하기 - 시간복잡도 O(n)
		 */

		//[입력 받기]
		int n = scan.nextInt();
		int[] a = new int[n];
		
		//과목 수 만큼의 int형 숫자 입력 받기
		for(int i = 0; i < n; i++) { //최대 n번 반복
			a[i] = scan.nextInt();
		}
		
		//[문제 해결 로직]
		//내가 작성 - 조작 점수가 실수인 것을 계산하기 위해 실수형 double 사용
//		double sum = 0; 
		//교재 답안 - 오버플로우 실수 방지를 위해 long형 사용한 것 같은데 이 문제는 int도 충분
		long sum = 0; 
		
		int max = 0;
		for(int j = 0; j < n; j++) { //최대 n번 반복
			if(max < a[j]) { //점수 최댓값 찾기
				max = a[j];
			}
			sum += a[j]; //총합 계산
		}
		
		//[결과 출력] 변형된 식을 도출하여 계산이 간편해짐
		//내가 작성(double sum을 함께 사용해야하는 코드)
//		System.out.println(sum * 100 / max / n); 
		//교재 답안(100을 100.0 실수형으로 표현하며 실수 결과도 해결)
		System.out.println(sum * 100.0 / max / n); 
	}
}
