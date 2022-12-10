package concept.search;

/**
 * 순차탐색(완전탐색) 알고리즘을 구현한 클래스
 * 기본 개념 : 데이터가 담겨 있는 리스트의 맨 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법
 * 시간복잡도 : O(n)
 * @author "catveloper365"
 *
 */
public class SequentialSearch {
	
	/**
	 * 참조 타입 배열에서 특정 데이터를 찾아 데이터의 배열 인덱스를 반환한다.
	 * @param arr 데이터가 담겨 있는 참조 타입 배열
	 * @param searchData 찾는 데이터
	 * @return 찾는 데이터의 배열 인덱스 값을 반환, 없으면 -1 반환
	 */
	public int search(Object[] arr, Object searchData) {
		for(int i = 0; i < arr.length; i++) {
			if(searchData instanceof String) {
				if(searchData.equals(arr[i])) {
					return i;
				}
			}else if(searchData instanceof Number){ //모든 숫자형 참조 타입이 해당
				if(searchData == arr[i]) {
					return i;
				}				
			}else {
				//보류
			}
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		//테스트 위해 인스턴스 생성
		SequentialSearch instance = new SequentialSearch();
		
		/* 1.참조 타입 배열 */
		
		//1-1.문자열 String 타입 배열
		String[] strArr = new String[]{"h","e","l","o"};
		int strIdx = instance.search(strArr, "i");
		System.out.println(strIdx);		
		
		//1-2.숫자형 참조 타입 배열
		
		//1-2-1.정수형 Integer 배열
		Integer[] intArr = new Integer[]{5,2,1,3,4};
		int intIdx = instance.search(intArr, 2);
		System.out.println(intIdx);
		
	}

}
