package problemSolving.boj.doIt.ch03_자료구조.sec04_슬라이딩윈도우;

//import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891_fail {
	/*
	 * Do it! 알고리즘 코딩 테스트(자바편)
	 * ch03-4. DNA 비밀번호 문제(boj.12891)
	 * 실패 케이스(구현 방법 1) : 시간복잡도 O(n^2)
	 */	

	public static void main(String[] args) throws IOException {
		//[입력받기]
//		Scanner scan = new Scanner(System.in);
//		int s = scan.nextInt();
//		int p = scan.nextInt();
//		
//		scan.nextLine(); //공백문자 제거
//		
//		String dna = scan.nextLine(); //dna 문자열
//		Map<String,Integer> map = new HashMap<>(4); //크기 4
//		map.put("A", scan.nextInt());
//		map.put("C", scan.nextInt());
//		map.put("G", scan.nextInt());
//		map.put("T", scan.nextInt());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String dna = br.readLine();
		st = new StringTokenizer(br.readLine());
		Map<String,Integer> map = new HashMap<>(4);
		map.put("A", Integer.parseInt(st.nextToken()));
		map.put("C", Integer.parseInt(st.nextToken()));
		map.put("G", Integer.parseInt(st.nextToken()));
		map.put("T", Integer.parseInt(st.nextToken()));
		
		/*
		 * 구현 방법1.
		 */
		List<String> subList = new ArrayList<>();
		for(int i = 0; (i + p - 1) < s; i++) {
			int e = i + p;
			subList.add(dna.substring(i, e));
		}
		
//		String[] subList = new String[s];
//		int listLen = 0;
//		for(int i = 0; (i + p - 1) < s; i++) {
//			int e = i + p;
//			subList[i] = dna.substring(i, e);
//			listLen++;
//		}
		
		int result = 0;
		for(String str : subList) {
//		for(int i = 0; i < listLen; i++) {
//			String str = subList[i];
			int ori = str.length();
			boolean compare = true;
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				int chg = str.replaceAll(key, "").length();
				int cnt = ori - chg;
				if(cnt < map.get(key)) {
					compare = false;
					break;
				}
			}
			if(compare) {
				result++;
			}
		}
		
		//[출력]
		System.out.println(result);
//		scan.close();
		br.close();
		
	}

}
