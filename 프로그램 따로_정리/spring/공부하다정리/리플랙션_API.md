# Reflection API란?

https://tecoble.techcourse.co.kr/post/2020-07-16-reflection-api/

https://12bme.tistory.com/129

구체적인 클래스 타입을 알지 못해도

그클래스의 정보(메서드, 타입, 변수 등등)에 접근할 수 있게 해주는 API다.

```java
public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
public class test {
    public static void main(String[] args) {
        Object obj = new Car("foo", 0);
        obj.move();
    }
}
```

생성된 obj라는 객체는 Object 클래스라는 타입만 알 뿐,

Car 클래스라는 구체적인 타입은 모른다.

결국 컴파일러가 있는 자바는 구체적인 클래스를 모르면

해당 클래스의 정보에 접근 할 수 없다는 것을 알 수 있다.

---

이렇게 불가능한 일을 마법처럼 가능하게 해주는 것이

**Reflection API** 이다.

위에서 봤던 예제와 똑같은 상황에서 Reflection API를

활용해 Car 클래스의 move 메서드를 호출 해보자.

```java
import java.lang.reflect.Method;

class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}

public class test {
    public static void main(String[] args) throws Exception {
        Object obj = new Car("foo", 0);
        Class carClass = Car.class; // 인스턴스왜
        Method move = carClass.getMethod("move"); // carClass안에 있는 메소드 한개를 가져온거다

        // move 메서드 실행, invoke(메서드를 실행시킬 객체, 해당 메서드에 넘길 인자)
        move.invoke(obj, null);

        Method getPosition = carClass.getMethod("getPosition");
        int position = (int) getPosition.invoke(obj, null);
        System.out.println(position);
        // 출력 결과: 1
    }
}

Class carClass = Car.class; // 인스턴스을 임시적으로 할당을 하여 carClass에 넣어라
Method move = carClass.getMethod("move"); // Method 는 메소드를 담을 수있는 함수의 데이터 형이다.

//보통 Java 문법은 S(주어:object) V(동사:method) O(목적어:argument) 순서이지만,
//reflection 은 V.invoke(S,O) 순이라고 보면된다. 
// invoke(메서드를 실행시킬 객체, 해당 메서드에 넘길 인자)
move.invoke(obj, null);
```

---

## 어떻게 가능할까?

자바에서는 JVM이 실행되면 사용자가 작성한 자바 코드가

컴파일러를 거쳐 바이트 코드로 변환되어 static 영역에 저장된다.

Reflection API는 이 정보를 활용한다.

그래서 클래스 이름만 알고 있다면 언제든

static 영역을 뒤져서 정보를 가져올 수 있는 것이다.

---

## 어디에 활용할 수 있을가?

위에서 살펴봤던 예제 코들르 보면 멀쩡한 Car객체를

Object 타입으로 생성하고 있다.

실제로 우리가 코드를 작성할때는 예제와 같이 작성하지 않는다.

치명적인 단점중 대표적으로 성능 오버헤드가 있다.

**컴파일 타임이 아닌 런타임에 동적으로 타입을 분석하고 정보를 가져오므로**

JVM을 최적화 할 수 없기 때문이다.

뿐만 아니라 **직접 접근할 수 없는 private 인스턴스 변수, 메서드에 접근 하기 때문에**

내부를 노출하면서 추상화가 깨진다.

이로 인해 예기치 못한 부작용이 발생할 수 있다.

---

## 누가 사용을 하는가?

결론적으로 Reflection은 애플리 케이션 개발보다는

프레임 워크나 라이브러에서 많이 사용된다.

프레임워크나 라이브러리는 사용자가

어떤 클래스를 만들지 예측할 수 없기 때문

동적으로 해결해주기 위해 Reflection을 사용한다.

---

## 사용하는 곳

Spring Framework에서도 Reflection API를 사용하는데 대표적으로

Spring Container의 BeanFactory가 있다.

Bean은 애플리케이션 이 실행한 후

런타임에 객체가 호출괼 때 동적으로 객체의 인스턴스를

생성하는데 이때 Spring Container의 BeanFactory에서 리플렉션을 사용한다.

---

## 리플랙션은 생성자 인자를 받아야한다.

Spring Data JPA 에서 Entity에 기본 생성자가 필요한 이유도

동적으로 객체 생성 시 Reflection API를 활용하기 때문이다.

Reflection API로 가져올 수 없는 정보 중 하나가 생성자의 인자 정보이다.

그래서 기본 생성자가 반드시 있어야 객체를 생성할 수 있는 것이다.

기본 생성자로 객체를 생성만 하면 필드 값은

Relection API로 넣어 줄 수 있다.

---
