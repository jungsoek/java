# 참조 타입

## 데이터 타입 분류

자바의 데이터 타입은 크게 기본 타입과 참조 타입으로 분류된다. 참조 타입이란 객체의 번지를 참조하는 타입으로 배열, 열거, 클래스, 인터페이스 타입이 있다.

기본 타입으로 선언된 변수와 참조 타입으로 선언된 변수의 차이점은 저장되는 값이다. 기본 타입으로 선언된 변수는 값 자체를 저장하고 있지만, 참조 타입으로 선언된 변수는 객체가 생성된 메모리 번지를 저장한다.

cf) : 참조 타입은 포인터인가?

참조 타입은 포인터와 다르다. 포인터는 메모리 주소를 직접 다루는 변수를 의미하며, 주로 C나 C++ 같은 언어에서 사용된다. 이에 비해 참조 타입은 주소를 직접 다루기보다는, 객체의 위치를 간접적으로 참조하는 역할을 한다.

예를 들어, Java와 같은 언어에서 참조 타입은 객체의 메모리 위치를 저장하지만, 개발자가 메모리 주소를 직접 조작할 수는 없도록 추상화되어 있다. 이는 메모리 관리와 보안성을 높이는 데 도움을 준다.

따라서 : 

* 포인터는 메모리 주소를 직접 조작하는 반면,
* 참조 타입은 메모리 주소를 추상화하고 객체에 간접적으로 접근할 수 있게 한다.

변수들은 모두 스택이라는 메모리 영역에 생성된다. 기본 타입 변수는 직접 값을 저장하고 있지만, 참조 타입 변수는 힙 메모리 영역의 String 객체 번지를 저장하고 이 번지를 통해 String 객체를 참조한다.

## 메모리 사용 영역

자바에서 사용하는 메모리 영역에 대해 알아본다. java 명령어로 JVM이 구동되면 JVM은 운영체제에서 할당받은 메모리 영역(Runtime Data Area)을 다음과 같이 구분해서 사용한다. 

### 메소드 영역

메소드 영역은 바이트코드 파일을 읽은 내용이 저장되는 영역으로 클래스별로 상수, 정적 필드, 메소드 코드, 생성자 코드 등이 저장된다. 주요 특징은 다음과 같다.

* 클래스 파일이 로드되면 클래스별 데이터, 정적 변수(static variable), 상수와 메서드 코드가 이곳에 저장된다.
* 클래스의 구조에 대한 정보와, 정적 초기화 블록 등이 포함된다.
* JVM의 종료 시까지 해당 데이터가 유지된다.

### 힙 영역

힙 영역은 객체가 생성되고 저장되는 영역이다. 객체의 번지는 메소드 영역과 스택 영역의 상수와 변수에서 참조할 수 있다.

* 모든 객체와 배열이 생성되며, GC가 관리한다.
* 메소드 영역과 스택 영역에서 참조할 수 있는 객체 데이터가 포함된다.
* new 키워드를 사용해 객체를 생성하면, 이 객체가 힙에 저장된다.

### 스택 영역

스택 영역은 메소드를 호출할 때마다 생성되는 프레임이 저장되는 영역이다. 메소드 호출이 끝나면 프레임은 자동 제거된다. 프레임 내부에는 로컬 변수 스택이 있다. 여기에서 기본 타입 변수와 참조 타입 변수가 생성되고 제거된다.

* 메소드 호출에 대한 정보(스택 프레임)가 저장된다.
* 로컬 변수(기본 타입과 참조 타입)와 메소드의 매개변수가 저장된다.
* 자동으로 생성 및 제거되므로 개발자가 직접 관리하지 않는다.

## 참조 타입 변수의 ==, != 연산

==, != 연산자는 변수의 값이 같은지, 아닌지를 조사한다. 참조 타입 변수의 값은 객체의 번지이므로 참조 타입 변수의 ==, != 연산자는 번지를 비교하는 것이 된다. 번지가 같다면 동일한 객체를 참조하는 것이고, 다르다면 다른 객체를 참조하는 것이다.

*ReferenceVariableCompareExample.java*

```java
package Chap4_ConditionalAndLoop;

public class ReferenceVariableCompareExample {

	public static void main(String[] args) {
		
		int[] arr1;
		int[] arr2;
		int[] arr3;
		
		arr1 = new int[] {1,2,3};
		arr2 = new int[] {1,2,3};
		arr3 = arr2;
		
		System.out.println(arr1 == arr2);
		System.out.println(arr2 == arr3);

	}

}
```

```
false
true
```

## null과 NullPointerException

참조 타입 변수는 아직 번지를 저장하고 있지 않다는 뜻으로 null 값을 가질 수 있다. null도 초기값으로 사용할 수 있기 때문에 null로 초기화된 참조 변수는 스택 영역에 생성된다.

```java
String refVar1 = "자바";
String refVar2 = null;
```

참조 타입 변수가 null 값을 가지는지 확인하려면 다음과 같이 ==, != 연산을 수행할 수 있다.

```java
refVar1 == null;	// 결과 : false
refVar2 != null;	// 결과 : true
```

```java
refVar2 == null		// 결과 : true
refVar2 != null		// 결과 : false
```

자바는 프로그램 실행 도중에 발생하는 오류를 예외라고 부른다. 참조 변수를 사용하면서 가장 많이 발생하는 예외 중 하나는 NullPointerException이다. 변수가 null인 상태에서 객체의 데이터나 메소드를 사용하려 할 때 이 예외가 발생한다. 다음 코드를 보자.

```java
int[] intArray = null;
intArray[0] = 10;		// NullPointerException
```

배열 변수 intArray에 null을 대입한 상태에서 배열 객체의 0 인덱스 항목에 10을 대입하는 코드(intArray[0] = 10)를 실행하면 NullPointerException이 발생한다. 이유는 intArray가 참조하는 배열 객체가 없으므로 10을 저장할 수 없기 때문이다. 다음 코드도 보자.

```java
String str = null;
System.out.println("총 문자 수 : " + str.length());		// NullPointerException
```

str 변수에 null을 대입한 상태에서 문자열 길이를 얻기 위해 length() 메소드를 호출하면 NullPointerException이 발생한다. 이유는 str 변수가 참조하는 String 객체가 없으므로 문자열의 길이를 구할 수 없기 때문이다. 

따라서 str 변수가 null인지 확인하는 코드를 추가하면 NullPointerException을 피할 수 있다.

```java
if (str != null) {
    System.out.println("총 문자 수 : " + str.length());
} else {
    System.out.println("str 변수는 null입니다.");
}
```

*NullPointerExceptionExample.java*

```java
package Chap4_ConditionalAndLoop;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		
		int[] intArray = null;
		// intArray[0] = 10;	// NullPointerException
		
		String str = null;
		System.out.println(str.length());	// NullPointerException

	}

}
```

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
	at Chap4_ConditionalAndLoop.NullPointerExceptionExample.main(NullPointerExceptionExample.java:11)
```

앞으로 NullPointerException이 발생하면 예외가 발생된 곳에서 null인 상태의 참조 변수가 사용되고 있음을 알아야 한다. 이것을 해결하려면 참조 변수가 객체를 정확히 참조하도록 번지를 대입해야 한다.

경우에 따라서는 참조 타입 변수에 일부러 null을 대입하기도 한다. 프로그램에서 객체를 사용하려면 해당 객체를 참조하는 변수를 이용해야 하는데, 변수에 null을 대입하면 번지를 잃게 되므로 더이상 객체를 사용할 수 없게 된다.

```java
String hobby = "여행";
hobby = null;
```

어떤 변수에서도 객체를 참조하지 않으면 해당 객체는 프로그램에서 사용할 수 없는 객체가 된다. 즉, 힙 메모리에는 있지만, 위치 정보를 모르기 때문에 사용할 수 없게 된다. 자바는 이러한 객체를 쓰레기로 취급하고, GC를 실행시켜 자동으로 제거한다.

사실 자바는 코드를 이용해서 객체를 직접 제거하는 방법을 제공하지 않는다. 객체를 제거하는 유일한 방법은 객체의 모든 참조를 없애는 것이다.

다음 코드에서 "여행"에 해당하는 String 객체는 쓰레기가 된다. hobby 변수에 "영화"가 대입되면서 다른 String 객체의 번지가 대입되어 이전 번지를 잃어버리기 때문이다.

```java
String hobby = "여행";
hobby = "영화";
```

*GarbageObjectExample.java*

```java
package Chap4_ConditionalAndLoop;

public class GarbageObjectExample {

	public static void main(String[] args) {
		
		String hobby = "여행";
		hobby = null;		// "여행"에 해당하는 String 객체를 쓰레기로 만듦
		
		String kind1 = "자동차";
		String kind2 = kind1;	// kind1 변수에 저장되어 있는 번지를 kind2 변수에 대입
		kind1 = null;	// "자동차"에 해당하는 String 객체는 쓰레기가 아님
		System.out.println("kind2 : " + kind2);

	}

}
```

```
kind2 : 자동차
```

10라인에서 kind1 변수에 null을 대입한다고 해서 "자동차"에 해당하는 String 객체가 쓰레기가 되지는 않는다. 그 이유는 kind2 변수가 여전히 참조하고 있기 때문이다.

## 문자열(String) 타입

자바의 문자열은 String 객체로 생성된다. 다음은 두 개의 String 변수 name과 hobby를 선언하고 문자열 리터럴을 대입한 것이다. name 변수와 hobby 변수에 문자열 리터럴이 대입되면 문자열은 String 객체로 생성되고, 객체의 번지가 각각 대입된다.

```java
String name;				// String 타입 변수 name 선언 
name = "홍길동";			  // name 변수에 문자열 대입
String hobby = "여행";	   // String 타입 변수 hobby를 선언하고 문자열 대입
```

### String 자료형이 참조형인 이유

1. 불변성

   Java의 String 객체는 불변 객체로 설계되었다. 즉, 생성된 문자열은 변경할 수 없다. 이런 특성을 유지하려면 값 자체를 저장하는 기본 타입(primitive type)이 아니라, 객체를 생성하여 참조하는 구조가 필요하다. 이를 통해 동일한 문자열을 여러 참조에서 공유할 수 있어 메모리를 효율적으로 사용한다.

2. 추상화의 기능

   문자열은 단순히 텍스트 데이터를 저장하는 데 그치지 않고, 다양한 기능을 제공한다. 예를 들어, 문자열 비교, 변환, 검색 등의 메서드가 포함되어 있다. 이러한 추가 기능은 객체로 구현하는 것이 훨씬 유연하며, 객체 지향 프로그래밍의 원칙을 따른다.

3. 문자열 조작 성능

   자바는 문자열을 효율적으로 관리하기 위해 문자열 상수 풀(String Constant Pool)을 사용한다. 동일한 문자열 리터럴이 재사용되며, 이는 참조 타입을 기반으로 하는 구조에서 가능해진다. 기본 타입이라면 이런 최적화가 어려울 수 있다.

4. 객체 기반 설계 철학

   Java는 객체 지향 언어로 설계되었기 때문에 문자열처럼 복잡한 데이터를 객체로 다루는 것이 자연스러운 선택이다. 기본 타입은 단순 데이터를 처리하는 데 적합하지만, 문자열처럼 다양한 기능과 특성을 포함하는 경우에는 객체로 구현하는 것이 더 적합하다.

### 문자열 비교

자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 설계되어 있다. 다음과 같이 name1과 name2 변수에 "홍길도"을 대입할 경우, name1과 name2 변수에는 동일한 String 객체의 번지가 저장된다.

```java
String name1 = "홍길동"
String name2 = "홍길동";
```

String 변수에 문자열 리터럴을 대입하는 것이 일반적이지만, new 연산자로 직접 String 객체를 생성하고 대입할 수도 있다. new 연산자는 새로운 객체를 만드는 연산자로 객체 생성 연산자라고 한다.

```java
String name1 = new String("홍길동");
String name2 = new String("홍길동");
```

이 경우 name1과 name2 변수는 서로 다른 String 객체의 번지를 가지게 된다.

그렇기 때문에 문자열 리터럴로 생성하느냐 new 연산자로 생성하느냐에 따라 비교 연산자의 결과가 달라질 수 있다.

```java
String name1 = "홍길동";
String name2 = "홍길동";
String name3 = new String("홍길동");
```

name1과 name2는 동일한 문자열 리터럴로 생성된 객체를 참조하기 때문에 name1 == name2의 결과는 true가 나오지만, name3은 new 연산자로 String 객체를 별도로 저장했기 때문에 name1 == name3의 결과는 false가 나온다.

```java
name1 == name2 		// 결과 : true
name1 == name3		// 결과 : false
```

동일한 String 객체든 다른 String 객체든 상관없이 내부 문자열만을 비교할 경우에는 String 객체의 equals() 메소드를 사용한다.

*EqualsExample.java*

```java
package Chap4_ConditionalAndLoop;

public class EqualsExample {

	public static void main(String[] args) {
		
		String strVar1 = "홍길동";
		String strVar2 = "홍길동";
		
		if(strVar1 == strVar2) {
			System.out.println("참조가 동일");
		} else {
			System.out.println("참조가 다름");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("문자열 동일");
		}
		
		String strVar3 = new String("홍길동");
		String strVar4 = new String("홍길동");
		
		if(strVar3 == strVar4) {
			System.out.println("참조가 같음");
		} else {
			System.out.println("참조가 다름");
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("문자열 동일");
		}

	}

}
```

```
참조가 동일
문자열 동일
참조가 다름
문자열 동일
```

String 변수에 빈 문자열을 대입할 수도 있다. 빈 문자열도 String 객체로 생성되기 때문에 변수가 빈 문자열을 참조하는지 조사하려면 위와 동일하게 equals() 메소드를 사용해야 한다.

### 문자 추출

문자열에서 특정 위치의 문자를 얻고 싶다면 charAt() 메소드를 이용할 수 있다. charAt() 메소드는 매개값으로 주어진 인덱스의 문자를 리턴한다. 여기서 인덱스란 0에서부터 -1까지의 번호를 말한다.

```java
String subject = "자바 프로그래밍";
char charValue = subject.charAt(3);
```

"자바 프로그래밍"이라는 문자열은 다음과 같이 인덱스를 매길 수 있다. 따라서 charAt(3)은 3번 인덱스 위치에 있는 문자, 즉 '프'가 해당된다.

`자` `바` `   ` `프` `로` `그` `래` `밍`

 0   1   2   3   4    5    6    7

다음 예제는 주민등록번호에서 성별에 해당하는 7번째 문자를 읽고 남자 또는 여자인지를 출력한다.

*CharAtExample.java*

```java
package Chap4_ConditionalAndLoop;

public class CharAtExample {

	public static void main(String[] args) {
		
		String ssn = "9506241230123";
		char sex = ssn.charAt(6);
		switch(sex) {
			case '1':
			case '3':
				System.out.println("남자");
				break;
			case '2':
			case '4':
				System.out.println("여자");
				break;
		}

	}

}
```

```
남자
```

### 문자열 길이

문자열에서 문자의 개수를 얻고 싶다면 length() 메소드를 사용한다.

*LengthExample.java*

```java
package Chap4_ConditionalAndLoop;

public class LengthExample {

	public static void main(String[] args) {
		
		String ssn = "9506241230123";
		int length = ssn.length();
		if(length == 13) {
			System.out.println("자릿수 맞다");
		} else {
			System.out.println("자릿수 틀리다.");
		}

	}

}
```

```
자릿수 맞다
```

### 문자열 대체

문자열에서 특정 문자열을 다른 문자열로 대체하고 싶다면 replace() 메소드를 사용한다. replace() 메소드는 기존 문자열은 그대로 두고, 대체한 새로운 문자열을 리턴한다. 

```java
String oldStr = "자바 프로그래밍";
String newStr = oldStr.replace("자바", "JAVA");
```

String 객체의 문자열은 변경이 불가한 특성을 갖기 때문에 replace() 메소드가 리턴하는 문자열은 원래 문자열의 수정본이 아니라 완전히 새로운 문자열이다. 따라서 newStr 변수는 새로 생성된 "JAVA 프로그래밍" 문자열을 참조한다.

*ReplaceExample.java*

```java
package Chap4_ConditionalAndLoop;

public class ReplaceExample {

	public static void main(String[] args) {
		
		String oldStr = "자바 문자열은 불변이다. 자바 문자열은 String이다.";
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);

	}

}
```

```
자바 문자열은 불변이다. 자바 문자열은 String이다.
JAVA 문자열은 불변이다. JAVA 문자열은 String이다.
```

### 문자열 잘라내기

문자열에서 특정 위치의 문자열을 잘라내어 가져오고 싶다면 substring() 메소드를 사용한다.

| 메소드                                  | 설명                                    |
| --------------------------------------- | --------------------------------------- |
| substring(int beginIndex)               | beginIndex에서 끝까지 잘라내기          |
| substring(int beginIndex, int endIndex) | beginIndex에서 endIndex 앞까지 잘라내기 |

*SubStringExample.java*

```java
package Chap4_ConditionalAndLoop;

public class SubStringExample {

	public static void main(String[] args) {
		
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);

	}

}
```

```
880815
1234567
```

### 문자열 찾기

문자열에서 특정 문자열의 위치를 찾고자 할 때에는 indexOf() 메소드를 사용한다. indexOf() 메소드는 주어진 문자열이 시작되는 인덱스를 리턴한다.

만약 주어진 문자열이 포함되어 있지 않으면 indexOf() 메소드는 -1을 리턴한다. 주어진 문자열이 포함되어 있는지 여부에 따라 실행 코드를 달리하고 싶다면 if 조건식을 사용해서 다음과 같이 코드를 작성할 수 있다.

```java
int index = subject.indexOf("프로그래밍");
if(index == -1) {
    // 포함X
} else {
    // 포함O
}
```

주어진 문자열이 단순히 포함되어 있는지만 조사하고 싶다면 contains() 메소드를 사용하면 편리하다. 원하는 문자열이 포함되어 있으면 contains() 메소드는 true를 리턴하고, 그렇지 않으면 false를 리턴한다.

```java
boolean result = subject.contains("프로그래밍")
```

*IndexOfContainsExample.java*

```java
package Chap4_ConditionalAndLoop;

public class IndexOfContainsExample {

	public static void main(String[] args) {
		
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		String substring = subject.substring(location);
		System.out.println(substring);
		
		location = subject.indexOf("자바");
		if(location != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}
		
		boolean result = subject.contains("자바");
		if(result) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}

	}

}
```

```
3
프로그래밍
자바와 관련된 책
자바와 관련된 책
```

### 문자열 분리

문자열이 구분자를 사용하여 여러 개의 문자열로 구성되어 있을 경우, 이를 따로 분리해서 얻고 싶다면 split() 메소드를 사용한다.

```java
String board = "번호,제목,내용,설명";
String[] arr = board.split(",");
```

board는 쉼표로 구분된 문자열을 가지고 잇다. split() 메소드를 호출할 때 쉼표를 제공하면 분리된 문자열로 구성된 배열(array)을 얻을 수 있다.

*SplitExample.java*

```java
package Chap4_ConditionalAndLoop;

public class SplitExample {

	public static void main(String[] args) {
		
		String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동";
		
		//문자열 분리
		String[] tokens = board.split(",");
		
		//인덱스별로 읽기
		System.out.println("번호 : " + tokens[0]);
		System.out.println("제목 : " + tokens[1]);
		System.out.println("내용 : " + tokens[2]);
		System.out.println("성명 : " + tokens[3]);
		System.out.println();
		
		//for 문을 이용한 읽기
		for(int i=0; i<tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		
	}

}
```

```
번호 : 1
제목 : 자바 학습
내용 : 참조 타입 String을 학습합니다.
성명 : 홍길동

1
자바 학습
참조 타입 String을 학습합니다.
홍길동
```

## 배열(Array) 타입

### 배열 변수 선언

### 값 목록으로 배열 생성

*ArrayCreateByValueListExample1.java*

```java
package Chap4_ConditionalAndLoop;

public class ArrayCreateByValueListExample1 {

	public static void main(String[] args) {
		
		// 배열 변수 선언과 배열 생성
		String[] season = { "Spring", "Summer", "Fall", "Winter" };
		
		// 배열의 항목값 읽기
		System.out.println(season[0]);
		System.out.println(season[1]);
		System.out.println(season[2]);
		System.out.println(season[3]);

	}

}
```

```
Spring
Summer
Fall
Winter
```

### new 연산자로 배열 생성

값의 목록은 없지만 향후 값들을 저장할 목적으로 배열을 미리 생성할 수도 있다. new 연산자를 다음과 같이 사용하면 배열 객체를 생성시킨다. 길이는 배열이 저장할 수 있는 항목 수를 말한다.

```java
타입[] 변수 = new 타입[길이];
```

new 연산자는 해당 길이의 배열을 생성하고 배열의 번지를 리턴하기 때문에 배열 변수에 대입할 수 있다. 이미 배열 변수가 선언된 후에도 다음과 같이 대입이 가능하다.

### 배열 길이

## 다차원 배열

배열 항목에는 또 다른 배열이 대입될 수 있는데, 이러한 배열을 다차원 배열이라고 부른다. 다음은 2차원 배열과 3차원 배열의 모양을 보여준다.

![image-20250419235543336](C:/Users/bb/Desktop/study/Java/assets/image-20250419235543336.png)

배열 변수는 5번지의 1차원 배열을 참조하고, 변수[0]은 다시 10번지 배열을 참조하고, 변수[1]은 30번지 배열을 참조한다. 위 그림처럼 다차원 배열은 1차원 배열을 서로 연결한 것이라고 볼 수 있다. 다차원 배열에서 각 차원의 항목에 접근하는 방법은 다음과 같다.

```java
변수[1차원인덱스][2차원인덱스]...[N차원인덱스]
```

위 그림에서 값1, 값3, 값6을 읽는 방법은 다음과 같다.

```java
변수[0][0][0]		// 값1
변수[0][1][0]		// 값3
변수[1][0][1]		// 값6
```

### 값 목록으로 다차원 배열 생성

값 목록으로 다차원 배열을 생성하려면 배열을 생성하려면 배열 변수 선언 시 타입 뒤에 대괄호 []를 차원의 수만큼 붙이고, 값 목록도 마찬가지로 차원의 수만큼 중괄호를 중첩시킨다. 다음은 값 목록으로 2차원 배열을 생성하고 변수에 대입하는 방법을 보여준다.

```java
타입[][] 변수 = {
    {값1, 값2, ...},	// 1차원 배열의 0인덱스
    {값3, 값4, ...},	// 1차원 배열의 1인덱스
    ...
};
```

### new 연산자로 다차원 배열 생성

*MultidimensionalArrayByNewExample.java*

```java
package Chap4_ConditionalAndLoop;

public class MultidimensionalArrayByNewExample {

	public static void main(String[] args) {
		
		// 각 반의 학생 수가 3명으로 동일할 경우 점수 저장을 위한 2차원 배열 생성
		int[][] mathScores = new int[2][3];
		// 배열 항목 초기값 출력
		for(int i=0; i<mathScores.length; i++) {
			for(int k=0; k<mathScores[i].length; k++) {
				System.out.println("mathScores[" + i + "][" + k +"]: " +
				mathScores[i][k]);
			}
		}
		System.out.println();
		
		// 배열 항목 값 변경
		mathScores[0][0] = 80;
		mathScores[0][1] = 83;
		mathScores[0][2] = 85;
		mathScores[1][0] = 86;
		mathScores[1][1] = 90;
		mathScores[1][2] = 92;
		
		// 전체 학생의 수학 평균 구하기
		int totalStudent = 0;
		int totalMathSum = 0;
		for(int i=0; i<mathScores.length; i++) { // 반의 수만큼 반복
			totalStudent += mathScores[i].length;	// 반의 학생 수 합산
			for(int k=0; k<mathScores[i].length; k++) { // 해당 반의 학생 수만큼 반복
				totalMathSum += mathScores[i][k];	// 학생 점수 합산
			}
		}
		
		// 각 반의 학생 수가 다를 경우 점수 저장을 위한 2차원 배열 생성
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		// 배열 항목 초기값 출력
		for(int i=0; i<englishScores.length; i++) {
			for(int k=0; k<englishScores[i].length; k++) {
				System.out.println("englishScores[" + i + "][" + k + "]:" +
				englishScores[i][k]);
			}
		}
		System.out.println();

	}

}
```

```
englishScores[0][0]:0
englishScores[0][1]:0
englishScores[1][0]:0
englishScores[1][1]:0
englishScores[1][2]:0
```

## 객체를 참조하는 배열

기본 타입 배열은 각 항목에 값을 직접 저장하지만, 참조 타입 배열은 각 항목에 객체의 번지를 저장한다. 

*ArrayReferenceObjectExample.java*

```java
package Chap4_ConditionalAndLoop;

public class ArrayReferenceObjectExample {

	public static void main(String[] args) {
		
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";	// 0번째 항목과 동일한 String 객체 참조
		strArray[2] = new String("Java");	// 다른 String 객체 생성
		
		System.out.println(strArray[0] == strArray[1]);
		System.out.println(strArray[0] == strArray[2]);
		System.out.println(strArray[0].equals(strArray[2]));
		
	}

}
```

```
true
false
true
```

## 배열 복사

배열은 한 번 생성하면 길이를 변경할 수 없다. 더 많은 저장 공간이 필요하다면 더 큰 길이의 배열을 새로 만들고 이전 배열로부터 항목들을 복사해야 한다. 채워지지 않은 배열 항목에는 0, false, null이 들어간다. 

* 숫자 타입 배열

  * 정수형

    초기값은 0이다.

  * 실수형

    초기값은 0.0이다.

* 논리 타입 배열

  초기값은 false이다.

* 참조 타입 배열

  초기값은 null이다.

## 배열 항목 반복을 위한 향상된 for 문

자바는 배열 및 컬렉션을 좀 더 쉽게 처리할 목적으로 다음과 같은 for문을 제공한다. 카운터 변수와 증감식을 사용하지 않고, 항목의 개수만큼 반복한 후 자동으로 for문을 빠져나간다.

```java
for ( 타입 변수 : 배열 ) {
    실행문;
}
```

for 문이 실행되면 배열에서 가져올 항목이 잇을 경우 변수에 항목을 저장하고, 실행문을 실행한다. 다음 항목이 없으면 for 문을 종료한다.

*AdvancedForExample.java*

```java
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
```

```
총합 : 430
평균 : 86.0
```

## main() 메소드의 String[] 매개변수 용도

자바 프로그램을 실행하기 위해 지금까지 main() 메소드를 작성했는데, 여기에서 문자열 배열 형태인 String[] args 매개변수가 왜 필요한지 알아보자.

윈도우의 명령 프롬프트나 맥OS의 터미널에서 프로그램을 실행할 때는 요구하는 값이 있을 수 있다. 예를 들어 두 수를 입력받고 덧셈을 수행하는 Sum 프로그램은 실행할 때 다음과 같이 두 수를 요구할 수 있다.

```java
java Sum 10 20
```

공백으로 구분된 10과 20은 문자열로 취급되며 String[] 배열의 항목 값으로 구성된다. 그리고 main() 메소드 호출 시 매개값으로 전달된다.

main() 메소드 중괄호 내에서 문자열 "10"과 "20"은 다음과 같이 얻을 수 있다.

```java
String x = args[0];
String y = args[1];
```

*MainStringArrayArgument.java*

```java
package Chap4_ConditionalAndLoop;

public class MainStringArrayArgument {

	public static void main(String[] args) {

		if(args.length != 2) {
			System.out.println("입력값 부족");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);

	}

}
```

```
입력값 부족
```

![image-20250420022555116](C:/Users/bb/Desktop/study/Java/assets/image-20250420022555116.png)

![image-20250420022630582](C:/Users/bb/Desktop/study/Java/assets/image-20250420022630582.png)

![image-20250420022653685](C:/Users/bb/Desktop/study/Java/assets/image-20250420022653685.png)

```
10 + 20 = 30
```

cf) : 명령 프롬프트나 터미널에서 입력값 주기

## 열거(Enum) 타입

데이터 중에는 몇 가지로 한정된 값을 갖는 경우가 있다. 이와 같이 한정된 값을 갖는 타입을 열거(enumeration type)이라고 한다.

열거 타입을 사용하기 위해서는 먼저 열거 타입 이름으로 소스 파일(.java)을 생성하고 한정된 값을 코드로 정의해야 한다. 열거 타입 이름은 캐멀 케이스로 지어주는 것이 관례이다.

요일을 저장할 수 있는 열거 타입인 Week를 이클립스에서 생성한다(New - Enum).

*Week.java*

```java
package Chap5_ReferenceType;

public enum Week {
	
	Monday,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATUERDAY,
	SUNDAY

}
```

열거 타입도 하나의 데이터 타입이므로 변수를 선언하고 사용해야 한다. 열거 타입 Week로 변수를 선언하면 다음과 같다.

```java
Week today;
Week reservationDay;
```

```java
Week today = Week.SUNDAY;
```

컴퓨터의 날짜 및 요일, 시간을 얻을 때는 Calendar를 이용한다.

```java
Calendar now = Calendar.getInstance();		// Calender 객체 얻기
int year = now.get(Calendar.YEAR);			// 연
int month = now.get(Calendar.MONTH) + 1;	// 월(1~12)
int week = now.get(Calendar.DAY_OF_MONTH);	// 일
int day = now.get(Calendar.DAY_OF_WEEK);	// 요일(1~7)
int hour = now.get(Calendar.HOUR);			// 시간
int minute = now.get(Calendar.MINUTE);		// 분
int second = now.get(Calendar.SECOND);		// 초
```

*WeekExample.java*

```java
package Chap5_ReferenceType;

import java.util.Calendar;

public class WeekExample {

	public static void main(String[] args) {
		
		// Week 열거 타입 변수 선언
		Week today = null;
		
		// Calendar 얻기
		Calendar cal = Calendar.getInstance();
		
		// 오늘의 요일 얻기(1~7)
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		// 숫자를 열거 상수로 변환해서 변수에 대입
		switch(week) {
			case 1: today = Week.SUNDAY;	break;
			case 2: today = Week.MONDAY;	break;
			case 3: today = Week.TUESDAY;	break;
			case 4: today = Week.WEDNESDAY;	break;
			case 5: today = Week.THURSDAY;	break;
			case 6: today = Week.FRIDAY;	break;
			case 7: today = Week.SATURDAY;	break;
		}
		
		// 열거 타입 변수를 사용
		if(today == Week.SUNDAY) {
			System.out.println("일욜");
		} else {
			System.out.println("일욜아님");
		}

	}

}
```

```
일욜
```

