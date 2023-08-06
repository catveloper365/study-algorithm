package problemSolving.boj.doIt.ch03;
import java.util.HashMap;
import java.util.Scanner;

public class Boj12891 {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-4. DNA 비밀번호 문제(boj.12891)
	 * 성공 케이스 : 시간복잡도 O(n)
	 */
	private static HashMap<String,Integer> compareMap;
	private static HashMap<String,Integer> cntMap;
	
	/**
	 * 부분 문자열이 조건을 만족하는 지 체크
	 * @return 조건을 만족하면 true 리턴
	 */
	private static boolean checkedMap() {
		boolean check = true; 
		for(String key : compareMap.keySet()) {
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
			String key = keys.substring(i, i+1);
			compareMap.put(key, scan.nextInt());
			
			cntMap.put(key, 0);
		}
		
		//전체 dna 문자열에서 각 문자의 갯수 카운팅
		for(int i = 0; i < s; i++) { //O(n)
			String character = dna.substring(i,i+1);
			cntMap.put(character, cntMap.getOrDefault(character, 0)+1);
		}
		
		boolean checked = checkedMap(); //조건을 만족하면 true
		
		int result = 0; //반환할 값, 비밀번호의 갯수
		if(checked) { //전체 문자열이 조건을 만족하지 못하면, 부분 문자열도 만족x -> 볼 필요도 없음
			int sIdx = 0; //부분 문자열 시작 인덱스
			int eIdx = sIdx + p - 1; //부분 문자열 끝 인덱스
			
//			boolean first = true;
			
			for(int i = eIdx + 1; i < s; i++) { //O(n)보다 작음
				String key = dna.substring(i,i+1);
				cntMap.put(key, cntMap.get(key)-1);
			}
			checked = checkedMap();
			
			if(checked) {
				result++;
			}
	
			while(eIdx + 1 < s) { 
//				if(first) {
//					//전체 문자열 카운팅한 결과에서 부분 문자열에 속한 값만 남기고 제거 
//					for(int i = eIdx + 1; i < s; i++) { //O(n)보다 작음
//						String key = dna.substring(i,i+1);
//						cntMap.put(key, cntMap.get(key)-1);
//					}
//					
//					first = false;
//				}
//				else {
					//out, 이전에 가리킨 값을 카운팅 갯수에서 빼고 시작 인덱스를 증가시키기
					String sKey = dna.substring(sIdx, sIdx+1);
					cntMap.put(sKey, cntMap.get(sKey)-1);
					sIdx++;
					
					//in, 끝 인덱스를 증가시키고 카운팅 갯수에 더하기 
					eIdx++;
					String eKey = dna.substring(eIdx, eIdx+1);
					cntMap.put(eKey, cntMap.get(eKey)+1);					
//				}
			
				checked = checkedMap();
				
				if(checked) {
					result++;
				}
			}
		}
		System.out.println(result);

	}

}
