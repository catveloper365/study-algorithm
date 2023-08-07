package problemSolving.boj.doIt.ch03;
import java.util.HashMap;
import java.util.Scanner;

public class Boj12891 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-4. DNA 비밀번호 문제(boj.12891)
	 * 성공 케이스 : 시간복잡도 O(n)
	 */
	private static HashMap<Character, Integer> compareMap;
	private static HashMap<Character, Integer> cntMap;
	
	/**
	 * 부분 문자열이 조건을 만족하는 지 체크
	 * @return 조건을 만족하면 true 리턴
	 */
	private static boolean checkedMap() {
		boolean check = true; 
		for(Character key : compareMap.keySet()) {
			//A,C,G,T 중 한 개라도 조건을 불만족하면 비밀번호로 사용 불가능
			if(compareMap.get(key) > cntMap.get(key)) {
				check = false;
				break;
			}
		}
		return check; //조건을 모두 만족하면 true
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s = Integer.parseInt(scan.next()); //dna 문자열 길이
		int p = Integer.parseInt(scan.next()); //부분 문자열 길이
		String dna = scan.next(); //임의의 dna 문자열
		
		compareMap = new HashMap<>(); //만족해야하는 조건
		cntMap = new HashMap<>(); //부분 문자열의 각 문자(A,C,G,T) 갯수 카운팅
		String keys = "ACGT";
		for(int i = 0; i < 4; i++) { //map 초기화, O(1)
			char key = keys.charAt(i);
			compareMap.put(key, Integer.parseInt(scan.next())); //조건 입력 받기
			
			cntMap.put(key, 0); //초기화
		}

		//전체 dna 문자열에서 각 문자의 갯수 카운팅
		for(int i = 0; i < s; i++) { //O(n)
			char str = dna.charAt(i);
			cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
		}
		
		int result = 0; //반환할 값, 비밀번호의 갯수
		
		boolean checked = checkedMap(); //조건을 만족하면 true
		if(checked) { //전체 문자열이 조건을 만족하지 못하면, 부분 문자열도 만족x -> 볼 필요도 없음
			int sIdx = 0; //부분 문자열 시작 인덱스
			int eIdx = sIdx + p - 1; //부분 문자열 끝 인덱스
			
			//부분 문자열 길이 밖의 문자의 개수는 제거하기
			for(int i = p; i < s; i++) { //O(n)보다 작거나 같음
				char key = dna.charAt(i);
				cntMap.put(key, cntMap.get(key)-1); //갯수 빼기
			}
			
			//첫번째 부분 문자열 검증
			checked = checkedMap();
			
			if(checked) {
				result++;
			}
	
			//두번째 부분 문자열부터 검증
			while(eIdx + 1 < s) { 
				//out, 이전에 가리킨 값을 카운팅 갯수에서 빼고 시작 인덱스를 증가시키기
				char sKey = dna.charAt(sIdx);
				cntMap.put(sKey, cntMap.get(sKey)-1);
				sIdx++;
				
				//in, 끝 인덱스를 증가시키고 카운팅 갯수에 더하기 
				eIdx++;
				char eKey = dna.charAt(eIdx);
				cntMap.put(eKey, cntMap.get(eKey)+1);					
			
				checked = checkedMap();
				
				if(checked) {
					result++;
				}
			}
		}
		System.out.println(result);
		scan.close();
	}

}
