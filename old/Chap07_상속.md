# 상속

## 상속 개념

상속(inheritance)은 부모 클래스의 필드와 메소드를 자식 클래스에게 물려주는 것을 말한다.

상속은 이미 잘 개발된 클래스를 재사용해서 새로운 클래스를 만들기 때문에 중복되는 코드를 줄여 개발 시간을 단축시킨다.

## 클래스 상속

현실에서 상속은 부모가 자식을 선택해서 물려주지만, 프로그램에서는 자식이 부모를 선택해서 물려받는다. 자식 클래스를 선언할 때 어떤 부모로부터 상속받을 것인지를 결정하고, 부모 클래스를 다음과 같이 extends 뒤에 기술한다.

```java
public class 자식클래스 extends 부모클래스 {
    
}
```

다른 언어와 달리 자바는 다중 상속을 허용하지 않는다. 즉 여러 개의 부모 클래스를 상속할 수 없다. 따라서 extends 뒤에는 단 하나의 부모 클래스만이 와야 한다.

*Phone.java*

```java

```

*SmartPhone.java*

```java

```

*SmartPhoneExample.java*

```java

```

```

```

## 부모 생성자 호출

현실에서 부모 없는 자식이 있을 수 없듯이 자바에서도 자식 객체를 생성하면 부모 객체가 먼저 생성된 다음 자식 객체가 생성된다. 다음 코드는 SmartPhone 객체만 생성되는 것처럼 보이지만, 사실은 부모인 Phone 객체가 먼저 생성되고 그 다음에 자식인 SmartPhone 객체가 생성된 것이다.

```java
자식클래스 변수 = new 자식클래스();
```

이것을 메모리로 표현하면 다음과 같다.



모든 객체는 생성자를 호출해야만 생성된다. 부모 객체도 예외는 아니다. 그렇다면 부모 객체의 생성자는 어디서 호출된 것일까? 이것에 대한 비밀은 자식 생성자에 숨어 있다. 부모 생성자는 자식 생성자의 맨 첫 줄에 숨겨져 있는 super()에 의해 호출된다.

cf) : super() 키워드와 new 키워드의 차이

* super()는 메서드가 아니라 부모로부터 상속 받을 생성자 호출을 위한 키워드이다. super() 키워드는 자식 객체가 부모 객체의 생성자를 호출하여 부모의 필드와 메서드를 초기화 할 수 있다. 즉, 부모 객체를 '물려받아서' 자식 클래스가 상속을 유지하는 것이다.
* new 키워드는 상속이 아닌 완전히 새로운 객체를 생성하는 것이다. 즉, 상속이 아닌 별도의 객체를 생성하는 것이다.

```java
// 자식 생성자 선언
public 자식클래스(...) {
    super();
    ...
}
```

super()는 컴파일 과정에서 자동 추가되는데, 이것은 부모의 기본 생성자를 호출한다. 만약 부모 클래스에 기본 생성자가 없다면 자식 생성자 선언에서 컴파일 에러가 발생한다. 

```java
class Parent {
    public Parent() {
        System.out.println("부모의 기본 생성자 호출");
    }
}

class Child extends Parent {
    public Child() {
        super(); // 부모의 기본 생성자 호출 (자동 추가)
        System.out.println("자식 생성자 호출");
    }
}
```

부모 클래스에 기본 생성자가 없고 매개변수를 갖는 생성자만 있다면 개발자는 다음과 같이 super(매개값, ...) 코드를 직접 넣어야 한다. 이 코드는 매개값의 타입과 개수가 일치하는 부모 생성자를 호출한다.

```java
// 자식 생성자 선언
public 자식클래스(...) {
    super(매개값, ...);
    ...
}
```

*Phone.java*

```java

```

*SmartPhone.java*

```java

```

*SmartPhoneExample.java*

```java

```

```

```

다음 예제는 부모 클래스가 매개변수를 갖는 생성자가 있는 경우이다.

Phone.java

```java

```

*SmartPhone.java*

```java

```

*SmartPhoneExample.java*

```java

```

```

```

## 메소드 정의

부모 클래스의 모든 메소드가 자식 클래스에게 맞게 설계되어 있다면 가장 이상적인 상속이지만, 어떤 메소드는 자식 클래스가 사용하기에 적합하지 않을 수 있다. 이러한 메소드는 자식 클래스에서 재정의해서 사용해야 한다. 이것을 메소드 오버라이딩이라고 한다.

### 메소드 오버라이딩

메소드 오버라이딩은 상속된 메소드를 자식 클래스에서 재정의하는 것을 말한다. 메소드가 오버라이딩되었다면 해당 부모 메소드는 숨겨지고, 자식 메소드가 우선적으로 사용된다.

*Parent.java*

```java
class Parent {
    void method1() { ... }
    void method2() { ... }
}
```

*Child.java*

```java
class Child extends Parent {
    void method2() { ... }
    void method3() { ... }
}
```

*ChildExample.java*

```java
class ChildExample {
    public static void main(String[] args) {
        
        Child child = new Child();
        
        child.method1();	// 부모 메서드에서 호출
        
        child.method2();	// 부모 메서드에서 상속 받은 자식 메서드에서 호출
        
        child.method3();	// 자식 메서드에서 호출
        
    }
}
```

메소드를 오버라이딩할 때는 다음과 같은 규칙에 주의해서 작성해야 한다.

* 부모 메소드의 선언부(리턴 타입, 메소드 이름, 매개변수)와 동일해야 한다.
* 접근 제한을 더 강하게 오버라이딩할 수 없다(public -> private으로 변경 불가).
* 새로운 예외를 throws할 수 없다(예외는 10장에서 학습한다).

다음 예제를 보면 Calculator는 원의 넓이를 구하는 areaCircle() 메소드를 가지고 있다. 하지만 원주율 파이가 정확하지 않기 때문에 자식 클래스인 Computer에서 오버라이딩해서 좀 더 정확한 원주율 파이 상수(Math.PI)를 사용해 원의 넓이를 구하도록 했다.

*Calculator.java*

```java

```

*Computer.java*

```java

```

*ComputerExample.java*

```java

```

```

```

자바는 개발자의 실수를 줄여주기 위해 정확히 오버라이딩이 되었는지 체크해주는 @Override 어노테이션을 제공한다. @Override를 붙이면 컴파일 단계에서 정확히 오버라이딩이 되었는지 체크하고, 문제가 있다면 컴파일 에러를 출력한다.

### 부모 메소드 호출

메소드를 재정의하면, 부모 메소드는 숨겨지고 자식 메소드만 사용되기 때문에 비록 부모 메소드의 일부만 변경된다 하더라도 중복된 내용을 자식 메소드도 가지고 있어야 한다. 예를 들어 부모 메소드가 100줄의 코드를 가지고 있을 경우, 자식 메소드에서 1줄만 추가하고 싶더라도 100줄의 코드를 자식 메소드에서 다시 작성해야 한다.

이 문제는 자식 메소드와 부모 메소드의 공동 작업 처리 기법을 이용하면 쉽게 해결된다. 자식 메소드 내에서 부모 메소드를 호출하는 것인데, 다음과 같이 super 키워드와 도트(.) 연산자를 사용하면 숨겨진 부모 메소드를 호출할 수 있다.

*Parent.java*

```java
class Parent {
    public void method() {
        // 작업 처리1
    }
}
```

*Child.java*

```java
class Child extends Parent {
    @Override
    public void method() {
        super.method();
        // 작업 처리2
    }
}
```

super.method()의 위치는 작업 처리2 전후에 어디든지 올 수 있다. 우선 처리가 되어야 할 내용을 먼저 작성하면 된다. 이 방법은 부모 메소드를 재사용함으로써 자식 메소드의 중복 작업 내용을 없애는 효과를 가져온다.

다음 예제를 보면 Airplane의 fly() 메소드를 자식 클래스인 SupersonicAirplane에서 오버라이딩했다. 따라서 일반 비행 모드일 때는 Airplane의 fly()를 사용하고, 초음속 비행 모드일 때는 오버라이딩된 SupersonicAirplane의 fly()를 사용한다.

*Airplane.java*

```java

```

*SupersonicAirplane.java*

```java

```

*SupersonicAirplaneExample.java*

```java

```

```

```

## final 클래스와 final 메소드

앞에서 보았듯이, 필드 선언 시에 final을 붙이면 초기값 설정 후 값을 변경할 수 없다. 그렇다면 클래스와 메소드에 final을 붙이면 어떤 효과가 일어날까? final 클래스와 final 메소드는 상속과 관련이 있다.

### final 클래스

클래스를 선언할 때 final 키워드를 class 앞에 붙이면 최종적인 클래스이므로 더 이상 상속할 수 없는 클래스가 된다. 즉 final 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다.

```java
public final class 클래스 { ... }
```

대표적인 예가 String 클래스이다. String 클래스는 다음과 같이 선언되어 있다.

```java
public final class String { ... }
```

그래서 다음과 같이 자식 클래스를 만들 수 없다.

```java
public class NewString extends String { ... }	// X
```

다음 예제는 Member 클래스를 선언할 때 final을 지정함으로써 Member를 상속해 VeryImportantPerson을 선언할 수 없음을 보여준다.

*Member.java*

```java

```

*VeryImportantPerson.java*

```java

```

### final 메소드

최종적인 메소드이므로 오버라이딩 불가. 즉, final 메소드는 자식 클래스에서 재정의할 수 없다.

```java
public final 리턴타입 메소드( 매개변수, ... ) { ... }
```

다음 예제는 Car 클래스의 stop() 메소드를 final로 선언했기 때문에 자식 클래스인 SportsCar에서 stop() 메소드를 오버라이딩할 수 없음을 보여준다.

*Car.java*

```java

```

*SportsCar.java*

```java

```

## protected 접근 제한자

protected는 상속과 관련이 있고, public과 default의 중간쯤에 해당하는 접근 제한을 한다.

오른쪽으로 갈수록 접근 제한이 강화된다.

public - protected - default - private

cf) : default는 접근 제한자가 아니라 접근 제한자가 붙지 않은 상태를 말한다.

| 접근 제한자 | 제한 대상            | 제한 범위                                |
| ----------- | -------------------- | ---------------------------------------- |
| protected   | 필드, 생성자, 메소드 | 같은 패키지이거나, 자식 객체만 사용 가능 |

protected는 같은 패키지에서는 default처럼 접근이 가능하나, 다른 패키지에서는 자식 클래스만 접근을 허용한다. protected는 필드와 생성자 그리고 메소드 선언에 사용될 수 있다.

다음 A 클래스를 보면 protected로 선언된 필드, 생성자, 메소드가 있다.

*A.java*

```java

```

다음 B 클래스는 A 클래스와 동일한 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근이 가능하다.

*B.java*

```java

```

다음 C 클래스는 A 클래스와 다른 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근할 수 없다.

*C.java*

```java

```

다음 D 클래스는 A 클래스와 다른 패키지에 있지만 A의 자식 클래스이므로 A의 protected 필드, 생성자, 메소드에 접근이 가능하다. 단 new 연산자를 사용해서 생성자를 직접 호출할 수는 없고, 자식 생성자에서 super()로 A 생성자를 호출할 수 있다.

*D.java*

```java

```

## 타입 변환

클래스의 타입 변환은 상속 관계에 있는 클래스 사이에서 발생한다.

### 자동 타입 변환

자식은 부모의 특징과 기능을 상속받기 때문에 부모와 동일하게 취급될 수 있다. 예를 들어 고양이가 동물의 특징과 기능을 상속받았다면 '고양이는 동물이다'가 성립한다.

```java
Class Animal {
    ...
}

Class Cat extends Animal {
    ...
}
```

그래서 Cat 객체를 생성하고 이것을 Animal 변수에 대입하면 자동 타입 변환이 일어난다.

```java
Cat cat = new Cat();
Animal animal = cat;
```

위 코드로 생성되는 메모리 상태를 그림으로 묘사하면 다음과 같다. cat과 animal 변수는 타입만 다를 뿐, 동일한 Cat 객체를 참조한다.



따라서 두 참조 변수의 == 연산 결과는 true가 나온다.

```java
cat == animal	// true
```

바로 위의 부모가 아니더라도 상속 계층에서 상위 타입이라면 자동 타입 변환이 일어날 수 있다. 다음 그림을 보면서 이해해보자.



*PromotionExample.java*

```java

```

부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다. 비록 변수는 자식 객체를 참조하지만 변수로 접근 가능한 멤버는 부모 클래스 멤버로 한정된다.

그러나 자식 클래스에서 오버라이딩된 메소드가 있다면 부모 메소드 대신 오버라이딩된 메소드가 호출된다. 이것은 다형성과 관련 있기 때문에 잘 알아두어야 한다. 

```java
class Parent {
    void method1() { ... }
    void method2() { ... }
}

class Child extends Parent {
    void method2() { ... }		// 오버라이딩
    void method3() { ... }
}

class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        
        Parent parent = child;
        
        parent.method1();
        
        parent.method2();
        
        parent.method3();	// 호출 불가능
    }
}
```

*Parent.java*

```java

```

*Child.java*

```java

```

*ChildExample.java*

```java

```

```

```

### 강제 타입 변환

자식 타입은 부모 타입으로 자동 변환되지만, 반대로 부모 타입은 자식 타입으로 자동 변환되지 않는다. 대신 다음과 같이 캐스팅 연산자로 강제 타입 변환을 할 수 있다.

```java
자식타입 변수 = (자식타입) 부모타입객체;
```

그렇다고 해서 부모 타입 객체를 자식 타입으로 무조건 강제 변환할 수 있는 것은 아니다. 자식 객체가 부모 타입으로 자동 변환된 후 다시 자식 타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.

```java
Parent parent = new Child();	// 자동 타입 변환
Child child = (Child) parent;	// 강제 타입 변환
```

자식 객체가 부모 타입으로 자동 변환하면 부모 타입에 선언된 필드와 메소드만 사용 가능하다는 제약 사항이 따른다. 만약 자식 타입에 선언된 필드와 메소드를 꼭 사용해야 한다면 강제 타입 변환을 해서 다시 자식 타입으로 변환해야 한다.

```java
class Parent {
    String field1;
    void method1() { ... }
    void method2() { ... }
}

class Child extends Parent {
    String field2;
    void method3() { ... }
}

class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.field1 = "xxx";
        parent.method1();
        parent.method2();
        parent.field2 = "yyy";			// 불가능
        parent.method3();				// 불가능
        
        Child child = (Child) parent;
        child.field2 = "yyy";			// 가능
        child.method3();				// 가능
    }
}
```

*Parent.java*

```java

```

*Child.java*

```java

```

*ChildExample.java*

```java

```

```

```

## 다형성

다형성이란 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질을 말한다. 자동차의 부품을 교환하면 성능이 다르게 나오듯이 객체는 부품과 같아서, 프로그램을 구성하는 객체를 바꾸면 프로그램의 실행 성능이 다르게 나올 수 있다.

객체 사용 방법이 동일하다는 것은 동일한 메소드를 가지고 있다는 뜻이다. 한국 타이어와 금호 타이어가 타이어를 상속하고 있다면 한국 타이어와 금호 타이어는 타이어(부모)의 메소드를 동일하게 가지고 있다고 말할 수 있다.

만약 한국 타이어와 금호 타이어가 타이어(부모)의 메소드를 오버라이딩하고 있다면, 타이어 메소드 호출 시 오버라이딩된 메소드가 호출된다. 오버라이딩된 내용은 두 타이어가 다르기 때문에 실행 결과가 다르게 나온다. 이것이 바로 다형성이다.

다형셩을 구현하기 위해서는 자동 타입 변환과 메소드 재정의가 필요하다. 한국 타이어와 금호 타이어는 타이어 타입(부모)으로 자동 타입 변환이 될 수 있고, 타이어 메소드를 재정의하고 있다.

```
자동 타입 변환 + 메소드 오버라이딩 => 다형성
```

### 필드 다형성

필드 다형성은 필드 타입은 동일하지만(사용 방법은 동일하지만), 대입되는 객체가 달라져서 실행 결과가 다양하게 나올 수 있는 것을 말한다. 다음 Car 클래스를 보면서 이해해보자.

```java
public class Car {
    // 필드 선언
    public Tire tire;
    
    // 메소드 선언
    public void run() {
        tire.roll();
    }
}
```

Car 클래스에는 Tire 필드가 선언되어 있다. 먼저 Car 객체를 생성한 후 타이어를 장착하기 위해 다음과 같이 HankookTire 또는 Kumho Tire 객체를 Tire 필드에 대입할 수 있다. 왜냐하면 자동 타입 변환이 되기 때문이다.

```java
// Car 객체 생성
Car myCar = new Car();
// HankookTire 장착
myCar.tire = new HankookTire();
// KumhoTire 장착
myCar.tire = new KumhoTire();
```

Car 클래스의 run() 메소드는 tire 필드에 대입된 객체의 roll() 메소드를 호출한다. 만약 HankookTire와 KumhoTire 객체를 Tire 필드에 대입할 수 있다. 왜냐하면 자동 타입 변환이 되기 때문이다.

```java
// Car 객체 생성
Car myCar = new Car();
// HankookTire 장착
myCar.tire = new HankookTire();
// KumhoTire 장착
myCar.tire = new KumhoTire();
```

Car 클래스의 run() 메소드는 tire 필드에 대입된 객체의 roll() 메소드를 호출한다. 만약 HankookTire와 KumhoTire가 roll() 메소드를 재정의하고 있다면, 재정의된 roll() 메소드가 호출된다.

```java
myCar.run();
```

따라서 어떤 타이어를 장착했는지에 따라 roll() 메소드의 실행 결과는 달라지게 된다. 이것이 바로 필드의 다형성이다. 예제를 통해 확인해보자.

*Tire.java*

```java

```

*HankookTire.java*

```java

```

*KumhoTire.java*

```java

```

*Car.java*

```java

```

*CarExample.java*

```java

```

```

```

### 매개변수 다형성

다형성은 필드보다는 메소드를 호출할 때 많이 발생한다. 메소드가 클래스 타입의 매개변수를 가지고 있을 경우, 호출할 때 동일한 타입의 객체를 제공하는 것이 정석이지만 자식 객체를 제공할 수도 있다. 여기서 다형성이 발생한다.

다음과 같이 Driver라는 클래스가 있고, Vehicle 매개변수를 갖는 drive() 메소드가 정의되어 있다고 가정해보자. drive() 메소드는 매개값으로 전달받은 vehicle의 run() 메소드를 호출한다.

```java
public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.run();
    }
}
```

일반적으로 drive() 메소드를 호출한다면 다음과 같이 Vehicle 객체를 제공할 것이다.

```java
Driver driver = new Driver();
Vehicle vehicle = new Vehicle();
driver.drive(vehicle);
```

그러나 매개값으로 Vehicle 객체만 제공할 수 있는 것은 아니다. 자동 타입 변환으로 인해 Vehicle의 자식 객체도 제공할 수 있다.

drive() 메소드는 매개변수 vehicle이 참조하는 객체의 run() 메소드를 호출하는데, 자식 객체가 run() 메소드를 재정의하고 있다면 재정의된 run() 메소드가 호출된다. 그러므로 어떤 자식 객체가 제공되느냐에 따라서 drive()의 실행 결과는 달라진다. 이것이 매개변수의 다형성이다.

```java
void drive(Vehicle vehicle) {
    vehicle.run();
}
```

예제를 통해서 설명했던 내용을 확인해보자.

*Vehicle.java*

```java

```

*Bus.java*

```java

```

*Taxi.java*

```java

```

*Driver.java*

```java

```

*DriverExample.java*

```java

```

```

```

## 객체 타입 변환

매개변수의 다형성에서 실제로 어떤 객체가 매개값으로 제공되었는지 확인하는 방법이 있다. 꼭 매개변수가 아니더라도 변수가 참조하는 객체의 타입을 확인하고자 할 때, instanceof 연산자를 사용할 수 있다.

instanceof 연산자의 좌항에는 객체가 오고 우항에는 타입이 오는데, 좌항의 객체가 우항의 타입이면 true를 산출하고 그렇지 않으면 false를 산출한다.

```java
boolean result = 객체 instanceof 타입;
```

예를 들어 다음 코드는 Child 타입으로 강제 타입 변환하기 전에 매개값이 Child 타입인지 여부를 instanceof 연산자로 확인한다. Child 타입이 아니라면 강제 타입 변환을 할 수 없기 때문이다. 강제 타입 변환을 하는 이유는 Child 객체의 모든 멤버(필드, 메소드)에 접근하기 위해서이다.

```java
public void method(Parent parent) {
    if(parent instanceof Child) {
        Child child = (Child) parent;
        // child 변수 사용
    }
}
```

Java 12부터는 instanceof 연산의 결과가 true일 경우, 우측 타입 변수를 사용할 수 있기 때문에 강제 타입 변환이 필요 없다.

```java
if(parent instanceof Child child) {
    // child 변수 사용
}
```

다음은 personInfo() 메소드의 매개값으로 Student를 제공했을 경우에만 studentNo를 출력하고 study() 메소드를 호출한다.

*InstanceofExample.java*

```java

```

*Person.java*

```java

```

*Student.java*

```java

```

```

```

## 추상 클래스

사전적 의미로 추상은 실체 간에 공통되는 특성을 추출한 것을 말한다. 예를 들어 새, 곤충, 물고기 등의 공통점은 동물이다. 여기서 동물은 실체들의 공통되는 특성을 가지고 있는 추상적인 것이라고 볼 수 있다.

### 추상 클래스란?

객체를 생성할 수 있는 클래스를 실체 클래스라고 한다면, 이 클래스들의 공통적인 필드나 메소드를 추출해서 선언한 클래스를 추상 클래스라고 한다. 추상 클래스는 실체 클래스의 부모 역할을 한다. 따라서 실체 클래스는 추상 클래스를 상속해서 공통적인 필드나 메소드를 물려받을 수 있다.

예를 들어 Bird, Insect, Fish와 같은 실체 클래스에서 공통되는 필드와 메소드를 따로 선언한 Animal 클래스를 만들 수 있고, 이것을 상속해서 실체 클래스를 만들 수 있다.



추상 클래스는 실체 클래스의 공통되는 필드와 메소드를 추출해서 만들었기 때문에 new 연산자를 사용해서 객체를 직접 생성할 수 없다.

```java
Animal animal = new Animal()	// x
```

추상 클래스는 새로운 실체 클래스를 만들기 위한 부모 클래스로만 사용된다. 즉, 추상 클래스는 extends 뒤에만 올 수 있다.

```java
class Fish extends Animal {
    ...
}
```

### 추상 클래스 선언

클래스 선언에 abstract 키워드를 붙이면 추상 클래스 선언이 된다. 추상 클래스는 new 연산자를 이용해서 객체를 직접 만들지 못하고 상속을 통해 자식 클래스만 만들 수 있다.

```java
public abstract class 클래스명 {
	// 필드
    // 생성자
    // 메소드
}
```

추상 클래스도 필드, 메소드를 선언할 수 있다. 그리고 자식 객체가 생성될 때 super()로 추상 클래스의 생성자가 호출되기 때문에 생성자도 반드시 있어야 한다. 다음은 모든 전화기의 공통 필드와 메소드만 뽑아내어 추상 클래스 Phone으로 선언한 것이다.

*Phone.java*

```java

```

그렇다면 새로운 전화기 클래스는 추상 클래스인 Phone으로부터 공통 필드와 메소드를 물려받고 특화된 필드와 메소드를 작성할 수 있다. 다음은 Phone을 상속해서 SmartPhone을 설계한 것이다.

*SmartPhone.java*

```java

```

Phone 객체는 new 연산자로 직접 생성할 수는 없지만 자식 객체인 SmartPhone은 new 연산자로 객체 생성이 가능하고, Phone으로부터 물려받은 turnOn()과 turnOff() 메소드를 호출할 수 있다.

*PhoneExample.java*

```java

```

```

```

### 추상 메소드와 재정의

자식 클래스들이 가지고 있는 공통 메소드를 뽑아내어 추상 클래스로 작성할 때, 메소드 선언부(리턴타입, 메소드명, 매개변수)만 동일하고 실행 내용은 자식 클래스마다 달라야 하는 경우가 많다.

예를 들어 동물은 소리를 내기 때문에 Animal 추상 클래스에서 sound()라는 메소드를 선언할 수 있지만, 실행 내용인 소리는 동물마다 다르기 때문에 추상 클래스에서 통일하여 작성할 수 없다.

이런 경우를 위해서 추상 클래스는 다음과 같은 추상 메소드를 선언할 수 있다. 일반 메소드 선언과의 차이점은 abstract 키워드가 붙고, 메소드 실행 내용인 중괄호 {}가 없다.

```java
abstract 리턴타입 메소드명(매개변수, ...);
```

추상 메소드는 자식 클래스의 공통 메소드라는 것만 정의할 뿐, 실행 내용을 가지지 않는다. 다음은 Animal 추상 클래스에서 sound() 추상 메소드를 선언한 것이다.

```java
public abstract class Animal {
    abstract void sound();
}
```

추상 메소드는 자식 클래스에서 반드시 재정의(오버라이딩)해서 실행 내용을 채워야 한다. 따라서 Animal 클래스를 상속하는 자식 클래스는 고유한 소리를 내도록 sound() 메소드를 반드시 재정의해야 한다. 예를 들어 Dog는 '멍멍', Cat은 '야옹' 소리를 내도록 말이다.

*Animal.java*

```java

```

*Dog.java*

```java

```

*Cat.java*

```java

```

*AbstractMethodExample.java*

```java

```

```

```

## 봉인된 클래스

기본적으로 final 클래스를 제외한 모든 클래스는 부모 클래스가 될 수 있다. 그러나 Java 15부터는 무분별한 자식 클래스 생성을 방지하기 위해 봉인된(sealed) 클래스가 도입되었다.

다음과 같이 Person의 자식 클래스는 Employee와 Manager만 가능하고, 그 이외는 자식 클래스가 될 수 없도록 Person을 봉인된 클래스로 선언할 수 있다.

```java
public sealed class Person	permits Employee, Manager{ ... }
```

sealed 키워드를 사용하면 permits 키워드 뒤에 상속 가능한 자식 클래스를 지정해야 한다. 봉인된 Person 클래스를 상속하는 Employee와 Manager는 final 또는 non-sealed 키워드로 다음과 같이 선언하거나, sealed 키워드를 사용해서 또 다른 봉인 클래스로 선언해야 한다.

```java
public final class Employee extends Person { ... }
public non-sealed class Manager extends Person { ... }
```

final은 더 이상 상속할 수 없다는 뜻이고, non-sealed는 봉인을 해제한다는 뜻이다. 따라서 Employee는 더 이상 자식 클래스를 만들 수 없지만 Manager는 다음과 같이 자식 클래스를 만들 수 있다.

```java
public class Director extends Manager { ... }
```

설명한 내용을 실습으로 확인해보자.

*Person.java*

```java

```

*Employee.java*

```java

```

*Manager.java*

```java

```

*Director.java*

```java

```

*SealedExample.java*

```java

```

```

```

