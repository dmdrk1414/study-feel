1_polyfill 이란?

JS standard libraty에 표준으로 등록되어 있으나?

아직 브라우저나 Node.js에서 구현되지 않은 기능을 미리

사용할수록 만들어진 구현체를 뜻합니다

ex) core.js등이 예시입니다.

특별한 이유로 node.js의 버전을 고정해야한다면

그렇다면 나중에 업데이트되는 높은 버전들의 함수들을 사용하고 싶으면?

core.js을 import을 하여 node.js에 적용을할수 있습니다.

---

한번 core.js을 사용해봅시다.

```
npm install core-js
```

---

---

## 하기전에 node버전을 10.24.1로 봐꿔주세요 왜냐하면 core-js는 없는 함수가 있는 node버전에서 확인하는게 효율적이니.

nvm이있으면

```
nvm list
nvm i 10.24.1 // 10.24.1 이 없으면
nvm use 10.24.1 // 설치한후
```

---

---

그리고 js파일에 require 을한후

```js
require("core-js");
```

---

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

// require("core-js");   //core.js을 임포트 하기전

const complicatedArray = [1, [2, 3]];
const flattendArray = complicatedArray.flat();
console.log("~ flattendArray", flattendArray);
```

역시 오류가 나오네요

```
TypeError: complicatedArray.flat is not a function
```

# 하지만 core.js을 임포트한후

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

require("core-js");

const complicatedArray = [1, [2, 3]];
const flattendArray = complicatedArray.flat();
console.log("~ flattendArray", flattendArray);
```

```
~ flattendArray [ 1, 2, 3 ]
```

좋네요 참 감사하겠어요

---

## 1_core.js을 사용하는 예제\_1 replaceAll

replaceAll 을 사용해 봅시다

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

// require("core-js");

const original = "abcabc123";
const changed = original.replaceAll("abc", "123");
console.log("~ changed", changed);
```

```
TypeError: original.replaceAll is not a function
```

require("core-js"); 을 임포트를 하면?

```
~ changed 123123123
```

입니다.

---

## 1_core.js을 사용하는 예제\_2 Promiss.all Vs Promiss.allSettled

Promiss.all은 Promiss가 끝났는지 알려주는 함수입니다.

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

/**
 *
 * @param {number} duration
 * @returns
 */

function sleep(duration) {
  return new Promise((resolve) => {
    console.log("sleep start");
    setTimeout(() => {
      console.log("sleep done ", duration);
      resolve(null);
    }, duration);
  });
}

Promise.all([sleep(1000), sleep(3000), sleep(2000)]).then(() => {
  console.log("Promise.all 끝났어!!");
});
```

```
sleep start
sleep start
sleep start
sleep done  1000
sleep done  2000
sleep done  3000
Promise.all 끝났어!!
```

Promise 가끝난후 나오는 모습입니다.

---

여기에 reject을 하면 어떻게 될까요?

```js
/**
 *
 * @param {number} duration
 * @returns
 */

function sleep(duration) {
  return new Promise((resolve) => {
    console.log("sleep start");
    setTimeout(() => {
      console.log("sleep done ", duration);
      resolve(null);
    }, duration);
  });
}

function makeReject() {
  return new Promise((resolve, rejeckt) => {
    rejeckt();
  });
}

Promise.all([sleep(1000), sleep(3000), sleep(2000), makeReject()]).then(() => {
  console.log("Promise.all 끝났어!!");
});
```

```
sleep start
sleep start
sleep start
(node:5431) UnhandledPromiseRejectionWarning: undefined  // 오류
(node:5431) UnhandledPromiseRejectionWarning: js process with a non-zero exit code.
sleep done  1000
sleep done  2000
sleep done  3000
```

오류가 출력이되면서, Promis.all이 출력이 안되네요

---

그럼 Promise.all().then

```js
function sleep(duration) {
  return new Promise((resolve) => {
    console.log("sleep start");
    setTimeout(() => {
      console.log("sleep done ", duration);
      resolve(duration);
    }, duration);
  });
}

function makeReject() {
  return new Promise((resolve, rejeckt) => {
    rejeckt();
  });
}

Promise.all([sleep(1000), sleep(3000), sleep(2000)]).then((value) => {
  console.log("Promise.all 끝났어!!", value);
});
```

```
sleep start
sleep start
sleep start
sleep done  1000
sleep done  1500
sleep done  2000
Promise.all 끝났어!! [ { status: 'fulfilled', value: 1000 },
  { status: 'fulfilled', value: 1500 },
  { status: 'fulfilled', value: 2000 },
  { status: 'rejected', reason: undefined } ]
```

## Promise.allSettled

Promise.allSettled 은 **Promise.all** 과 달리

rejeckt의 오류가 나도 출력을 해주는 것같네요.

Promise.all 은 거기서 멈춰버리는데

사실 이게 왜 중요한지는 잘 모르겠습니다.
