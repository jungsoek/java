# 연산자

## 부호/증감 연산자

### 부호 연산자

부호 연산자는 변수의 부호를 유지하거나 변경한다.

| 연산식     | 설명                 |
| ---------- | -------------------- |
| + 피연산자 | 피연산자의 부호 유지 |
| - 피연산자 | 피연산자의 부호 변경 |

`+` 연산자는 잘 사용되지 않고, `-` 연산자는 변수값의 부호를 변경할 때 사용된다. 주의할 점은 부호 변경 후의 타입이다. 다음 코드는 컴파일 에러가 발생한다.

```java
byte b = 100;
byte result = -b;	// 컴파일 에러
```

정수 타입(byte, short, int) 연산의 결과는 int 타입이다. 부호를 변경하는 것도 연산이므로 다음과 같이 int 타입 변수에 대입해야 한다.

```java
byte b = 100;
int result = -b;
```

*SignOperatorExample.java*

```java
package Chap3_Operator;

public class SignOperatorExample {

	public static void main(String[] args) {
		
		int x = -100;
		x = -x;
		System.out.println(x);
		
		byte b = 100;
		int y = -b;
		System.out.println(y);

	}

}
```

```
100
-100
```

### 증감 연산자

증감 연산자(++, --)는 변수의 값을 1 증가시키거나 1 감소시키는 연산자이다.

| 연산식      | 설명                                             |
| ----------- | ------------------------------------------------ |
| ++ 피연산자 | 피연산자의 값을 1 증가시킴                       |
| -- 피연산자 | 피연산자의 값을 1 감소시킴                       |
| 피연산자 ++ | 다른 연산을 수행 후에 피연산자의 값을 1 증가시킴 |
| 피연산자 -- | 다른 연산을 수행 후에 피연산자의 값을 1 감소시킴 |

변수 단독으로 증감 연산자가 사용될 경우에는 변수의 앞뒤 어디에든 붙어도 결과는 동일하다.

하지만 여러 개의 연산자가 포함되어 있는 연산식에서는 증감 연산자의 위치에 따라 결과가 달라진다. 

* 전위 증감 연산자 

  증감 연산자가 변수 앞에 있으면 변수 사용 전 연산한다. 즉, 메모리에 저장된 값을 변경 후, 그 새로운 값을 사용한다.

* 후위 증감 연산자

  증감 연산자가 변수 뒤에 있으면 변수 사용 후 연산한다. 즉, 메모리에 저장된 값을 사용 후, 메모리에 저장한다.

cf) : 여기서 변수를 사용한다는 것은 메모리에 변수를 저장한다는 것 역시 포함된다.

```java
int x = 1;
int y = 1;
int result1 = ++x + 10;		// x를 1증가	// int result1 = 2 + 10;
int result2 = y++ + 10;		// int result2 = 1 + 10;	// y를 1 증가
```

위 코드에서 result1과 result2에는 각각 12와 11이 저장된다. 그리고 최종 x와 y의 값은 2가 된다.

*IncreaseDecreaseOperatorExample.java*

```java
package Chap3_Operator;

public class IncreaseDecreaseOperatorExample {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		int z;
		
		x++;
		++x;
		System.out.println("x = " + x); 
		
		System.out.println("---------------------");
		
		y--;
		--y;
		System.out.println("y = " + y); 
		
		System.out.println("---------------------");
		
		z = x++;
		System.out.println("z = " + z); 
		System.out.println("x = " + x);
		
		System.out.println("---------------------");
		
		z = ++x;
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		
		System.out.println("---------------------");
		
		z = ++x + y++;
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		System.out.println("y = " + y);

	}

}
```

```
x = 12
---------------------
y = 8
---------------------
z = 12
x = 13
---------------------
z = 14
x = 14
---------------------
z = 23
x = 15
y = 9
```

## 산술 연산자

산술 연산자는 +, -, *, /, %로 총 5개이다.

| 연산식              | 설명                                       |
| ------------------- | ------------------------------------------ |
| 피연산자 + 피연산자 | 덧셈 연산                                  |
| 피연산자 - 피연산자 | 뺄셈 연산                                  |
| 피연산자 * 피연산자 | 곱셈 연산                                  |
| 피연산자 / 피연산자 | 나눗셈 연산(피연산자의 타입에 따라 다르다) |
| 피연산자 % 피연산자 | 나눗셈의 나머지를 산출하는 연산            |

산술 연산의 특징은 다음과 같다.

* 피연산자가 정수 타입(byte, short, char, int)이면 연산 결과는 int 타입이다.
* 피연산자가 정수 타입이고 그 중 하나가 long 타입이면 연산의 결과는 long 타입이다.
* 피연산자 중 하나가 실수 타입이면 연산의 결과는 실수 타입이다.

*ArithmeticOperatorExample.java*

```java
package Chap3_Operator;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		
		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;
		
		int result1 = v1 + v2;	// 모든 피연산자는 int 타입으로 자동 변환 후 연산
		System.out.println(result1);
		
		long result2 = v1 + v2 - v4;	// 모든 피연산자는 long 타입으로 자동 변환 후 연산
		System.out.println(result2);
		
		double result3 = (double) v1 / v2;	// double 타입으로 강제 변환 후 연산
		System.out.println(result3);
		
		int result4 = v1 % v2;
		System.out.println(result4);

	}

}
```

```
14
4
2.5
2
```

위 코드에서

```java
double result3 = (double) v1 / v2;	// double 타입으로 강제 변환 후 연산
```

를 보면 v1만 강제 타입 변환이 되고 v2는 자동 타입 변환된다. 데이터 타입이 다른 피연산자가 연산에 참여할 때 자바는 더 큰 범위를 지원하는 데이터 타입으로 작은 타입을 자동으로 변환한다. 이를 타입 승격이라고 한다.

메모리와 JVM 관점에서 보면, v1과 v2는 메서드 내부의 스택 영역에 저장된다. 이때, v1과 v2는 각각 byte 형으로 저장된다. 이후 JVM은 (double) v1 구문의 타입 변환을 수행한다. 그다음 JVM은 v2를 자동으로 타입을 double로 변환한다. 이 작업은 JVM이 값을 계산하기 위하여 연산 중 임시메모리를 생성하여 처리한다. 변환된 v2의 double 값은 스택의 연산 영역(Operand Stack)에 저장된다.

## 오버플로우와 언더플로우

오버플로우란 타입이 허용하는 최대값을 벗어나는 것을 말한다. 반대로 언더플로우는 타입이 허용하는 최소값을 벗어나는 것을 말한다. 정수 타입 연산에서 오버플로우 또는 언더플로우가 발생하면 값이 잘리고 순환된 값이 메모리에 저장된다. 잘려진 값은 저장되지 않고 버려진다. 다만, 오버플로우 여부를 기록하기 위해 상태 레지스터에 플래그가 설정된다. 

순환된 값이 메모리에 저장되는 예를 보면 byte 타입일 경우 최대값을 127에서 1을 더하면 128이 되어 오버플로우가 발생하여 연산 결과는 최소값인 -128이 된다. 그리고 다시 1을 더하면 -127이 된다.

```java
byte value = 127;
value++;	// value 값에 1을 더함
System.out.println(value);	// -128
```

마찬가지로 -128에서 1을 빼면 -129가 되어 언더플로우가 발생하는데, 연산 결과는 최대값인 127이 된다. 그리고 다시 1을 빼면 126이 된다.

```java
byte value = -128;
value--;	// value 값에 1을 뺌
System.out.println(value);	// 127
```

*OverflowUnderflowExample.java*

```java
package Chap3_Operator;

public class OverflowUnderflowExample {

	public static void main(String[] args) {

		byte var1 = 125;
		for(int i=0; i<5; i++) {
			var1++;
			System.out.println(var1);
		}
		
		System.out.println("-------------------------");
		
		byte var2 = -125;
		for(int i=0; i<5; i++) {
			var2--;
			System.out.println(var2);
		}

	}

}
```

```
126
127
-128
-127
-126
-------------------------
-126
-127
-128
127
126
```

## 나눗셈 연산 후 NaN과 Infinity 처리

나눗셈 또는 나머지 연산에서 우측 피연산자가 0일 경우에 예외(ArithmeticException)가 발생한다. 무한대의 값을 정수로 표현할 수 없기 때문이다. 

```java
int x = 5;
int y = 0;
int result = 5 / 0;		// 예외 발생
```

하지만 좌측 피연산자가 실수이거나 우측 피연산자가 0.0 또는 0.0f이면 예외가 발생하지 않고 연산의 결과는 Infinity(무한대) 또는 NaN(Not a Number)이 된다.

Infinity 또는 NaN 상태에서 계속해서 연산을 수행하면 안된다. 어떤 연산을 하더라도 결과는 계속해서 Infinity와 NaN이 된다.

따라서 /와 % 연산의 결과가 Infinity 또는 NaN인지 먼저 확인하고 다음 연산을 수행하는 것이 좋다. 확인하기 위해서는 Double.isInfinite()와 Double.isNaN()를 사용한다. 이렇게 하면 변수값이 Infinity 또는 NaN일 경우 true를, 그렇지 않다면 false를 산출한다.

```java
boolean result = Double.isInfinity(변수);
boolean result = Double.isNaN(변수);
```

## 비교 연산자

비교 연산자는 동등 또는 크기를 평가해서 boolean 타입인 true/false를 반환한다. 비교 연산자는 흐름 제어문인 조건문, 반복믄에서 실행 흐름을 제어할 때 주로 사용된다.

| 구문      | 연산식                 | 설명             |
| --------- | ---------------------- | ---------------- |
| 동등 비교 | 피연산자1 == 피연산자2 | 값이 같은지 검사 |
|           | 피연산자1 != 피연산자2 | 값이 다른지 검사 |
| 크기 비교 | 피연산자1 > 피연산자2  |                  |
|           | 피연산자1 >= 피연산자2 |                  |
|           | 피연산자1 < 피연산자2  |                  |
|           | 피연산자1 <= 피연산자2 |                  |

문자열을 비교할 때에는 동등 연산자 대신 equals()와 !equals()를 사용한다. 이유는 자바에서 문자열은 리터럴이 아닌 참조타입의 자료형이기 때문이다.

## 논리 연산자

논리 연산자는 논리곱, 논리합, 배타적 논리합 그리고 논리 부정 연산을 수행한다. 논리 연산은 흐름 제어문인 조건문, 반복문 등에서 주로 이용된다.

| 구분               | 연산식                  | 결과  | 설명                                                         |
| ------------------ | ----------------------- | ----- | ------------------------------------------------------------ |
| AND(논리곱)        | true && 또는 & true     | true  | 피연산자 모두가 true일 경우에만 연산 결과가 true             |
|                    | true && 또는 & false    | false |                                                              |
|                    | false && 또는 & true    | true  |                                                              |
|                    | false && 또는 & false   | false |                                                              |
| OR(논리합)         | true \|\| 또는 \| true  | true  | 피연산자 중 하나만 true이면 연산 결과는 true                 |
|                    | true \|\| 또는 \| false | true  |                                                              |
|                    | false \|\| 또는 true    | true  |                                                              |
|                    | false \|\| 또는 false   | false |                                                              |
| XOR(배타적 논리합) | true ^ true             | false | 피연산자가 하나는 true이고 다른 하나가 false일 경우에만 연산 결과가 true |
|                    | true ^ false            | true  |                                                              |
|                    | false ^ true            | true  |                                                              |
|                    | false ^ false           | false |                                                              |
| NOT(논리 부정)     | ! true                  | false | 피연산자의 논리값을 바꿈                                     |
|                    | ! false                 | true  |                                                              |

&&와 &는 산출 결과는 같지만 연산 과정이 조금 다르다. &&는 앞의 피연산자가 false라면 뒤의 피연산자를 평가하지 않고 바로 false를 산출한다. 그러나 &는 두 피연산자 모두를 평가해서 산출 결과를 낸다. 따라서 &보다는 &&가 더 효율적으로 동작한다. ||와 |도 마찬가지이다. 

*LogicalOperatorExample.java*

```java
package Chap3_Operator;

public class LogicalOperatorExample {

	public static void main(String[] args) {

//		int charCode = 'A';
//		int charCode = 'a';
		int charCode = '5';
		
		if((65 <= charCode) & (charCode <= 90)) {
			System.out.println("대문자이군요.");
		}
		
		if((97 <= charCode) && (charCode <= 127)) {
			System.out.println("소문자이군요.");
		}
		
		if((48 <= charCode) & (charCode <= 57)) {
			System.out.println("0~9 숫자이군요.");
		}
		
//		----------------------------------------------
		
//		int value = 6;
		int value = 7;
		
		if((value%2==0) | (value%3==0)) {
			System.out.println("2 또는 3의 배수이군요.");
		}
		
		boolean result = (value%2==0) || (value%3==0);
		if(!result) {
			System.out.println("2 또는 3의 배수가 아니군요.");
		}

	}

}
```

```
0~9 숫자이군요.
2 또는 3의 배수가 아니군요.
```

## 비트 논리 연산자

비트 논리 연산자는 bit 단위로 논리 연산을 수행한다. 0과 1이 피연산자가 되므로 2진수 0과 1로 저장되는 정수 타입만 피연산자가 될 수 있고, 부동 소수점 방식으로 저장되는 실수 타입은 피연산자가 될 수 없다.

다음은 비트 논리 연산자의 종류를 보여준다. 피연산자가 1, 0이라는 것과, 산출 결과가 1, 0이라는 점에 주목하자. 1은 true, 0은 false라고 생각한다면 앞의 논리 연산자와 차이가 없다.

| 구분               | 연산식 | 결과 | 설명                                                       |
| ------------------ | ------ | ---- | ---------------------------------------------------------- |
| AND(논리곱)        | 1 & 1  | 1    | 두 비트 모두 1일 경우에만 연산 결과가 1                    |
|                    | 1 & 0  | 0    |                                                            |
|                    | 0 & 1  | 0    |                                                            |
|                    | 0 & 0  | 0    |                                                            |
| OR(논리합)         | 1 \| 1 | 1    | 두 비트 중 하나만 1이면 연산 결과는 1                      |
|                    | 1 \| 0 | 1    |                                                            |
|                    | 0 \| 1 | 1    |                                                            |
|                    | 0 \| 0 | 0    |                                                            |
| XOR(배타적 논리합) | 1 ^ 1  | 0    | 두 비트 중 하나는 1이고 다른 하나가 0일 경우 연산 결과는 1 |
|                    | 1 ^ 0  | 1    |                                                            |
|                    | 0 ^ 1  | 1    |                                                            |
|                    | 0 ^ 0  | 0    |                                                            |
| NOT(논리 부정)     | ~ 1    | 0    | 보수                                                       |
|                    | ~ 0    | 1    |                                                            |

비트 논리 연산이 왜 필요한지 예를 하나 들어보자. 소형 임베디드 장치의 C 프로그램에서 외부 서버의 자바 프로그램으로 데이터를 전달한다고 가정하자. C 언어에는 unit8_t 타입이 있는데, 이 타입은 1byte 크기를 가지면서 0-255 값의 범위를 가진다.

C 프로그램이 unit8_t 타입 136(10001000)을 2진수로 보내면, 자바는 2진수를 -120(10001000)으로 읽게 된다. 그 이유는 자바는 최상위 비트가 1이면 음수로 인식하기 때문이다.

-120을 C 프로그램이 보낸 136으로 복원하고 싶다면 -120과 255를 비트 논리곱(&) 연산을 수행하면 된다.

```java
byte receiveData = -120;
int unsignedInt = receiveData & 255; // 136
```

receiveData는 int 타입으로 변환되고, 다음과 같이 연산이 수행된다.

​    `11111111`   `11111111`   `11111111`   `10001000` (-120)

& `00000000`   `00000000`   `00000000`   `11111111` (255)

`-----------------------------------------`

   `00000000`   `00000000`   `00000000`   `10001000` (136)

위와 같이 255와 비트 논리곱 연산을 수행하는 방법도 있지만, 자바는 개발자의 편의성을 위해 Byte.toUnsignedInt() 코드를 제공한다.

```java
byte receiveData = -120;
int unsignedInt = Byte.toUnsignedInt(receiveData);	// 136
```

*BitLogicExample.java*

```java
package Chap3_Operator;

public class BitLogicExample {

	public static void main(String[] args) {
		
		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));
		
		System.out.println("------------------------------");
		
		byte receiveData = -120;
		
		// 방법1 : 비트 논리곱 연산으로 Unsigned 정수 얻기
		int unsignedInt1 = receiveData & 255;
		System.out.println(unsignedInt1);
		
		// 방법2 : 자바 API를 이용해서 Unsigned 정수 얻기
		int unsignedInt2 = Byte.toUnsignedInt(receiveData);
		System.out.println(unsignedInt2);
		
		int test = 136;
		byte btest = (byte) test;
		System.out.println(btest);

	}

}
```

```
45 & 25 = 9
45 | 25 = 61
45 ^ 25 = 52
~45 = -46
------------------------------
136
136
-120
```

## 비트 이동 연산자

비트 연산자에는 논리 연산자 외에도 이동 연산자가 있다. 비트 이동 연산자는 비트를 좌측 또는 우측으로 밀어서 이동시키는 연산을 수행한다.

| 구분        | 연산식  | 설명                                                         |
| ----------- | ------- | ------------------------------------------------------------ |
| 이동(shift) | a << b  | 정수 a의 각 비트를 b만큼 왼쪽으로 이동<br />오른쪽 빈자리는 0으로 채움<br />a x 2^b와 동일한 결과가 됨 |
|             | a >> b  | 정수 a의 각 비트를 b만큼 오른쪽으로 이동<br />왼쪽 빈자리는 최상위 부호 비트와 같은 값으로 채움<br />a / 2^b와 동일한 결과가 됨 |
|             | a >>> b | 정수 a의 각 비트를 b만큼 오른쪽으로 이동<br />왼쪽 빈자리는 0으로 채움 |

좌측 이동 연산자(<<)를 사용하여 정수 1을 3비트만큼 왼쪽으로 이동시켜보자.

```java
int result = 1 << 3;
```

`00000000`   `00000000`   `00000000`   `00000001`

`<<3`

`00000000`   `00000000`   `00000000`   `00001` `000`

빠져나온 `000`는 버림

4byte(32bit) 전체를 왼쪽으로 3비트 이동하면 맨 왼쪽 3비트는 밀려서 버려지고, 맨 오른쪽에 새로 생기는 3비트는 0으로 채워진다. 따라서 result 변수에는 8이 저장된다. 좌측 이동 연산자(<<)는 다음과 같이 2의 거듭제곱을 곱한 결과와 동일한다.

```
1 << 3 = 1 x 2^3 = 8
```

이번에는 우측 이동 연산자(>>)를 사용하여 정수 -8을 3비트만큼 오른쪽으로 이동시켜보자.

`1` `1111111`   `11111111`   `11111111`   `11111000`

`>>3`

`111` `11111`   `11111111`   `11111111`   `11111111`

빠져나온 `000`은 버림

4byte(32bit) 전체를 오른쪽으로 3비트 이동할 때 맨 오른쪽 3비트는 밀려서 버려지고, 맨 왼쪽에 새로 생기는 3비트는 최상위 보호 비트와 동일한 값으로 채워진다. 4byte가 모두 1이면 정수 -1이므로 변수 result에는 -1이 저장된다. 우측 이동 연산자(`>>>`)는 다음과 같이 2의 거듭제곱을 나눈 결과와 동일하다.

```
-8 >> 3 = -8 / 2^3 = -1
```

*BitShiftExample1.java*

```java
package Chap3_Operator;

public class BitShiftExample {

	public static void main(String[] args) {
		
		int num1 = 1;
		int result1 = num1 << 3;
		int result2 = num1 * (int) Math.pow(2, 3);
		System.out.println(result1);
		System.out.println(result2);
		
		int num2 = -8;
		int result3 = num2 >> 3;
		int result4 = num2 / (int) Math.pow(2, 3);
		System.out.println(result3);
		System.out.println(result4);

	}

}
```

```
8
8
-1
-1
```

이번에는 우측 이동 연산자(>>>)를 사용하여 정수 -8을 3비트만큼 오른쪽으로 이동시킨다.

```java
int result = -8 >>> 3;
```

`11111111`    `11111111`    `11111111`    `11111000`

`>>>3`

`000` `11111`    `11111111`    `11111111`    `11111111`

32비트 전체를 오른쪽으로 3비트 이동할 때 맨 오른쪽 3비트는 밀려서 버려지고, 맨 왼쪽에 새로 생기는 3비트는 무조건 0으로 채워진다. 이렇게 변환된 2진수를 10진수로 변환하면 536870911 값을 얻는다.

*BitShiftExample2.java*

```java
package Chap3_Operator;

public class BitShiftExample2 {

	public static void main(String[] args) {
		
		int value = 772; // [00000000][00000000][00000011][00000100]
		
		// 우측으로 3byte(24bit) 이동하고 끝 1바이트만 읽음 [00000000]
		byte byte1 = (byte) (value >>> 24);
		int int1 = byte1 & 255;
		System.out.println("첫번째 바이트 부호 없는 값 : " + int1);
		
		// 우측으로 2byte(16bit) 이동하고 끝 1바이트만 읽음 [00000000]
		byte byte2 = (byte) (value >>> 16);
		int int2 = Byte.toUnsignedInt(byte2);
		System.out.println("두번째 바이트 부호 없는 값 : " + byte2);
		
		// 우측으로 1byte(8bit) 이동하고 끝 1바이트만 읽음 [00000011]
		byte byte3 = (byte) (value >>> 8);
		int int3 = byte3 & 255;
		System.out.println("세번째 바이트 부호 없는 값 : " + int3);
		
		// 끝 1바이트만 읽음 : [00000100]
		byte byte4 = (byte) value;
		int int4 = Byte.toUnsignedInt(byte4);
		System.out.println("네 번째 바이트 부호 없는 값 : " + int4);

	}

}
```

```
첫번째 바이트 부호 없는 값 : 0
두번째 바이트 부호 없는 값 : 0
세번째 바이트 부호 없는 값 : 3
네 번째 바이트 부호 없는 값 : 4
```

## 대입 연산자

대입 연산자는 우측 피연산자의 값을 좌측 피연산자인 변수에 대입한다. 우측 피연산자에 리터럴 및 변수, 그리고 다른 연산식이 올 수 있다. 대입 연산자의 종류에는 단순히 값을 대입하는 단순 대입 연산자가 있고, 정해진 연산을 수행한 후 결과를 대입하는 복합 대입 연산자가 있다.

| 구분                        | 연산식             | 설명                                                 |
| --------------------------- | ------------------ | ---------------------------------------------------- |
| 단순 대입 연산자            | 변수 = 피연산자    | 우측 피연산자의 값을 변수에 저장                     |
| 복합 대입 연산자(이하 동일) | 변수 += 피연산자   | 연산 기호에 따라 연산 후 다시 변수에 저장(이하 동문) |
|                             | 변수 -= 피연산자   |                                                      |
|                             | 변수 *= 피연산자   |                                                      |
|                             | 변수 /= 피연산자   |                                                      |
|                             | 변수 %= 피연산자   |                                                      |
|                             | 변수 &= 피연산자   |                                                      |
|                             | 변수 \|= 피연산자  |                                                      |
|                             | 변수 ^= 피연산자   |                                                      |
|                             | 변수 <<= 피연산자  |                                                      |
|                             | 변수 >>= 피연산자  |                                                      |
|                             | 변수 >>>= 피연산자 |                                                      |

## 삼항(조건) 연산자

삼항 연산자(피연산자 ? 피연산자 : 피연산자)는 총 3개의 피연산자를 가진다. ? 앞의 피연산자는 boolean 변수 또는 조건식이 오므로 조건 연산자라고도 한다. 이 값이 true이면 `:` 앞의 피연산자가 선택되고, false이면 `:` 뒤의 피연산자가 선택된다.

피연산자2와 3에는 주로 값이 오지만, 경우에 따라서는 다른 연산식이 올 수도 있다.

*ConditionalOperationExample.java*

```java
package Chap3_Operator;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은 " + grade + "등급입니다.");

	}

}
```

```
85점은 B등급입니다.
```

## 연산의 방향과 우선순위

다음은 연산자의 연산 방향과 우선순위를 정리한 표이다.

| 연산자                                                 | 연산 방향 | 우선순위 |
| ------------------------------------------------------ | --------- | -------- |
| 증감(`++`, `--`), 부호(`+`, `-`), 비트(`~`), 논리(`!`) | ←         | 높음     |
| 산술(`*`, `/`, `%`)                                    | →         |          |
| 산술(`+`, `-`)                                         |           |          |
| 쉬프트(`<<`, `>>`, `>>>`)                              |           |          |
| 비교(`<`, `>`, `<=`, `>=`, instanceof)                 |           |          |
| 비교(`==`, `!=`)                                       |           |          |
| 논리(`&`)                                              |           |          |
| 논리(`^`)                                              |           |          |
| 논리(`|`)                                              |           |          |
| 논리(`&&`)                                             |           |          |
| 논리(`||`)                                             |           |          |
| 조건(`?:`)                                             |           |          |
| 대입(`=`, `+=`, `-=`, `*=`, ...)                       | ←         | 낮음     |

먼저 처리할 연산은 괄호()로 묶는다. 괄호는 최우선 순위를 가지기 때문이다.
