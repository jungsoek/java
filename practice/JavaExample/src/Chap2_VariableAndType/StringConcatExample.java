package Chap2_VariableAndType;

public class StringConcatExample {

	public static void main(String[] args) {
		
		// 숫자 연산
		int result1 = 10 + 2 + 8;
		System.out.println(result1);
		
		// 결합 연산
		String result2 = 10 + 2 + "8";
		System.out.println(result2);
		
		String result3 = 10 + "2" + 8;
		System.out.println(result3);
		
		String result4 = "10" + 2 + 8;
		System.out.println(result4);
		
		String result5 = "10" + (2 + 8);
		System.out.println(result5);

	}

}
