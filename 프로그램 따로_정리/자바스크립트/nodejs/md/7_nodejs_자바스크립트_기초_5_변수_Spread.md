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

---

# **Spread** 방식이라고 아십니까?

js공부할때 봤는데 저도 많이 까먹는 것같아요.

흩뿌리는 것입니다.

```js
const personalData = {
  nickname: "dmdrk1414",
  email: "dmdrk1414@gmail.com",
};

const publicData = {
  age: 22,
};

const user = {
  ...personalData,
  ...publicData,
};

console.log(user);
```

```
{ nickname: 'dmdrk1414', email: 'dmdrk1414@gmail.com', age: 22 }
```

객체와 배열을 Spread을 한다!

---

또한 기존의 데이터를 덮어쓰는 것이 가능합니다.

---

## Spread예제\_1 Object_1

```js
const overrides = {
  DATABASE_HOST: "dmdrk1414.com",
  DATABASE_PASSWORD: "mypassword",
};

const config = {
  DATABASE_HOST: "내가 결정한.호스트.com",
  DATABASE_PASSWORD: "비밀번호!",
  DATABASE_USERNAME: "응가1414",
  ...overrides,
};

console.log(config);
```

### 이것은 덮어쓰기전

```
{
  DATABASE_HOST: '내가 결정한.호스트.com',
  DATABASE_PASSWORD: '비밀번호!',
  DATABASE_USERNAME: '응가1414'
}
```

## 이것은 덮어쓴후

```
{
  DATABASE_HOST: 'dmdrk1414.com',
  DATABASE_PASSWORD: 'mypassword',
  DATABASE_USERNAME: '응가1414'
}
```

---

## Spread예제\_2 Object_2

오버 라이딩 예시와 오버라이딩의 같은 결과 다른 예제를 봅시다.

```js
const personalData = {
  email: " asdf@sdf.com",
  password: "****",
};

const publicData = {
  nickname: "내가 만든 닉네임",
};

const overrides = {
  email: "fff@fff.com",
};

const user = {
  ...overrides,
  ...personalData,
  ...publicData,
};

console.log(user);
```

```
{ email: ' asdf@sdf.com', password: '****', nickname: '내가 만든 닉네임' }

```

이제 같은 결과에 다른 예제

```js
const user = {
  ...{
    email: "fff@fff.com",
  },
  ...{
    email: " asdf@sdf.com",
    password: "****",
  },
  ...{
    nickname: "내가 만든 닉네임",
  },
};

console.log(user);
```

```
{ email: ' asdf@sdf.com', password: '****', nickname: '내가 만든 닉네임' }
```

## Spread예제를 보면서 느끼는게 참 많네요 ㅎㅎ

하지만 이런 예제를 보면서 이걸 왜하는가? 라는 생각이 들었는데요

## Spread예제\_3 Object_3 삼항 연산자와 합치기

삼항 연산자를 이용해서 더많은 예제를 만들수있습니다.

```js
const shouldOverride = false;

const user = {
  ...{
    email: "fff@fff.com",
  },
  ...{
    email: " asdf@sdf.com",
    password: "****",
  },
  ...(shouldOverride
    ? {
        nickname: "내가 만든 닉네임",
      }
    : null),
};

console.log(user);
```

shouldOverride 가 false일때

```
{ email: ' asdf@sdf.com', password: '****' }
```

shouldOverride 가 true일때

```
{ email: ' asdf@sdf.com', password: '****', nickname: '내가 만든 닉네임' }
```

정말 머리아프네요

---

## Spread예제\_4 Object_4

객체를 얖은복사 가능

```js
const user = {
  nickname: "dmdrk1414",
  age: 59,
  email: "dmdrk1414@gmail.com",
};

const { nickname, ...personalData } = user;
console.log(personalData);
```

```
{ age: 59, email: 'dmdrk1414@gmail.com' }
```

---

---

## Spread예제\_5 배열\_1

### 배열의 얖은 복사

```js
const pets = ["dog", "cat"];
const predators = ["wolf", "cougar"];
const animals = [...pets, ...predators];

console.log(animals);
```

```
[ 'dog', 'cat', 'wolf', 'cougar' ]
```

---

## Spread예제\_6 배열\_2 array rest

```js
const [head, ...rest] = [1, 2, 3];
console.log(head);
console.log(rest);
```

```
1
[ 2, 3 ]
```

같은 예제로

```js
const ary = [1, 2, 3, 4, 5];

const [head, ...rest] = ary;

console.log(head, rest); //1 [ 2, 3, 4, 5 ]
console.log(head, ...rest); //1 [ 2, 3, 4, 5 ]
```

```
1 [ 2, 3, 4, 5 ]
1 2 3 4 5
```

---

---

# 마지막 예제!! 함수에 담기

```js
function foo(head, ...rest) {
  console.log(head);
  console.log(rest);
}

foo(1, 2, 3, 4);
```

```
1
[ 2, 3, 4 ]
```

이런식으로 함수에 담아서 사용을 한다? 대단하네요 ㅎㅎ

---

이런식으로 rest 나머지를 배열처리 해버립니다.

## console.log(head, ...rest);

이것도 보시면 콘솔로그에 5개의 인자를 뿌리죠 차이를 잘알 봅시당
