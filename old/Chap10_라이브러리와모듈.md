# 라이브러리와 모듈

## 라이브러리

라이브러리는 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것을 말한다. 일반적으로 JAR 압축 파일(~.jar) 형태로 존재한다. JAR 파일에는 클래스와 인터페이스의 바이트코드 파일(~.class)들이 압축되어 있다.

특정 클래스와 인터페이스가 여러 응용프로그램을 개발할 때 공통으로 자주 사용된다면 JAR 파일로 압축해서 라이브러리로 관리하는 것이 좋다. 참고로 이클립스는 Java Project를 생성해서 클래스와 인터페이스를 개발하고 최종 산출물로 JAR 파일을 만드는 기능이 있다.

프로그램 개발 시 라이브러리를 이용하려면 라이브러리 JAR 파일을 ClassPath에 추가해야 한다. ClassPath란 말 그대로 클래스를 찾기 위한 경로이다. ClassPath에 라이브러리를 추가하는 방법은 다음과 같다.

* 콘솔(명령 프롬프트 또는 터미널)에서 프로그램을 실행할 경우
  * java 명령어를 실행할 때 -classpath로 제공
  * CLASSPATH 환경 변수에 경로를 추가
* 이클립스 프로젝트에서 실행할 경우
  * 프로젝트의 Build Path에 추가

라이브러리를 생성하고 프로그램에서 이용하는 방법을 실습을 통해 알아보자.

### my_lib 라이브러리 프로젝트 생성

1. 이클립스 메뉴에서 File - New - Java Project를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 Finish 버튼을 클릭한다.

   ```
   Project name : my_lib
   Module : [체크안함] Create module-info.java file (중요)
   ```

2. Package Explorer 뷰에서 src 폴더를 선택하고 마우스 오른쪽 버튼을 클릭하여 New - Package로 pack1과 pack2 패키지를 생성한다. 그리고 그 밑에 각각 A와 B 클래스를 다음과 같이 작성한다.

   A.java

   ```java
   ```

   B.java

   ```java
   ```

3. Package Explorer 뷰에서 my_lib 프로젝트를 선택하고 마우스 오른쪽 버튼을 클릭하여 New - Folder를 선택해 이름이 dist인 폴더를 생성한다.

4. my_lib 프로젝트를 선택하고 마우스 오른쪽 버튼을 클릭해 Export를 선택한다. Export 대화상자의 Select an export wizard에서 Java 항목을 확장하면 보이는 JAR file을 선택한 후 Next 버튼을 클릭한다.

5. Select the resources to export에서 my_lib를 확장한 후 그 안에 있는 src 폴더만 체크하고 나머지는 모두 체크 해제한다.

6. Select the export destination에서 Browse 버튼을 클릭하고, my_lib 프로젝트의 dist 폴더로 이동한다. 파일 이름은 'my_lib.jar'로 입력하고 저장과 Finish 버튼을 클릭한다.

7. Package Explorer 뷰에서 my_lib 프로젝트를 선택하고 마우스 오른쪽 버튼을 클릭해 Refresh를 선택한다. 그리고 다음과 같이 구조가 생성되었는지 확인한다.

### my_application_1 프로젝트 생성

1. 이클립스 메뉴에서 File - New - Java Project를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 Finish 버튼을 클릭한다.

   ```
   Project name : my_application_1
   Module : [체크안함] Create module-info.java file (중요)
   ```

2. my_application_1 프로젝트를 이클립스에서 컴파일할 때와 실행할 때 라이브러리 파일인 my_lib.jar을 사용하기 위해 Build Path에 추가해보자. Package Explorer 뷰에서 my_application_1 프로젝트를 선택하고 마우스 오른쪽 버튼을 클릭해 Build Path - Configure Build Path를 선택한다.

3. Libraries 탭에 들어가 JARs and class folders on the build path에서 ClassPath 항목을 선택하고 Add External JARs 버튼을 클릭한다. my_lib 프로젝트의 dist 폴더에 있는 my_lib.jar 파일을 선택하고 열기와 Apply and Close 버튼을 클릭한다. 다시 Package Explorer 뷰에서 my_application_1 프로젝트를 선택하고 Build Path - Configure Build Path를 선택하면 다음과 같이 라이브러리 파일이 등록된 것을 볼 수 있다.

4. my_application_1 프로젝트의 src 폴더 안에 app 패키지를 하나 생성하고 그 안에 Main 클래스를 오른쪽 화면과 같이 생성한다.

5. Main 클래스에는 다음과 같이 작성하고, 이클립스에서 실행한다.

   *Main.java*

   ```java
   ```

   ```
   ```

### 콘솔에서 -classpath 옵션 사용

이번에는 윈도우 명령 프롬프트 또는 맥OS 터미널에서 -classpath 옵션을 주고 실행하는 방법을 알아보자.

* 윈도우

  명령 프롬프트에서 다음과 같이 현재 경로를 bin 디렉터리로 이동하고 Main 클래스를 실행한다.

  ```cmd
  ```

  Exception in thread "main" java.lang.NoClassDefFoundError: pack1/A라는 에러가 출력될 것이다. 이것은 my_lib.jar 라이브러리를 인식하지 못했기 때문이다. 이번에는 다음과 같이 -classpath 옵션을 주고 my_lib.jar 파일 경로를 추가해서 실행해보자.

  ```
  ```

  -classpath 대신 -cp를 사용해도 된다. 경로 뒤에 세미콜론(;)과 함께 마침표(.)를 추가했는데, 이것은 현재 경로에서 app.Main을 찾기 위해서이다. 윈도우에서 classpath 구분자는 세미콜론(;)이므로 주의해야 한다.

* 맥OS

  터미널에서는 다음과 같이 실행한다. 맥OS에서 classpath 구분자는 콜론이므로 콜론(;)과 함께 마침표(.)를 경로 뒤에 추가해야 한다.

  ```
  ```

### 환경 변수 CLASSPATH 사용

-classpath 옵션은 java 명령어를 실행할 때마다 별도로 추가해야 하는 불편함이 있다. 여러 프로그램에서 공통으로 사용하는 라이브러리는 환경 변수 CLASSPATH에 경로를 추가하면 이러한 불편함을 없앨 수 있다.

* 윈도우

  환경 변수 대화상자에서 시스템 변수에 'CLASSPATH' 변수를 추가한다. 변수값에는 my_lib.jar 파일의 파일 경로를 입력한다.

  맨 앞에 .;을 추가한 이유는 현재 디렉터리에서 먼저 찾은 후 없으면 뒤의 경로에서 찾도록 하기 위해서이다. 명령 프롬프트를 새로 열고 다음과 같이 실행해보자.

  ```
  ```

* 맥OS

  `<사용자 홈>` 디렉터리에서 ls -all 명령어를 실행해서 .bash_profile을 찾아보고, 없으면 다음과 같이 생성한다.

  ```
  ```

  .bash_profile 파일을 텍스트 에디터로 열고 다음과 같이 작성하고 저장한다. 맨 앞에 .:을 작성할 때 주의할 점은 윈도우와 달리 경로 구분자가 콜론(:)이라는 것이다.

  ```
  ```

  터미널을 열고 ~/.bash_profile 내용을 적용하기 위해 다음 명령어를 실행시킨다.

  ```
  ```

  그리고 다음과 같이 실행해보자.

  ```
  ```

## 모듈

Java 9부터 지원하는 모듈은 패키지 관리 기능까지 포함되는 라이브러리이다. 일반 라이브러리는 내부에 포함된 모든 패키지에 외부 프로그램에서의 접근이 가능하지만, 모듈은 다음과 같이 일부 패키지를 은닉하여 접근할 수 없게끔 할 수 있다.



또 다른 차이점은 모듈은 자신이 실행할 때 필요로 하는 의존 모듈을 모둘 기술자(module-info.java)에 기술할 수 있기 때문에 모듈 간의 의존 관계를 쉽게 파악할 수 있다는 것이다. 아래 그림은 A 모듈은 B 모듈이 있어야 실행할 수 있고, B 모듈은 C 모듈이 있어야 실행할 수 있는 의존 관계를 보여준다.

**`A 모듈` → `B 모듈` → `C 모듈`**

모듈도 라이브러리이므로 JAR 파일 형태로 배포할 수 있다. 응용프로그램을 개발할 때 원하는 기능의 모듈(JAR) 파일을 다운로드해서 이용하면 된다.



대규모 응용프로그램은 기능별로 모듈화(modulization)해서 개발할 수도 있다. 모듈별로 개발하고 조립하는 방식을 사용하면 재사용성 및 유지보수에 유리하기 때문이다.

## 응용프로그램 모듈화

응용프로그램은 하나의 프로젝트로도 개발이 가능하지만, 이것을 기능별로 서브 프로젝트(모듈)로 쪼갠 다음 조합해서 개발할 수도 있다. 다음 그림처럼 my_application_2 응용프로그램은 2개의 서브 프로젝트(모듈)인 my_module_a와 my_module_b로 쪼개서 개발하고, 이들을 조합해서 완성할 수 있다.



응용프로그램의 규모가 커질수록 협업과 유지보수 측면에서 서브 모듈로 쪼개서 개발하는 것이 유리하며, 이렇게 개발한 모듈들은 다른 응용프로그램에서도 재사용이 가능하다. 위 그림과 동일한 환경을 만들어 모듈 생성 및 사용법을 학습해보자.

### my_module_a 모듈 생성

1. 이클립스 메뉴에서 File - New - Java Project를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 Finish 버튼을 클릭한다.

   ```
   Project name : my_module_a
   Module : [체크] Create module-info.java file (중요)
   ```

2. Create module-info.java 대화상자가 나타나면 모듈 이름이 기본 입력되어 있는지 확인하고 Create 버튼을 클릭한다.

   ```
   Module name : my_module_a
   ```

3. my_module_a 모듈의 src 폴더에 pack1과 pack2 패키지를 생성한다. 그리고 각 패키지에 A 클래스와 B 클래스를 다음과 같이 생성한다.

   

4. A와 B 클래스에는 다음과 같이 각각 하나의 메소드를 선언한다.

   *A.java*

   ```java
   ```

   *B.java*

   ```java
   ```

5. my_module_a 모듈이 포함하고 있는 두 개의 pack1과 pack2를 외부에서 사용할 수 있도록 모듈 기술자(module-info.java)를 다음과 같이 작성한다. exports 키워드는 모듈이 가지고 있는 패키지를 외부에서 사용할 수 있도록 노출시키는 역할을 한다.

   *module-info.java*

   ```java
   ```

### my_module_b 모듈 생성

1. 이클립스 메뉴에서 File - New - Java Project를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 Finish 버튼을 클릭한다.

   ```
   Project name : my_module_b
   Module : [체크] Create module-info.java file (중요)
   ```

2. Create module-info.java 대화상자가 나타나면 모듈 이름이 기본 입력되어 있는지 확인하고, Create 버튼을 클릭한다.

   ```
   Module name : my_module_b
   ```

3. my_module_b 모듈의 src 폴더에 pack3과 pack4 패키지를 생성한다. 그리고 각 패키지에 C 클래스와 D 클래스를 다음과 같이 생성한다.

4. C와 D 클래스에는 다음과 같이 각각 하나의 메소드를 선언한다.

   *C.java*

   ```java
   ```

   *D.java*

   ```java
   ```

5. my_module_b 모듈이 포함하고 있는 두 개의 pack3과 pack4를 외부에서 사용할 수 있도록 모듈 기술자(module-info.java)를 다음과 같이 작성한다.

   *module_info.java*

   ```java
   ```

### my_application_2 프로젝트 생성

이제 my_module_a와 my_module_b를 조합하는 my_application_2 프로젝트를 생성해보자.

1. 이클립스 메뉴에서 File - New - Java Project를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 Finish 버튼을 클릭한다.

   ```
   Project name : my_application_2
   Module : [체크] Create module-info.java file (중요)
   ```

2. Create module-info.java 대화상자가 나타나면 모듈 이름이 기본 입력되어 있는지 확인하고, Create 버튼을 클릭한다.

   ```
   Module name : my_application_2
   ```

   cf) : my_module_a와 my_module_b가 Modulepath에 있어야 하는 이유

   my_application_2는 결국 my_module_a와 my_module_b를 사용해야 하므로 이 두 모듈이 전부 ClassPath 위치에 있어야 한다.

3. my_application_2 프로젝트의 모듈 기술자를 다음과 같이 수정한다. my_module_a와 my_module_b의 직접적 의존을 주석 처리하는 대신에 집합 모듈인 my_module을 의존한다.

   *module-info.java*

   ```java
   ```

   Main 클래스는 수정할 내용이 없으니 실행만 해보자.

   *Main.java*

   ```java
   ```

   ```
   ```

   집합 모듈인 my_module만 requires하더라도 my_module_a와 my_module_b 소속의 클래스 A와 C를 사용하는 데에는 아무런 문제가 발생하지 않는다.

## 리플렉션 허용

은닉된 패키지는 기본적으로 다른 모듈에 의해 리플렉션을 허용하지 않는다. 리플렉션이란 실행 도중에 타입(클래스, 인터페이스 등)을 검사하고 구성 멤버를 조사하는 것을 말한다.

경우에 따라서는 은닉된 패키지도 리플렉션을 허용해야 할 때가 있다. 모듈은 모듈 기술자를 통해 모듈 전체 또는 지정된 패키지에 대해 리플렉션을 허용할 수 있고, 특정 외부 모듈에서만 리플렉션을 허용할 수도 있다.

**모듈 전체를 리플렉션 허용**

```java
open module 모듈명 {
    ...
}
```

**지정된 패키지에 대해 리플렉션 허용**

```java
module 모듈명 {
    ...
    opens 패키지1;
    opens 패키지2;
}
```

**지정된 패키지에 대해 특정 외부 모듈에서만 리플렉션 허용**

```java
module 모듈명 {
    ...
    opens 패키지1 to 외부모듈명, 외부모듈명, ...;
    opens 패키지2 to 외부모듈명;
}
```

export된 패키지는 언제든지 리플렉션이 가능하므로 opens로 지정할 필요가 없다. opens는 은닉된 패키지 중에서 특정 패키지에 대한 리플렉션을 허용한다.

리플렉션 프로그래밍 방법은 12, 11절에서 자세히 학습하기로 하고, 여기서는 간단히 open, opens 키워드로 리플렉션을 허용할 수 있다는 것만 알고 넘어가자.

## 자바 표준 모듈

자바 프로그램이라면 반드시 활용해야 하는 라이브러리가 있다. 바로 JDK가 제공하는 표준 라이브러리이다. 표준 라이브러리는 Java 9부터 모듈화가 되어 다음 그림처럼 Java 17 표준 모듈이 완성되었다. 화살표는 모듈간의 의존 관계를 표시한다.



지면상 일부만 담았으며, Java 17의 전체 모듈 그래프는 다음 URL에서 자세히 볼 수 있다.

```java
https://docs.oracle.com/en/java/javase/17/docs/api/java.se/module-summary.html
```

그림에서 보듯이 java.base는 모든 모듈이 의존하는 기본 모듈이다. java.base 모듈은 requires하지 않아도 사용할 수 있지만, 다른 모듈들은 모듈 기술자에 requires를 명시하고 사용해야 한다. java.base 모듈에는 java.lang, java.util, java.io 등의 핵심 패키지가 있으며, java.lang을 제외하고 import해서 사용할 수 있다.

java.se는 JDK가 제공해는 모든 모듈을 제공하는 집합 모듈이다. Java 8 이전 버전과 같이 자바 표준 라이브러리를 제한 없이 사용하고 싶을 경우에는 이 java.se를 requires하면 된다.

```java
module my_application {
    requires java.se;
}
```

또 다른 방법은 thisisjava 프로젝트처럼 모듈 기술자가 없는 프로젝트를 만드는 것이다. 모듈 기술자가 없으면 모듈로 인식되지 않기 때문에 자바 표준 라이브러리를 제한 없이 사용할 수 있다.

Java 8 이전 버전까지는 응용프로그램이 표준 라이브러리의 5%만 사용하는데도 불구하고 응용프로그램을 실행하려면 전체 표준 라이브러리가 갖추어진 자바 실행 환경(JRE)이 필요했었다.

표준 라이브러리를 모듈화한 이유는 응용프로그램을 실행하는데 필요한 모듈만으로 구성된 작은 사이즈의 자바 실행 환경(JRE)을 만들기 위해서이다. 작은 사이즈의 자바 실행 환경이 필요한 경우는 다음과 같다.

* 독립 실행형(응용프로그램 + 표준 라이브러리)으로 배포할 경우 표준 라이브러리의 크기가 작을수록 배포 사이즈가 줄어든다.
* 제한된 자원만 가지고 있는 소형(임베디드) 기기에는 사이즈가 작은 자바 실행 환경이 필요하다.

다음 그림을 보면 자바 표준 모듈은 모듈 A에서 모듈 D까지 제공하지만, 프로젝트를 실행하는 데는 모듈 A와 모듈 B만 있으면 된다. 따라서 모듈 C와 모듈 D를 제외하고 프로젝트만 실행할 수 있는 작은 실행 환경 jlink 명령어로 생성할 수 있다.



**Java 8의 콤팩트 프로파일**

Java 8의 콤팩트 프로파일(compact1, compact2, compact3)도 작은 사이즈의 자바 실행 환경을 위해 도입되었다. 그러나 compact2에 소속된 1개의 클래스만 필요한 경우에도 어쩔 수 없이 compact1보다 더 큰 compact2를 배포해야 하는 단점은 있다.

