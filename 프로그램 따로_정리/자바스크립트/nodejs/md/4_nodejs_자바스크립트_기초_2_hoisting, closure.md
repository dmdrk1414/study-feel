hoisting, closure

# nodejs 하기 전에 js 기초를 보기

## Hoisting - var

```js
var x = 1;
console.log(x);
```

이 코드의 값은?

```
 1
```

너무 당연하죠?

```js
console.log(x);
var x = 1;
```

은 뭘까요?

```
undefined
```

입니다.
js는 변수의 선언은 그범위 내에서 맨위로 올라갑니다 **hoisting**

즉 hoisting이란 변수의 선언을 해당 스코프의 맨 위로 끌어올리는 것을 뜻합니다.

---

Hoisting - function

```js
function foo() {
  return "foo";
}
console.log(foo());
```

```js
console.log(foo());
function foo() {
  return "foo";
}
```

두개는 같은 것입니다. 함수또한 **hoisting**입니다.

---

# function, lexical scope

코드의 어떤 식별자가 실제로 어떤 값이 가리키는지를 결정하는 것을 **binding**이라고 합니다.

자바스크립트에서 binding은 **lexical scope**을 통해 이루어지며

**lexical scope**란 간단히 말하면 안쪽에서 바깥쪽 변수에 접근하능하다.

```js
function foo() {
  var x = "Hello";
  console.log(x);
}
console.log(x);
```

```
console.log(x);
            ^

ReferenceError: x is not defined
```

이경우는?

```js
var x = "Hello";

function foo() {
  console.log(x); // 'Hello'
}

console.log(x); // "hello"
```

```
Hello
Hello
```

입니다.

---

# closure = function + environment

closure는 저도 처음 들어 봅니다.

closure는 function이 하나 생길 때마다 하나씩 생깁니다.

environment는 함수 자신을 둘러싼, 접근할 수 있는 모든 스코프를 뜻합니다.

```js
function and(x) {
  return function print(y) {
    return x + " and " + y;
  };
}

const saltAnd = and("salt");
console.log(saltAnd("pepper"));
console.log(saltAnd("sugar"));
```

```
salt and pepper
salt and sugar
```

이야 이런건 처음보네

and 함수로 만들어진 saltAnd의 closure는

## closure = 함수 + 환경

- 함수: print
- 환경: x -> "salt" 입니다

closure는 **higher-order function** 을만드는데 유용하다.

(함수를 담는) 고차원의 함수입니다

---

예시2

```js
function and(x) {
  return function print(y) {
    return x + " and " + y;
  };
}

const saltAnd = and("salt");
console.log(saltAnd("pepper"));
console.log(saltAnd("sugar"));

const waterAnd = and("water");
console.log(waterAnd("juice"));
```

```
salt and pepper
salt and sugar
water and juice
```

여기에 closure는 총 몇 개가 생겼을 까요?

```js
function foo() {
  function bar() {}

  function baz() {}
}

foo();
```

이 코드의 closure는 몇 개일까요?
foo 1개, bar 1개, baz 1개
총 3개 입니당!!

```js
function foo() {
  function bar() {}

  function baz() {}
}

foo();
foo();
```

이거는 몇개일까요

foo 한개 bar, baz 각각 2개 = 5개입니다.

---

```js
function getCounter() {
  var result = {
    count,
    total: 0,
  };
  function count() {
    result.total += 1;
  }

  return result;
}

var counterA = getCounter();
counterA.count();
counterA.count();

var counterB = getCounter();
counterB.count();

console.log(counterA.total, counterB.total);
```

```
2 1
```

직관적으로는 쉽습니다.

하지만 Closure의 관점으로 보면?

counterA, counterB는 각각의 Closure이기 때문에

- counterA: 첫 getCounter 실행 때 만들어진 total과 count로 이루어진 객체
- counterB: 첫 getCounter 실행 때 만들어진 total과 count로 이루어진 객체

입니다.

## **Closure** 는 함수와 변수들의 합입니다.

## 또한 **Closure**는 함수가 선언 될때마다 새로 생긴다.
