# 조건문과 반복문

## 코드 실행 흐름 제어

## if 문

## switch 문

case에 어떤 자료형이든 넣을 수 있다(list, hashmap 등). 또한 여러 값을 하나의 case에 넣을 수도 있다.

## for 문

### 향상된 for 문(foreach) 문

```java
for (데이터타입 변수이름 : 배열이나 컬렉션) {
    // 반복할 코드
}
```

*배열 순회*

```java
int[] numbers = {1, 2, 3, 4, 5};

for (int number : numbers) {
    System.out.println(number); // 배열 요소를 하나씩 출력
}
```

*컬렉션 순회*

```java
import java.util.ArrayList;
import java.util.List;

List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

for (String name : names) {
    System.out.println(name); // 리스트의 각 이름을 출력
}
```

## HashMap 순회

*키-값 쌍 순회*

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Cherry", 7);

        // Entry Set을 사용하여 순회
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

*키만 순회*

```java
for (String key : map.keySet()) {
    System.out.println("Key: " + key);
}
```

*값만 순회*

```java
for (Integer value : map.values()) {
    System.out.println("Value: " + value);
}
```

## Iterator를 사용한 순회

Iterator는 자바를 포함한 많은 프로그래밍 언어에서 컬렉션(Collection)의 요소들을 순차적으로 접근할 수 있는 도구이다. 쉽게 말해, 순회(iteration)를 수행하기 위한 객체이다. 이터레이터는 특히 요소의 순서에 접근하거나 탐색이 필요한 경우 유용하게 사용된다.

### Iterator의 특징

* 통일된 방식

​	배열, 리스트, 셋(Set), 맵(Map)과 같은 다양한 컬렉션을 순회할 수 있도록 설계됨.

* 단방향 이동

​	이터레이터는 컬렉션의 요소를 한 방향(앞으로)으로만 이동하며, 뒤로 돌아갈 수 없다.

* 동적 관리

​	컬렉션 요소를 순회하는 도중 요소를 제거하는 등 변경 작업을 수행할 수 있다.



### Iterator를 사용하는 이유

가독성: 컬렉션의 내부 구조를 몰라도 순회할 수 있는 간결한 방식.

안전성: 순회 중에도 컬렉션 요소를 변경할 수 있으며, 직접 인덱스를 다루지 않아 오류 가능성을 줄임.

범용성: 다양한 데이터 구조를 일관된 방식으로 처리 가능.

### Iterator의 주요 메소드

`hasNext()`: 다음 요소가 있는지 확인하고 **true** 또는 **false**를 반환한다.

`next()`: 다음 요소를 반환하며, 커서를 다음 위치로 이동한다.

`remove()`: 현재 요소를 삭제한다(선택적 메서드).

### 동작 원리

`map.entrySet().iterator()`를 호출하여 HashMap의 Entry Set을 기반으로 Iterator를 생성.

`iterator.hasNext()`를 통해 다음 요소가 있는지 확인.

`iterator.next()`를 호출하여 현재 요소를 가져온다.

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterator 생성
        Iterator<String> iterator = list.iterator();

        // 순회
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // 필요하면 요소 삭제
            if (element.equals("Banana")) {
                iterator.remove();
            }
        }

        System.out.println("After removal: " + list); // ["Apple", "Cherry"]
    }
}
```

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Cherry", 7);

        // Iterator를 사용하여 순회
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

## while 문

*KeyControlExample.java*

```java
package Chap4_ConditionalAndLoop;

import java.util.Scanner;

public class KeyControlExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("------------------------------");
			System.out.println("선택 : ");
			
			String strNum = scanner.nextLine();
			
			if(strNum.equals("1")) {
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if(strNum.equals("2")) {
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if(strNum.equals("3")) {
				run = false;
			}
		}
		
		System.out.println("시스템 종료");

	}

}

```

```
------------------------------
1. 증속 | 2. 감속 | 3. 중지
------------------------------
선택 : 
1
현재 속도 = 1
------------------------------
1. 증속 | 2. 감속 | 3. 중지
------------------------------
선택 : 
3
시스템 종료

```

### do-while 문

*DoWhileExample.java*

```java
package Chap4_ConditionalAndLoop;

import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		
		System.out.println("메세지 입력");
		System.out.println("q를 누르면 종료");
		
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.println(">");
			inputString = scanner.nextLine();
			System.out.println(inputString);
		} while ( ! inputString.equals("q"));
		
		System.out.println();
		System.out.println("프로그램 종료");

	}

}
```

```
메세지 입력
q를 누르면 종료
>
안녕
안녕
>
방가
방가
>
q
q

프로그램 종료
```

## break 문

### 라벨

`Outter:`는 라벨(label)로, 자바에서 특정 반복문에 이름을 부여할 때 사용된다. 이 이름을 통해 해당 반복문을 쉽게 참조하고, 특정 조건에서 반복문 전체를 빠져나갈 수 있다. 자바에서 라벨은 보통 `break`나 `continue`와 함께 사용되며, 코드의 흐름을 제어하는 데 도움을 준다.

#### 라벨의 역할

위 코드에서 `Outter:`는 외부 반복문을 가리킨다. 내부 반복문에서 `break Outter;`를 호출하면, 내부 반복문뿐만 아니라 외부 반복문까지 종료된다. 즉, 라벨은 어느 반복문을 종료하거나 건너뛸지를 지정하는 역할을 한다.

#### 사용 사례

라벨은 복잡한 중첩 반복문에서 특정 조건에 따라 반복문을 빠져나가야 할 때 유용하다. 하지만 코드 가독성을 위해 지나치게 남용하지 않는 것이 좋다. 대체로 라벨 대신 메서드 분리와 같은 다른 접근법을 권장한다.

*BreakOutterExample.java*

```java
package Chap4_ConditionalAndLoop;

public class BreakOutterExample {

	public static void main(String[] args) throws Exception {
		
		Outter: for(char upper='A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}
		
		System.out.println("프로그램 실행 종료");

	}

}
```

```
A-a
A-b
A-c
A-d
A-e
A-f
A-g
프로그램 실행 종료
```

## continue 문

*ContinueExample.java*

```java
package Chap4_ConditionalAndLoop;

public class ContinueExample {

	public static void main(String[] args) throws Exception {
		
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {
				continue;
			}
			
			System.out.println(i + " ");
			
		}

	}

}
```

```
2 
4 
6 
8 
10 
```

