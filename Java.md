# 자바 개요

## 프로그래밍 언어와 자바

컴퓨터가 이해할 수 있는 기계어는 우리가 일상생활에서 사용하는 언어와는 너무나도 다른 0과 1로 이루어진 이진 코드를 사용한다. 반대로 사람이 사용하는 언어는 컴퓨터 입장에서 보면 이해할 수 없는 문자의 집합이다. 그렇기 때문에 사람과 컴퓨터가 대화하기 위해서는 사람의 언어와 기계어의 다리 역할을 하는 프로그래밍 언어가 필요하다.

프로그래밍 언어는 고급 언어와 저급 언어로 구분된다. 고급 언어란 컴퓨터와 대화할 수 있도록 만든 언어 중에서 사람이 쉽게 이해할 수 있는 언어를 말한다. 고급 언어로 작성된 소스 파일은 컴퓨터가 바로 이해할 수 없기 때문에 컴파일이라는 과정을 통해서 컴퓨터가 이해할 수 있는 0과 1로 이루어진 기계어로 변환한 후 컴퓨터가 사용하게 된다. 반대로 저급 언어란 기계어에 가까운 언어를 말하는데, 대표적으로 어셈블리어가 저급 언어에 속한다.

개발자가 고급 언어로 작성한 파일을 소스 파일이라고 부른다. 고급 언어에는 많은 종류가 있다. 대표적으로 자바, C, C++, C#, 파이썬 등이 있다.

자바는 1995년도에 처음 썬 마이크로시스템즈에서 발표한 후, 가장 성공한 프로그래밍 언어로서 전세계적으로 다양한 분야에서 사용되고 있다. 안드로이드 폰에서 실행하는 애플리케이션뿐만 아니라, 웹 사이트를 개발하는 핵심 언어로 사용되고 있다. 그리고 모든 운영체제에서 실행 가능한 데스크톱 애플리케이션도 개발할 수 있다.

자바는 오라클에서 라이선스를 가지고 있다. 오라클은 자바 개발 도구를 배포하여 자바로 프로그램을 쉽게 개발할 수 있도록 기술적 지원을 하고 있다. 자바는 다른 프로그래밍 언어에 비해 다음과 같은 특징이 있다.

* 모든 운영체제에서 실행 가능

  자바로 작성된 프로그램은 운영체제와 상관없이 모두 실행되기 때문에 윈도우에서 개발된 프로그램을 수정 없이 바로 맥OS 또는 리눅스에서도 실행할 수 있다는 장점이 있다.

* 객체 지향 프로그래밍

  먼저 객체(부품)를 만들고, 이 객체들을 서로 연결해서 더 큰 프로그램을 완성시키는 기법을 객체 지향 프로그래밍(Object Oriented Programming, OOP)이라고 한다. 자바는 OOP를 위한 최적의 언어이다.

* 메모리 자동 정리

  자바는 메모리(RAM)를 자동 관리하므로, 개발자는 메모리 관리의 수고스러움을 덜고 핵심 기능 작성에 집중할 수 있다.

* 무료 라이브러리 풍부

  무료로 다운로드해서 사용할 수 있는 오픈 소스 라이브러리가 풍부하기 때문에 프로그램 개발 기간을 단축시켜준다.

## 운영체제별 JDK 설치

자바 프로그램을 개발하고 실행하기 위해서는 먼저 Java SE의 구현체인 JDK를 설치해야 한다. JDK에는 OpenJDK와 Oracle JDK가 있다.

| 구분                | Open JDK          | Oracle JDK                           |
| ------------------- | ----------------- | ------------------------------------ |
| 라이선스            | GNU GPL version 2 | Oracle Technology Network License    |
| 사용료              | 무료              | 개발 및 학습용 : 무료, 상업용 : 유료 |
| 개발 소스 공개 의무 | 없음              | 없음                                 |

Oracle JDK는 Open JDK보다 응답성과 JVM 성능이 상대적으로 뛰어나다. 하지만 Open JDK의 성능도 지속석으로 향상되고 있으며, 더욱 안정화되었기 때문에 JDK 비용을 고려한다면 Open JDK를 사용하는 것이 유리하다. 

JDK LTS 버전은 장기간 기술 지원을 받을 수 있기 때문에 다른 버전보다는 안정적으로 사용할 수 있다. JDK 8, JDK 11, JDK 17이 LTS 버전이며, 이 버전으로 개발 및 실행하는 것이 좋다. 그래서 Open JDK 17 버전을 사용한다.

## 바이트코드 파일과 자바 가상 머신

JDK를 설치했다면 이제 자바 언어로 작성한 소스 파일을 만들고 컴파일할 수 있다. 자바 소스 파일의 확장명은 .java이다. 텍스트 파일이므로 어떤 텍스트 에디터에서도 작성이 가능하다.

### 바이트코드 파일

소스 파일(.java)을 작성한 후에는 컴파일을 해야 한다. javac(java compiler) 명령어는 소스 파일을 컴파일하는데, 컴파일 결과는 확장명이 .class인 바이트코드 파일로 생성된다. 

윈도우, 맥OS, 리눅스 등 어떤 운영체제라 하더라도 동일한 소스 파일을 javac로 컴파일하면 모두 동일한 바이트코드 파일이 생성된다.

### 자바 가상 머신

바이트코드 파일(~.class)을 특정 운영체제가 이해하는 기계어로 번역하고 실행시키는 명령어는 java이다. java 명령어는 JDK와 함께 설치된 자바 가상 머신을 구동시켜 바이트코드 파일을 완전한 기계어로 번역하고 실행시킨다.

바이트코드 파일은 운영체제와 상관없이 모두 동일한 내용으로 생성되지만, 자바 가상 머신은 운영체제에서 이해하는 기계어로 번역해야 하므로 운영체제별로 다르게 설치된다. 그래서 운영체제별로 설치하는 JDK가 다른 것이다.

## 소스 작성부터 실행까지

1. 사용자 홈에서 temp 디렉터리를 다음 구조로 생성하고, Hello.java 소스 파일을 생성한다.

   ```
   ~/temp
       ├── src
       │   └── ch01
       │       └── sec06
       │           └── Hello.java
       └── bin
   ```

   ※ 패키지란?

   자바는 소스 파일 및 컴파일된 바이트코드 파일을 쉽게 관리하기 위해 패키지를 사용한다. 패키지는 마치 파일 시스템의 디렉터리와 비슷하다. 

2. Hello.java를 텍스트 에디터에서 열고, 다음과 같이 코드를 작성한다.

   ```java
   package ch01 .sec06
       
   public class Hello {
       public static void main(String[] args) { // 바이트코드 파일을 실행하면 이 main() 메소드 블록이 실행된다.
           System.out.println("Hello, Java");
       }
   }
   ```

3. 소스 파일을 javac 명령어로 컴파일한다. 

   ```
   javac -d [바이트코드파일저장위치] [소스경로/*.java]
   ```

   ```
   temp/bin 디렉터리에 바이트코드 파일(ch01/sec06/Hello.class)이 생성
   ```

4. java 명령어로 바이트코드 파일을 기계어로 번역하고 실행한다. 여전히 명령 프롬프트와 터미널의 현재 위치는 사용자 홈의 temp 디렉터리이다. 주의할 점은 .class를 제외한 Hello만 입력해야 한다.

   ```
   java -cp [바이트코드파일위치] [패키지...클래스명]
   ```

   ```
   콘솔에 Hello, Java가 출력
   ```

   javac로 컴파일을 하면 운영체제에 독립적인 바이트코드 파일(*.class)이 생성되기 때문이다.

※ 자동 컴파일된 바이트코드 파일은 어디에?

Hello.java 소스 파일을 작성하고 자동 컴파일된 바이트코드 파일(Hello.class)은 thisisjava 프로젝트 디렉터리 안 bin 디렉터리에 패키지 디렉터리와 함께 저장된다. 

# 변수와 타입

## 변수 선언

컴퓨터 메모리(RAM)는 수많은 번지들로 구성된 데이터 저장 공간이다. 프로그램은 데이터를 메모리에 저장하고 읽는 작업을 빈번히 수행한다. 이때 데이터를 어디에, 어떤 방식으로 저장할지 정해져 있지 않다면 메모리 관리가 무척 어려워진다. 프로그래밍 언어는 이 문제를 해결하기 위해 변수를사용한다.

변수는 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름이다. 변수를 통해 프로그램은 메모리 번지에 값을 저장하고 읽을 수 있다.

**변수 = 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름**

자바의 변수는 다양한 타입의 값을 저장할 수 없다. 즉, 정수형 변수에는 정수값만 저장할 수 있고, 실수형 변수에는 실수값만 저장할 수 있다.

변수를 사용하려면 변수 선언이 필요한데, 변수 선언은 어떤 타입의 데이터를 저장할 것인지 그리고 변수 이름이 무엇인지를 결정하는 것이다.

변수 이름은 첫 번째 글자가 문자여야 하고, 중간부터는 문자, 숫자, $, ...를 포함할 수 있다. 또한, 첫 문자를 소문자로 시작하되 캐멀 스타일로 작성하는 것이 관례이다.

변수가 선언되었다면 값을 저장할 수 있는데, 이때 대입 연산자인 =를 사용한다. 수학에서 등호(=)는 '같다'라는 의미지만, 자바에서는 우측 값을 좌측 변수에 대입하는 연산자로 사용된다.

변수 선언은 저장되는 값의 타입과 이름만 결정한 것이지, 아직 메모리에 할당된 것은 아니다. 변수에 최초로 값이 대입될 때 메모리에 할당되고, 해당 메모리에 값이 저장된다.

변수에 최초로 값을 대입하는 행위를 변수 초기화라고 하고, 이때의 값을 초기값이라고 한다. 초기값은 다음과 같이 변수를 선언함과 동시에 대입할 수도 있다.

초기화되지 않은 변수는 아직 메모리에 할당되지 않았기 때문에 변수를 통해 메모리 값을 읽을 수 없다. 따라서 다음은 잘못된 코딩이다.

```java
int value; // 변수 선언은 하였으나 초기화되지 않음
int result = value + 10; // 변수 value 값을 읽고 10을 더해서 변수 result에 저장
```

위 코드를 수정하자면 다음과 같다.

```java
int value = 30; // 변수 value가 30으로 초기화됨
int result = value + 10; // 변수 value 값(30)을 읽고 10을 더해서 변수 result에 저장
```

다음 예제는 초기화되지 않은 변수를 연산식에 사용할 경우 컴파일 에러가 발생하는 것을 보여준다.

*VariableInitializationExample.java*

```java
public class VariableInitializationExample {

	public static void main(String[] args) {
		
		// 변수 value 선언
		int value;
		
		// 연산 결과를 변수 result의 초기값으로 대입
		int result = value + 10;
		
		// 변수 result 값을 읽고 콘솔에 출력
		System.out.println(result);
	}

}
```

![image-20250415002354155](./assets/image-20250415002354155.png)

변수는 출력문이나 연산식에 사용되어 변수값을 활용한다. 다음 예제는 변수를 문자열과 결합 후 출력하거나 연산식에서 활용하는 모습을 보여준다.

*VariableUseExample.java*

```java
public class VariableUseExample {

	public static void main(String[] args) {
		
		int hour = 3;
		int minute = 5;
		System.out.println(hour + " 시간 " + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총 " + totalMinute + "분");
	}

}
```

![image-20250415002803175](./assets/image-20250415002803175.png)

변수는 또 다른 변수에 대입되어 메모리 간에 값을 복사할 수 있다. 다음 코드는 변수 x값을 변수 y값으로 복사한다.

```java
int x = 10;
int y = x;
```

다음 예제는 두 변수의 값을 교환하는 방법을 보여준다. 두 변수의 값을 교환하기 위해서 새로운 변수 temp를 선언한 것에 주목한다.

*VariableExchangeExample.java*

```java
public class VariableExchangeExample {

	public static void main(String[] args) {
		
		int x = 3;
		int y = 5;
		System.out.println("x:" + x + ", y" + y);

		int temp = x;
		x = y;
		y = temp;
		System.out.println("x:" + x + ", y" + y);
	}

}
```

![image-20250415003222113](./assets/image-20250415003222113.png)

## 정수 타입

변수는 선언될 때의 타입에 따라 저장할 수 있는 값의 종류와 허용 범위가 달라진다. 자바는 정수, 실수, 논리값을 저장할 수 있는 기본 타입 8개를 다음과 같이 제공한다.

| 값의 분류        | 기본 타입                    |
| ---------------- | ---------------------------- |
| 정수             | byte, char, short, int, long |
| 실수             | float, double                |
| 논리(true/false) | boolean                      |

정수 타입은 총 5개로, 다음과 같이 메모리 할당 크키와 저장되는 값의 범위를 가지고 있다.

| 타입  | 메모리 크기 | 저장되는 값의 허용 범위 | 저장되는 값의 허용 범위                                |
| ----- | ----------- | ----------------------- | ------------------------------------------------------ |
| byte  | 1byte*      | -2^7 - (2^7-1)          | -128 ~ 127                                             |
| short | 2byte       | -2^15 - (2^15-1)        | -32768 - 32767                                         |
| char  | 2byte       | 0 - (2^16-1)            | 0 - 65535                                              |
| int   | 4byte       | -2^31 - (2^31-1)        | -2,147,483,648 - 2,147,483,643                         |
| long  | 8byte       | -2^63 - (2^63-1)        | -9,233,372,036,854,775,808 - 9,223,372,036,854,775,807 |

각 타입에 저장되는 값의 허용 범위를 모두 외울 필요는 없다. 하지만 메모리 할당 크기는 알아야 한다. 정수 타입을 메모리 사용 크기순으로 나열하면 다음과 같다.

| 종류                       | byte | short | int  | long |
| -------------------------- | ---- | ----- | ---- | ---- |
| 메모리 사용 크기(단위 bit) | 8    | 16    | 32   | 64   |

메모리 크기를 n이라고 할 때 정수 타입은 다음과 같은 동일한 구조의 2진수로 저장된다.

![image-20250414233752573](./assets/image-20250414233752573.png)

byte, short, int, long은 모두 부호 있는(signed) 정수 타입이므로 최상위 bit는 부호 bit로 사용되고, 나머지 bit는 값의 범위를 결정한다.

![image-20250414234149007](./assets/image-20250414234149007.png)

값의 범위는 위, 아래 차례대로 0 ~ (2^(n-1) - 1) 과 -2^(n-1) ~ -1이다.

예를 들어 byte 타입은 최상위 bit를 부호 비트로 사용하고 나머지 7bit로 값의 범위를 결정한다.

최상위 bit가 1인 음수의 경우 7개의 bit를 모두 1의 보수(1은 0, 0은 1)로 바꾸고 1을 더한 값에 -를 붙이면 10진수가 된다. 

![image-20250414235652362](./assets/image-20250414235652362.png)

코드에서 프로그래머가 직접 입력한 값을 리터럴이라고 부르는데, 변수에 대입할 정수 리터럴은 진수에 따라 작성하는 방법이 다르다.

* 2진수 : 0b 또는 0B로 시작하고 0과 1로 작성

  ```java
  int x = 0b1011;
  int y = 0B10100;
  ```

* 8진수 : 0으로 시작하고 0-7 숫자로 작성

  ```java
  int x = 013;
  int y = 0206;
  ```

* 10진수 : 소수점이 없는 0-9 숫자로 작성

  ```java
  int x = 12;
  int y = 365;
  ```

* 16진수 : 0x 또는 0X로 시작하고 0-9 숫자나 A, B, C, D, E, F 또는 a, b, c, d, e, f로 작성

  ```java
  int x = 0xB3;
  int y = 0x2A0F;
  ```

다음 예제는 다양한 정수 리터럴을 int 타입 변수에 대입하고 10진수로 출력한다.

*IntegerLiteralExample.java*

```java
public class IntegerLiteralExample {

	public static void main(String[] args) {
		
		int var1 = 0b1011;
		int var2 = 0206;
		int var3 = 365;
		int var4 = 0xB3;
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
	}

}
```

![image-20250415003552407](./assets/image-20250415003552407.png)

다음 예제는 byte 타입 변수에 허용 범위를 초과한 값을 대입했을 경우 컴파일 오류가 발생하는 것을 보여준다.

*ByteExample.java*

```java

public class ByteExample {

	public static void main(String[] args) {

		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
		byte var6 = 128;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);

	}

}
```

![image-20250415003926809](./assets/image-20250415003926809.png)

long 타입은 수치가 큰 데이터를 다루는 프로그램에서 사용된다. 예를 들어 은행이나 과학 분야에서 사용되는 프로그램들이다. 기본적으로 컴파일러는 정수 리터럴을 int 타입 값으로 간주하기 때문에, int 타입의 허용 범위를 초과하는 리터럴은 뒤에 소문자 'l'이나 대문자 'L'을 붙여 long 타입 값을 컴파일러에게 알려줘야 한다.

*LongExample.java*

```java
public class LongExample {
	public static void main(String[] args) {
		long var1 = 10;
		long var2 = 20L;
		long var3 = 100000000000;
		long var4 = 100000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var4);
	}
}
```

![image-20250415011437167](./assets/image-20250415011437167.png)

## 문자 타입

하나의 문자를 작은따옴표로 감싼 것을 문자 리터럴이라고 한다. 문자 리터럴은 유니코드로 변환되어 저장되는데, 유니코드는 세계 각국의 문자를 0-65535 숫자로 매핑한 국제 표준 규약이다. 자바는 이러한 유니코드를 저장할 수 있도록 char 타입을 제공한다.

```java
char var1 = 'A';
char var3 = '가';
```

유니코드가 정수이므로 char 타입도 정수 타입에 속한다. 그렇기 때문에 char 변수에 작은따옴표로 감싼 문자가 아니라 유니코드 숫자를 직접 대입할 수도 있다.

```java
char c = 65;
char c = 0x0041;
```

*CharExample.java*

```java
public class CharExample {

	public static void main(String[] args) {
		
		char c1 = 'A';
		char c2 = 65;
		
		char c3 = '가';
		char c4 = 44032;
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);

	}

}
```

![image-20250415011905139](./assets/image-20250415011905139.png)

char 타입의 변수에 어떤 문자도 대입하지 않고 단순히 초기화를 할 목적으로 다음과 같이 작은따옴표 두 개를 연달아 붙인 빈 문자를 대입하면 컴파일 에러가 발생한다. 이 경우에는 공백(유니코드:32) 하나를 포함해서 초기화해야 한다.

```java
char c = '';     // 컴파일 에러
char c = ' ';    // 공백 하나를 포함해서 초기화
```

## 실수 타입

실수 타입에는 float과 double이 있으며 다음과 같이 메모리 할당 크기와 저장되는 값의 범위를 가지고 있다.

| 타입   | 메모리 크기 | 저장되는 값의 허용 범위(양수 기준) | 유효 소수 이하 자리 |
| ------ | ----------- | ---------------------------------- | ------------------- |
| float  | 4byte       | 1.4 x 10^-45 - 3.4 x 10^38         | 7자리               |
| double | 8byte       | 4.9 x 10^-324 - 1.8 x 10^308       | 15자리              |

그림을 보면 double 타입이 큰 실수를 저장할 수도 있고 정밀도 또한 높은 것을 볼 수 있다.

**float 타입**

![image-20250415013316815](./assets/image-20250415013316815.png)

**double 타입**

<img src="./assets/image-20250415013435756.png" alt="image-20250415013435756" style="zoom:80%;" />

자바는 IEEE 754 표준에 근거해서 float 타입과 double 타입의 값을 부동 소수점 방식으로 메모리에 저장한다.

float 타입과 double 타입은 가수와 지수를 저장하기 위해 전체 bit를 다음과 같이 나누어 사용한다.

* float : 부호(1bit) + 지수(8bit) + 가수(23bit) = 32bit = 4byte
* double : 부호(1bit) + 지수(11bit) + 가수(52bit) = 64bit = 8byte

최상위 1bit는 양수 및 음수를 결정짓는 부호 bit로 0이면 양수, 1이면 음수가 된다. 지수는 float 타입은 8bit, double 타입은 11bit로 표현하고 나머지 bit는 모두 기수를 표현하는 데 사용된다. double은 float보다 지수와 가수 부분의 bit 수가 크기 때문에 더 크고 정밀한 실수를 저장할 수 있다. 코드에서 실수 리터럴은 다음과 같이 작성할 수 있다.

* 10진수 리터럴

  ```java
  double x = 0.25;
  double y = -3.14;
  ```

* e 또는 E가 포함된 10의 거듭제곱 리터럴

  ```java
  double x = 5e2;			// 5.0 x 10^2 = 500.0
  double y = 0.12E-2;		// 0.12 x 10^-2 = 0.0012
  ```

컴파일러는 실수 리터럴을 기본적으로 double 타입으로 해석하기 때문에 double 타입 변수에 대입해야 한다. float 타입에 대입하고 싶다면 리터럴 뒤에 소문자 'f'나 대문자 'F'를 붙여 컴파일러가 float 타입임을 알 수 있도록 해야 한다.

```java
double var = 3.14;
double var = 314e-2;
```

```java
float var = 3.14f;
float var = 3E6F;
```

다음 예제는 float과 double 타입의 소수 이하 유효 자릿수를 확인한다. double 타입은 float 타입 보다 약 2배의 유효 자릿수를 가지기 때문에 보다 정확한 데이터 저장이 가능하다. double이라는 이름도 float보다 약 2배의 정밀도를 갖는다는 의미에서 붙여진 것이다. 확인 후에는 10의 거듭 제곱 리터럴을 대입해서 출력해보자.

*FloatDoubleExample.java*

```java
public class FloatDoubleExample {

	public static void main(String[] args) {
		
		// 정밀도 확인
		float var1 = 0.1234567890123456789f;
		double var2 = 0.1234567890123456789;
		System.out.println(var1);
		System.out.println(var2);
		
		// 10의 거듭제곱 리터럴
		double var3 = 3e6;
		float var4 = 3e6F;
		double var5 = 2e-3;
		
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
	}

}
```

![image-20250415014848345](./assets/image-20250415014848345.png)

## 논리 타입

참과 거짓을 의미하는 논리 리터럴은 true와 false이다. 논리 리터럴은 boolean 타입 변수에 다음과 같이 대입할 수 있다.

```java
boolean stop = true;
boolean stop = false;
```

boolean 타입 변수는 주로 두 가지 상태값을 저장할 필요가 있을 경우에 사용되며, 상태값에 따라 조건문과 제어문의 실행 흐름을 변경하는 데 사용된다. 연산식 중에서 비교 및 논리 연산의 산출값은 true 또는 false이므로 boolean 타입 변수에 다음과 같이 대입할 수 있다.

```java
int x = 10;
boolean result1 = (x == 20);
boolean result2 = (x != 20);
boolean result3 = (x > 20);
boolean result4 = (0 < x && x < 20);
boolean result5 = (x < 0 || x > 200);
```

다음 예제는 stop 변수값에 따라 if 블록과 else 블록 중 하나를 실행하고, 연산식의 결과를 boolean 변수에 저장해서 출력한다.

*BooleanExample.java*

```java
public class BooleanExample {

	public static void main(String[] args) {
		
		boolean stop = true;
		
		if(stop) {
			System.out.println("stop");
		} else {
			System.out.println("start");
		}
		
		int x = 10;
		boolean result1 = (x == 20);
		boolean result2 = (x != 20);
		
		System.out.println(result1);
		System.out.println(result2);

	}

}
```

![image-20250415015539830](./assets/image-20250415015539830.png)

## 문자열 타입

