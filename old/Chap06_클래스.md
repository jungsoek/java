# 클래스

## 객체 지향 프로그래밍

객체지향 프로그래밍(Object-Oriented Programming, OOP)은 프로그래밍 패러다임 중 하나로, 데이터를 객체(object)라는 단위로 나누고, 이 객체들 간의 상호작용을 통해 프로그램을 구성하는 방식이다. 객체는 데이터(속성)와 그 데이터를 다루는 메소드(함수)를 묶어 하나의 독립적인 단위로 취급한다.

### 객체란?

객체(Object)는 객체지향 프로그래밍(OOP)의 핵심 단위로, 현실 세계의 사물이나 개념을 소프트웨어에서 모델링한 것이다. 객체는 데이터를 포함하는 속성(Attributes)과 동작을 수행하는 메소드(Methods)로 구성된다.

* 속성
  * 객체의 상태를 나타내는 변수
* 메소드
  * 객체가 수행할 수 있는 동작이나 기능
* 클래스와의 관계
  * 객체는 클래스라는 템플릿에서 생성된 인스턴스이다.
  * 클래스는 객체의 속성과 메서드를 정의하며, 객체는 클래스에서 만들어진 구체적인 예제이다.

### 객체의 역할

객체(Object)는 객체지향 프로그래밍(OOP)의 핵심 단위로, 현실 세계의 사물이나 개념을 소프트웨어에서 모델링한 것이다. 객체는 데이터를 포함하는 속성(Attributes)과 동작을 수행하는 메소드(Methods)로 구성된다.

### 객체의 상호작용

현실 세계에서 일어나는 모든 현상은 객체와 객체 간의 상호작용으로 이루어져 있다.

객체 지향 프로그램에서도 객체들은 다른 객체와 서로 상호작용하면서 동작한다. 객체들 사이의 상호작용 수단은 메소드이다. 객체가 다른 객체의 기능을 이용할 때 이 메소드를 호출한다.

메소드 호출을 통해 객체들은 데이터를 서로 주고받는다. 메소드 이름과 함께 전달하고자 하는 데이터를 괄호() 안에 기술하는데, 이러한 데이터를 매개값이라고 한다. 매개값은 메소드가 실행할 때 필요한 값이다. 리턴값은 메소드의 실행 결과이며, 호출한 곳으로 돌려주는 값이다.

### 객체 간의 관계

객체는 단독으로 존재할 수 있지만 대부분 다른 객체와 관계를 맺고 있다. 관계의 종류에는 집합, 사용, 상속이 있다.

#### 집합 관계

완성품과 부품의 관계를 말한다. 예를 들어 자동차는 엔진, 타이어, 핸들 등으로 구성되므로 자동차와 부품들은 집합 관계라고 볼 수 있다.

#### 사용 관계

다른 객체들의 필드를 읽고 변경하거나 메소드를 호출하는 관계를 말한다. 예를 들어 사람이 자동차에게 달린다, 멈춘다 등의 메소드를 호출하면 사람과 자동차는 사용 관계라고 볼 수 있다.

#### 상속 관계

부모와 자식 관계를 말한다. 자동차가 기계의 특징(필드, 메소드)을 물려받는다면 기계(부모)와 자동차(자식)는 상속 관계에 있다고 볼 수 있다.

### 객체 지향 프로그래밍의 특징

#### 캡슐화

캡슐화(Encapsulation)란 객체의 데이터(필드), 동작(메소드)을 하나로 묶고 실제 구현 내용을 외부에 감추는 것을 말한다. 외부 객체는 객체 내부의 구조를 알지 못하며 객체가 호출해서 제공하는 필드와 메소드만 이용할 수 있다.

필드와 메소드를 캡슐화하여 보호하는 이유는 외부의 잘못된 사용으로 인해 객체가 손상되지 않도록 하는 데 있다. 자바는 캡슐화된 멤버를 노출시킬 것인지 숨길 것인지를 결정하기 위해 접근 제한자(Access Modifier)를 사용한다.

#### 상속

객체 지향 프로그래밍에서는 부모 역할의 상위 객체와 자식 역할의 하위 객체가 있다. 부모 객체는 자기가 가지고 있는 필드와 메소드를 자식 객체에게 물려주어 자식 객체가 사용할 수 있도록 한다. 이것이 상속이다. 상속을 하는 이유는 다음과 같다.

* 코드의 재사용성을 높여준다.
* 유지 보수 시간을 최소화시켜 준다.

#### 다형성

다형성이란 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질을 말한다. 자동차 부품을 교환하면 성능이 다르게 나오듯이 프로그램을 구성하는 객체(부품)를 바꾸면 프로그램의 실행 성능이 다르게 나올 수 있다.

다형성을 구현하기 위해서는 자동 타입 변환과 재정의 기술이 필요하다. 이 기술들은 상속과 인터페이스 구현을 통해 얻어진다.

## 객체와 클래스

## 클래스 선언

## 객체 생성과 클래스 변수

```java
클래스 변수 = new 생성자();		// 생성자 : 클래스와 동일한 이름, 객체 초기화 및 설정
Class class = new Class();
```

## 클래스의 구성 멤버

#### 필드

객체의 데이터를 저장하는 역할을 한다. 선언 상태는 변수 선언과 비슷하나 쓰임새는 다르다.

#### 생성자

new 연산자로 객체를 생성할 때 객체의 초기화 역할을 담당한다. 선언 형태는 메소드와 비슷하지만, 리턴 타입이 없고 이름은 클래스 이름과 동일하다.

#### 메소드

객체가 수행할 동작이다. 메소드는 객체와 객체간의 상호 작용을 위해 호출된다. 

## 필드 선언과 사용

#### 필드 선언

초기값을 제공하지 않을 경우 필드는 객체 생성 시 자동으로 기본값으로 초기화된다. 다음은 필드 타입별 기본값을 보여준다.

* 기본 타입
  * 정수 타입
    * byte : 0
    * char : \u0000 (빈공백)
    * short : 0
    * int : 0
    * long : 0L
  * 실수 타입
    * float : 0.0F
    * double : 0.0
  * 논리 타입
    * boolean : false
* 참조 타입
  * 배열 : null
  * 클래스(String 포함) : null
  * 인터페이스 : null

#### 필드 사용

## 생성자 선언과 호출

new 연산자는 객체를 생성한 후 연이어 생성자(Constructor)를 호출해서 객체를 초기화하는 역할을 한다. 객체 초기화란 필드 초기화를 하거나 메소드를 호출해서 객체를 사용할 준비를 하는 것을 말한다.

```java
Class class = new Class();
```

생성자가 성공적으로 실행이 끝나면 new 연산자는 객체의 주소를 리턴한다. 리턴된 주소는 클래스 변수에 대입되어 객체의 필드나 메소드에 접근할 때 이용된다.

#### 기본 생성자

모든 클래스는 생성자가 존재하며, 하나 이상을 가질 수 있다. 클래스에 생성자 선언이 없으면 컴파일러는 다음과 같은 기본 생성자를 바이트코드 파일에 자동으로 추가시킨다.

```java
[public] 클래스() {}
```

클래스가 public class로 선언되면 기본 생성자도 public이 붙지만, 클래스가 public 없이 class로만 선언되면 기본 생성자에도 public이 붙지 않는다. 예를 들어 Car 클래스를 설계할 때 생성자를 생략하면 기본 생성자가 다음과 같이 생성된다.

**소스 파일(Car.java)**

```java
public class Car {
    
}
```

**바이트코드 파일(Car.class)**

```java
public class Car {
	public Car() { }	// 자동 추가
}
```

그렇기 때문에 다음과 같이 new 연산자 뒤에 기본 생성자를 호출할 수 있다.

```java
Car myCar = new Car();
```

그러나 개발자가 명시적으로 선언한 생성자가 있다면 컴파일러는 기본 생성자를 추가하지 않는다. 개발자가 생성자를 선언하는 이유는 객체를 다양하게 초기화하기 위해서이다.

#### 생성자 선언

#### 필드 초기화

#### 생성자 오버로딩

매개값으로 객체의 필드를 다양하게 초기화하려면 생성자 오버로딩(Overloading)이 필오하다. 생성자 오버로딩이란 매개변수를 달리하는 생성자를 여러 개 선언하는 것을 말한다. 

```java
public class Car {
    Car() { ... }
    Car(String model) { ... }
    Car(String model, String color) { ... }
    Car(String model, String color, int maxSpeed) { ... }
}
```

매개변수의 타입과 개수 그리고 선언된 순서가 똑같을 경우 매개변수 이름만 바꾸는 것은 생성자 오버로딩이 아니다. 바로 다음과 같인 경우이다.

```java
Car(String model, String color) { ... }
Car(String color, String model) { ... }
```

생성자가 오버로딩되어 있을 경우, new 연산자로 생성자를 호출할 때 제공되는 매개값의 타입과 변수에 따라 실행될 생성자가 결정된다.

```java
Car car1 = new Car();
Car car2 = new Car("그랜저");
Car car3 = new Car("그랜저", "회색");
Car car4 = new Car("그랜저", "흰색", 300);
```

*Car.java*

```java
package Chap6_Class;

public class Car {

	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car() {}
	
	Car(String model) {
		this.model = model;
	}
	
	Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

}
```

*CarExample.java*

```java
package Chap6_Class;

public class CarExample {

	public static void main(String[] args) {
		
		Car car1 = new Car();
		System.out.println(car1.company);
		System.out.println();
		
		Car car2 = new Car("자가용");
		System.out.println(car2.company);
		System.out.println(car2.model);
		System.out.println();
		
		Car car3 = new Car("자가용", "빨강");
		System.out.println(car3.company);
		System.out.println(car3.model);
		System.out.println(car3.color);
		
		Car car4 = new Car("택시", "검정", 200);
		System.out.println(car4.company);
		System.out.println(car4.model);
		System.out.println(car4.color);
		System.out.println(car4.maxSpeed);

	}

}
```

```
현대자동차

현대자동차
자가용

현대자동차
자가용
빨강

현대자동차
택시
검정
200
```

#### 다른 생성자 호출

## 메소드 선언과 호출

### 메소드 선언

#### 리턴 타입

#### 메소드 선언

#### 매개변수

#### 실행 블록

### 메소드 호출

### 가변길이 매개변수

메소드를 호출할 때에는 매개변수의 개수에 맞게 매개값을 제공해야 한다. 만약 메소드가 가변길이 매개변수를 가지고 있다면 매개변수의 개수와 상관없이 매개값을 줄 수 있다. 가변길이 매개변수는 다음과 같이 선언한다.

```java
int sum(int ... values) {
    
}
```

가변길이 매개변수는 메소드 호출 시 매개값을 쉼표로 구분해서 개수와 상관없이 제공할 수 있다.

```java
int result = sum(1,2,3);
int result = sum(1,2,3,4,5);
```

매개값들은 자동으로 배열 항목으로 변환되어 배열 객체로서 메소드에서 사용된다. 그렇기에 메소드 호출 시 직접 배열을 매개값으로 제공해도 된다.

```java
int[] values = {1,2,3};
int result = sum(values);
```

```java
int result = sum(new int[] {1,2,3});
```

*Computer.java*

```java
public class Computer {
    int sum(int ... values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }   
}
```

*ComputerExample.java*

```java
package Chap6_Class;

class ComputerExample {

	public static void main(String[] args) {
		
		// Computer 객체 생성
		Computer myCom = new Computer();
		
		// sum() 메소드 호출 시 매개값 1,2,3을 제공하고
		// 합산 결과를 리턴 받아 result1 변수에 대입
		int result1 = myCom.sum(1,2,3);
		System.out.println(result1);
		
		// sum() 메소드 호출 시 매개값 1,2,3,4,5를 제공하고
		// 합산 결과를 리턴 받아 result2 변수에 대입
		int result2 = myCom.sum(1,2,3,4,5);
		System.out.println(result2);
		
		// sum() 메소드 호출 시 배열을 제공하고
		// 합산 결과를 리턴 받아 result3 변수에 대입
		int[] values = { 1,2,3,4,5 };
		int result3 = myCom.sum(values);
		System.out.println(result3);
		
		// sum() 메소드 호출 시 배열을 제공하고
		// 합산 결과를 리턴 받아 result4 변수에 대입
		int result4 = myCom.sum(new int[] { 1,2,3,4,5 });
		System.out.println(result4);

	}

}
```

```
6
15
15
15
```

### return 문

return 문은 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아간다라는 의미이다. 메소드 선언에 리턴 타입이 있을 경우에는 return 문 뒤에 리턴값을 추가로 지정해야 한다.

```java
return [리턴값];
```

### 메소드 오버로딩

메소드 오버로딩은 메소드 이름은 같되 매개변수의 타입, 개수, 순서가 다른 메소드를 여러 개 선언하는 것을 말한다.

```java
class 클래스 {
    리턴타입 메소드이름 (타입 변수, ... ) { ... }
    
    // 무관	동일		타입, 개수, 순서가 달라야 함
    리턴타입 메소드이름 (타입 변수, ... ) { ... }
}
```

메소드 오버로딩의 목적은 다양한 매개값을 처리하기 위해서이다. 

## 인스턴스 멤버

필드와 메소드는 선언 방법에 따라 인스턴스 멤버와 정적 멤버로 분류할 수 있다. 멤버로 선언되면 객체 생성 후 사용할 수 있고, 정적 멤버로 선언되면 객체 생성 없이도 사용할 수 있다.

| 구분                    | 설명                                                         |
| ----------------------- | ------------------------------------------------------------ |
| 인스턴스(instance) 멤버 | 객체에 소속된 멤버<br />(객체를 생성해야만 사용할 수 있는 멤버) |
| 정적(static) 멤버       | 클래스에 고정된 멤버<br />(객체 없이도 사용할 수 있는 멤버)  |

### 인스턴스 멤버 선언 및 사용

인스턴스 멤버란 객체에 소속된 멤버를 말한다. 따라서 객체가 있어야만 사용할 수 있는 멤버다.

### this 키워드

객체 내부에서는 인스턴스 멤버에 접근하기 위해 this를 사용할 수 있다.

## 정적 멤버

자바는 클래스 로더를 이용해서 클래스를 메소드 영역에 저장하고 사용한다. 정적 멤버란 메소드 영역의 클래스에 고정적으로 위치하는 멤버를 말한다. 그렇기 때문에 정적 멤버는 객체를 생성할 필요 없이 클래스를 통해 바로 사용이 가능하다.

### 정적 멤버 선언

필드와 메소드는 모두 정적 멤버가 될 수 있다. 정적 필드와 정적 메소드로 선언하려면 다음과 같이 static 키워드를 추가하면 된다.

```java
public class 클래스 {
    // 정적 필드 선언
    static 타입 필드 [=초기값];
    
    // 정적 메소드
    static 리턴타입 메소드( 매개변수, ... ) { ... }
}
```

객체마다 가지고 있을 필요성이 없는 공용적인 필드는 정적 필드로 선언하는 것이 좋다. 예를 들어 Calculator 클래스에서 원의 넓이나 둘레를 구할 때 필요한 파이는 Calculator 객체마다 가지고 있을 필요가 없기 때문에 정적 필드로 선언하는 것이 좋다.

```java
public class Calculator {
    String color;						// 계산기별로 색깔이 다를 수 있다.
    static double pi = 3.141592;		// 계산기에서 사용하는 파이 값은 동일하다.
}
```

### 정적 멤버 사용

클래스가 메모리로 로딩되면 정적 멤버를 바로 사용할 수 있는데, 클래스 이름과 함께 도트(.) 연산자로 접근하면 된다. 

### 정적 블록

정적 필드는 다음과 같이 필드 선언과 동시에 초기값을 주는 것이 일반적이다.

```java
static double pi = 3.141592;
```

하지만 복잡한 초기화 작업이 필요하다면 정적 블록을 이용해야 한다. 다음은 정적 블록의 형태를 보여준다.

```java
static {
    ...
}
```

정적 블록은 클래스가 메모리로 로딩될 때 자동으로 실행된다. 정적 블록이 클래스 내부에 여러 개가 선언되어 있을 경우에는 선언된 순서대로 실행된다.

cf) : 생성자에서 초기화를 하지 않는 정적 필드

정적 필드는 객체 생성 없이도 사용할 수 있기 때문에 생성자에서 초기화 작업을 하지 않는다. 생성자는 객체 생성 후 실행되기 때문이다.

### 인스턴스 멤버 사용 불가

*Television.java*

```java
package Chap6_Class;

public class Television {
	
	static String company = "My Company";
	static String model = "LCD";
	static String info;
	
	static {
		info = company + "-" + model;
	}

}
```

*TelevisionExample.java*

```java
package Chap6_Class;

public class TelevisionExample {

	public static void main(String[] args) {
		
		System.out.println(Television.info);

	}

}
```

```
My Company-LCD
```

### 인스턴스 멤버 사용 불가

정적 메소드와 정적 블록은 객체가 없어도 실행된다는 특징 때문에 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다. 또한 객체 자신의 참조인 this도 사용할 수 없다.

```java
public class ClassName {
    
    // 인스턴스 필드와 메소드 선언
    int field;
    void method1() { ... }
    
    // 정적 필드와 메소드 선언
    static int field2;
    static void method2() { ... }
    
    // 정적 블록 선언
    field1 = 10;	// 컴파일 에러
    method1();		// 컴파일 에러
    field2 = 10;
    method2();
    
    // 정적 메소드 선언
    static void method3() {
        this.field1 = 10;	// 컴파일 에러
        this.method();		// 컴파일 에러
        field2 = 10;
        method2();
    }
    
}
```

## final 필드와 상수

인스턴스 필드와 정적 필드는 언제든지 값을 변경할 수 있다. 그러나 경우에 따라서는 값을 변경하는 것을 막고 읽기만 허용해야 할 때가 있다. 이때 final 필드와 상수를 선언해서 사용한다.

### final 필드 선언

final은 '최종적'이란 뜻을 가지고 있다. final 필드는 초기값이 저장되면 이것이 최종적인 값이 되어서 프로그램 실행 도중에 수정할 수 없게 된다. final 필드는 다음과 같이 선언한다.

```java
final 타입 필드 [=초기값];
```

final 필드에 초기값을 줄 수 있는 방법은 다음 두 가지 밖에 없다.

```java
1. 필드 선언 시에 초기값 대입
2. 생성자에서 초기값 대입
```

고정된 값이라면 필드 선언 시에 주는 것이 제일 간단하다. 하지만 복잡한 초기화 코드가 필요하거나 객체 생성 시에 외부에서 전달된 값으로 초기화한다면 생성자에서 해야 한다. 이 두 방법을 사용하지 않고 final 필드를 그대로 남겨두면 컴파일 에러가 발생한다.

다음 예제에서 Korean 클래스를 보면 국가(nation)과 주민등록번호(ssn) 필드를 final 필드로 선언했다. nation은 고정값이므로 선언 시에 초기값을 대입했고, ssn은 Korean 객체가 생성될 때 부여되므로 생성자 매개값으로 주민등록번호를 받아 초기값으로 대입했다.

*Korean.java*

```java
package Chap6_Class;

public class Korean {
	
	// 인스턴스 final 필드 선언
	final String nation = "대한민국";
	final String ssn;
	
	// 인스턴스 필드 선언
	String name;
	
	// 생성자 선언
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}

}
```

*KoreanExample.java*

```java
package Chap6_Class;

public class KoreanExample {

	public static void main(String[] args) {
		
		// 객체 생성 시 주민등록번호와 이름 전달
		Korean k1 = new Korean("123456-1234567", "김자바");
		
		// 필드값 읽기
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		// Final 필드는 값을 변경할 수 없음
//		k1.nation = "USA";
//		k1.ssn = "123456-7890123";
		
		// 비 final 필드는 값 변경 가능
		k1.name = "김자바";

	}

}
```

```
대한민국
123456-1234567
김자바
```

### 상수 선언

우리 주변에는 불변의 값이 있다. 불변의 값은 수학에서 사용되는 원주율 파이나 지구의 무게 및 둘레 등이 해당된다. 이런 불변의 값을 저장하는 필드를 자바에서는 상수(constant)라고 한다.

상수는 객체마다 저장할 필요가 없고, 여러 개의 값을 가져도 안되기 때문에 static이면서 final인 특성을 가져야 한다. 따라서 상수는 다음과 같이 선언한다.

```java
static final 타입 상수 [=초기값];
```

초기값은 선언 시에 주는 것이 일반적이지만, 복잡한 초기화가 필요한 경우에는 정적 블록에서 초기화할 수도 있다.

```java
static final 타입 상수;
static {
    상수 = 초기값;
}
```

상수 이름은 모두 대문자로 작성하는 것이 관례이다. 만약 서로 다른 단어가 혼합된 이름이라면 언더바(_)로 단어들을 연결한다.

```java
static final double PI = 3.141592;
static final double EARTH_SURFACE_AREA = 5.147185403641517E8;
```

또한 상수는 정적 필드이므로 클래스로 접근해서 읽을 수 있다.

```java
클래스명.상수
```

*Earth.java*

```java
package Chap6_Class;

public class Earth {
	
	// 상수 선언 및 초기화
	static final double EARTH_RADIUS = 6400;
	
	// 상수 선언
	static final double EARTH_SURFACE_AREA;
	
	// 정적 블록에서 상수 초기화
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
	
}
```

*EarthExample.java*

```java
package Chap6_Class;

public class EarthExample {

	public static void main(String[] args) {
		
		// 상수 읽기
		System.out.println(Earth.EARTH_RADIUS);
		System.out.println(Earth.EARTH_SURFACE_AREA);

	}

}
```

```
6400.0
5.147185403641517E8
```

## 패키지

지금까지 예제 클래스를 패키지 안에 생성해서 관리했다. 자바의 패키지는 단순히 디렉터리만을 의미하지는 않는다. 패키지는 클래스의 일부분이며, 클래스를 식별하는 용도로 사용된다.

패키지는 주로 개발 회사의 도메인 이름의 역순으로 만든다. 예를 들어 mycompany.com 회사의 패키지는 com.mycompany로, yourcompany.com 회사의 패키지는 com.yourcompany로 만든다. 이렇게 하면 두 회사에서 개발한 Car 클래스가 있을 경우 다음과 같이 관리할 수 있다.

![image-20250422204854198](/assets/image-20250422204854198.png)

패키지는 상위 패키지와 하위 패키지를 도트(.)로 구분한다. 도트는 물리적으로 하위 디렉터리임을 뜻한다. 예를 들어 com.mycompany 패키지의 com은 상위 디렉터리, mycompany는 하위 디렉터리이다.

패키지는 클래스를 식별하는 용도로 사용되기 때문에 클래스의 전체 이름에 포함된다. 예를 들어 Car 클래스가 com.mycompany 패키지에 속해 있다면 Car 클래스의 전체 이름은 com.mycompany.Car가 된다. 이것은 com.yourcompany.Car와 다른 클래스임을 뜻한다.

패키지에 속한 바이트코드 파일(~.class)은 따로 떼어내어 다른 디렉터리로 이동할 수 없다. 예를 들어 Car 클래스가 com.mycompany 패키지에 소속되어 있다면 다른 디렉터리에 Car.class를 옮겨 저장할 경우 Car 클래스를 사용할 수 없게 된다.

### 패키지 선언

패키지 디렉터리는 클래스를 컴파일하는 과정에서 자동으로 생성된다. 컴파일러는 클래스의 패키지 선언을 보고 디렉터리를 자동 생성시킨다. 패키지 선언은 package 키워드와 함께 패키지 이름을 기술한 것으로, 항상 소스 파일 최상단에 위치해야 한다.

```java
package 상위패키지.하위패키지;

public class 클래스명 { ... }
```

패키지 이름은 모두 소문자로 작성하는 것이 관례이다. 그리고 패키지 이름이 서로 중복되지 않도록 회사 도메인 이름의 역순으로 작성하고, 마지막에는 프로젝트 이름을 붙여주는 것이 일반적이다.

```java
com.samsung.projectname
com.lg.projectname
com.apache.projectname
```

소스 파일(~.java)이 저장되면 이클립스는 자동으로 컴파일해서 <thisisjava_second_edition>/bin 디렉터리에 패키지 디렉터리와 함께 바이트코드 파일(~.class)을 생성한다.

만약 패키지 선언이 없다면 이클립스는 클래스를 (default package)에 포함시킨다. (default package)란 패키지가 없다는 뜻이다. 그러나 어떤 프로젝트든 패키지 없이 클래스를 만드는 경우는 드물다.

### import 문

같은 패키지에 있는 클래스는 아무런 조건 없이 사용할 수 있지만, 다른 패키지에 있는 클래스를 사용하려면 import 문을 이용해서 어떤 패키지의 클래스를 사용하는지 명시해야 한다.

## 접근 제한자

경우에 따라서는 객체의 필드를 외부에서 변경하거나 메소드를 호출할 수 없도록 막아야 할 필요가 있다. 중요한 필드와 메소드가 외부로 노출되지 않도록 해 객체의 무결성(결점이 없는 성질)을 유지하기 위해서이다.

| 접근 제한자 | 제한 대상                    | 제한 범위                                                    |
| ----------- | ---------------------------- | ------------------------------------------------------------ |
| public      | 클래스, 필드, 생성자, 메소드 | 없음                                                         |
| protected   | 필드, 생성자, 메소드         | 같은 패키지이거나, 자식 객체만 사용 가능(7장 상속에서 자세히 설명) |
| (default)   | 클래스, 필드, 생성자, 메소드 | 같은 패키지                                                  |
| private     | 필드, 생성자, 메소드         | 객체 내부                                                    |

### 클래스의 접근 제한

```java
[public] class 클래스 { ... }
```

### 생성자의 접근 제한

```java
public class ClassName {
    [public | private] ClassName(...) { ... }
}
```

### 필드와 메소드의 접근 제한

```java
// 필드 선언
[public | private] 타입 필드;

// 메소드 선언
[public | private] 리턴타입 메소드(...) { ... }
```

## Getter와 Setter

객체의 무결성을 위하여 쓴다.

```java
private 타입 fieldName;

// Getter
public 타입 getFieldName() {
    return fieldName;
}

// Setter
public void setFieldName(타입 fieldName) {
    this.fieldName = fieldName;
}
```

## 싱글톤 패턴

싱글톤 패턴은 단 한 개의 객체만 생성해서 사용하기 위한 것이다.생성자를 private 접근 제한해서 외부에서 new 연산자로 생성자를 호출할 수 없도록 막는 것이다.

```java
private 클래스() {}
```

