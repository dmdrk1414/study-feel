asunc / await? 공부하자.

```js
import "regenerator-runtime";

function delayP(sec) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

function myFunc() {
  return "func";
}

async function myAsync() {
  return "async";
}

console.log(myFunc());
console.log(myAsync());
console.log(delayP());
```

```
func
Promise {<fulfilled>: 'func'}
Promise {<fulfilled>: 'func'}
```

이건 무슨 말인가 해석을 하면 async인 함수 myAsync()는 Promise와 같다!!.

그러면 then을 사용할수 있다는 것이다.

```js
import "regenerator-runtime";

function delayP(sec) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

function myFunc() {
  return "func";
}

async function myAsync() {
  // promise을 리턴하는 애
  return "async";
}

console.log(myAsync()); // promise을 리턴한다 -> then 을 사용할수있다.

// result 값은 리턴값이다 (muAsunc() 함수의)
myAsync().then((result) => {
  console.log(result);
});
//async에의 해 리턴되는 값은  myAsync().then 에의해서 등록된 함수의 인자로 넘어간다.
```

```
Promise {<fulfilled>: 'func'}
func
```

결과를 해석하면?

myAsync() : 는 Promise로 가능하며

myAsync().then() 안의 함수의 인수는.

async 함수 myAsync() 의 리턴 값이다.

---

```js
import "regenerator-runtime";

function delayP(sec) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

function myFunc() {
  return "func";
}

async function myAsync() {
  // promise을 리턴하는 애
  delayP(3).then((time) => {
    console.log(time);
  });
  return "async";
}

// result 값은 리턴값이다 (muAsunc() 함수의)
myAsync().then((result) => {
  console.log(result);
});
//async에의 해 리턴되는 값은  myAsync().then 에의해서 등록된 함수의 인자로 넘어간다.
```

```
async
2022-01-16T03:46:33.541Z
```

async가 찍히고 3초후에 날짜가 나옵니다.

---

하지만 저는 3호후에 날짜와 async라는 리턴값을 얻고 싶습니다.

```js
import "regenerator-runtime";

function delayP(sec) {
  return new Promise(async (resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

async function myAsync() {
  // 여기서 time은  프라미스의 객체의 resolve입니다.

  await delayP(3).then((time) => {
    // delayP가 완료될때 까지 다음턴으로 안넘어간다.
    console.log(time);
  });
  // promise을 리턴하는 애
  return "async";
}

// result 값은 리턴값이다 (muAsunc() 함수의)
myAsync().then((result) => {
  console.log(result);
});
//async에의 해 리턴되는 값은  myAsync().then 에의해서 등록된 함수의 인자로 넘어간다.
```

```
2022-01-16T03:55:51.540Z
async
```

이렇듯이 Promise의 resolve을 나중에 하는 것입니다.

---

```js
import "regenerator-runtime";

function delayP(sec) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

async function myAsync() {
  // 이런식으로 변수에 저장을 할수있다.
  const time = await delayP(3);
  console.log(time);
  // await delayP(3).then((time) => {
  //   console.log(time);
  // });
  return "async";
}

myAsync().then((result) => {
  console.log(result);
});
```

이런식으로 변수에 저장을 할수있다.

const time = await delayP(3);

console.log(time);

---

이예제도 따라해 보게용

```js
import "regenerator-runtime";

function delayP(sec) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

async function myAsync() {
  // 이런식으로 변수에 저장을 할수있다.
  const result = await delayP(1).then((time) => {
    return "x";
  });
  console.log(result);
  return "async myAsync().then((result)";
}

myAsync().then((result) => {
  console.log(result);
});
```

```
x
async myAsync().then((result)
```

---

# Promise의 객체의 resolve는 then 콜백함수의 인수로

# async의 return 값은 then 콜백함수의 인수

저의 지금까지 공부한 결과입니다.

Promise와 async는 둘다 프라미스의 객체를 생성하는데

쓰는 방법이 다른것 같습니다.

위의 글을 읽고

```js
import "regenerator-runtime";

function delayP(sec) 1{
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(new Date().toISOString());
    }, sec * 1000);
  });
}

function normalFun() {
  return "wow";
}

async function myAsync() {
  // 이런식으로 변수에 저장을 할수있다.
  const result = await delayP(1).then((time) => {
    console.log(time);
    return "x";
  });
  console.log(result);
  return "async myAsync().then((result)";
}

myAsync().then((result) => {
  console.log(result);
});
```

```
2022-01-16T04:20:07.549Z
x
async myAsync().then((result)
```
