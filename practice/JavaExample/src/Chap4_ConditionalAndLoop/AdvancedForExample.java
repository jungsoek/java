package Chap4_ConditionalAndLoop;

public class AdvancedForExample {

	public static void main(String[] args) {

		// 배열 변수 선언과 배열 생성
		int[] scores = { 95, 71, 84, 93, 87 };
		// 배열 항목 전체 값 구하기
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		System.out.println("총합 : " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("평균 : " + avg);

	}

}
