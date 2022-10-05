# node.green [node.green](https://node.green/)

## 업데이트별 node의 환경을 볼수있는 곳입니다. 한번 보고 오세요

---

## 기본적인 변수의 차이를 더알아 봅시다.

## let과 const의 차이는?

**let**과 **const**는 ES2015(ES6)에 추가된 **변수 선언** 키워드입니다.

**hoisting** 규칙이 없고, **block scoping**을 지원합니다.

따라서 var보다 훨씬 예측 가능한 코드를 짤수 있다.

---

var와는 달리 let과 const는 같은 스코프 내에서 같은 변수를 두 번 이상 정의 할 수 없습니다.

```js
var x = 1;
var x = 2;

console.log(x);
```

```
2
```

와

```js
let y = 1;
let y = 2;

console.log(y);
```

```
SyntaxError: Identifier 'y' has already been declared
```

---

또한 var와 달리 **let**과 **const**는 변수를 정의하기 전에는 사용할 수 없습니다.

```js
console.log(x);
const x = 3;
```

```
console.log(x);
            ^

ReferenceError: Cannot access 'x' before initialization
```

---

참고: **let**과 **const** 모두 같은 scoping rule을 따릅니다.

```js
var x = 1;
{
  var x = 2;
  console.log(x);
}
console.log(x);
```

```
2
2
```

와

**let**과 **const** 모두 같은 **block scoping**을 따릅니다.

```js
let x = 1;
const y = 1;
{
  let x = 2;
  const y = 2;
  console.log(x);
  console.log(y);
}
console.log(x);
console.log(y);
```

```
x: 2
y: 2
x: 1
y: 1
```

---

- **let**과 **const의** 예측가능성과 유지보수성이 **var보다** 훨씬 좋다.
- 가능하다면 **const만** 쓰고, 필요한경우에 한해 **let을** 쓰고. **var는** 비추한다.
