package Chap4_ConditionalAndLoop;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		
		int[] intArray = null;
		// intArray[0] = 10;	// NullPointerException
		
		String str = null;
		System.out.println(str.length());	// NullPointerException

	}

}
