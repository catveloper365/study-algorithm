package problemSolving.programmers.level0;

public class 나머지구하기 {
    public int solution(int num1, int num2) {
        int answer = num1 % num2;
        return answer;
    }
    
	public static void main(String[] args) {
		나머지구하기 object = new 나머지구하기();
		int answer = object.solution(3, 2);
		System.out.println(answer);
	}

}
