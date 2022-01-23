참고 readFile

# Promise에 대해 자세히 예제를 봅시다.

이제 머리에서 쥐가 나네요...

하지만 내가 정한길 악으로 깡으로 버텨야죠ㅎㅎ.

---

# Promise 예제\_1

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

new Promise((resolve, reject) => {
  console.log("Inside promisej");
  resolve("Firest resolve");
}).then((value) => {
  console.log("Inside first then");
  console.log("~first value", value);
});
```

```
Inside promisej
Inside first then
~ value Firest resolve
```

이것을 보시면

console.log("Inside promisej");

console.log("Inside first then");

console.log("~first value", value);

이순서입니다.

## **value**

자세히 봐야될 부분은 **value** 값인데

**value값은** **promise에서** 의 **콜백함수의 인자인** **resolve입니다**.

**Promise는** **resolve의 인자값을** **return** 해준다!

---

이번에는 reject값을 확인할 것입니다.

# Promise 예제\_2

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

new Promise((resolve, reject) => {
  console.log("Inside promise");
  reject(new Error("First reject"));
  resolve("Firest resolve");
})
  .then((value) => {
    console.log("Inside first then");
    console.log("~first value", value);
  })
  .catch((error) => {
    console.log("error", error);
  });
```

```
Inside promisej
error Error: First reject
```

console.log("Inside promise");

reject(new Error("First reject"));

딱 여기까지 reject에서 => catch로 갔네요.

그럼 **resolve의 인자**는 **then의 인자의 값으로** **return 했습니다**

그럼 **reject의 인자는** **catch의 인자의 값으로** **return 한것이죠**

## 그럼 then 과 catch의 순서를 봐꿀까요?

# Promise 예제\_3

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

new Promise((resolve, reject) => {
  console.log("Inside promisej");
  reject(new Error("First reject"));
  resolve("Firest resolve");
})
  .catch((error) => {
    console.log("error", error);
  })
  .then((value) => {
    console.log("Inside first then");
    console.log("~first value", value);
  });
```

```
Inside promisej
error Error: First reject
    ...에러

Inside first then
~first value undefined
```

잘보시면 value 값은 undefinded입니다.

왜냐하면 resolve가 실행되진 않았거든용.

## 그러면 과연 resolve까지 정말 실행이 안되는가?

제가 알기론 js는 콜백함수가 다 비워질때 까지 콜백을 사용하는데

---

# Promise 예제\_4

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

new Promise((resolve, reject) => {
  console.log("Inside promisej");
  reject(new Error("First reject"));

  console.log("resolve 하기전");
  resolve("Firest resolve");
  console.log("resolve 하기후");
})
  .catch((error) => {
    console.log("error", error);
  })
  .then((value) => {
    console.log("Inside first then");
    console.log("~first value", value);
  });
```

```
Inside promisej
resolve 하기전
resolve 하기후
error Error: First reject

    ...에러

Inside first then
~first value undefined
```

resolve 하기전

resolve 하기후

## 끝까지 코드는 돌지만! Promise에서는 reject을 리턴하기로 결정을 해서 그렇습니다.

---

## Promise 예제\_5 이제 setTimeout을 이용해보자

이런 예제는 많이 보셨을 겁니다. 저도 많이 보았고요

```js
new Promise((resolve, reject) => {
  console.log("timeout 하기 전");
  setTimeout(() => {
    console.log("resolve 하기 전");
    resolve(Math.random());
    console.log("resolve 하기 후");
  }, 3000);
  console.log("timeout 바로 밑");
}).then((value) => {
  console.log("~ value", value);
});
```

```
timeout 하기 전
timeout 바로 밑
resolve 하기 전
resolve 하기 후
~ value 0.4089683729080624
```

바로 다음 예제를 봅시다.

---

## Promise 예제\_6 이제 setTimeout을 이용해보자 (좀더)

callback 을 많이 하면 콜백 지옥에 빠진다고 합니당...

제가 머리가 안좋은데 지옥이라니 허허..

```js
setTimeout(() => {
  const value = Math.random();
  console.log("첫번째 콜백의 value: ", value);

  setTimeout(() => {
    const value = Math.random();
    console.log("두번째 콜백의 value: ", value);

    setTimeout(() => {
      const value = Math.random();
      console.log("세번째 콜백의 value: ", value);

      setTimeout(() => {
        const value = Math.random();
        console.log("네번째 콜백의 value: ", value);
      }, 1000);
    }, 1000);
  }, 1000);
}, 1000);
```

```
첫번째 콜백의 value:  0.945304613155689
두번째 콜백의 value:  0.45186466577371776
세번째 콜백의 value:  0.2655185170794425
네번째 콜백의 value:  0.3454553374244287
```

이것들이 복잡한 함수라면? 상상을 못하겠네요

## 이코드를 좀더 편하게 할수있을까? 해서 나온게 Promise라고 합니당

```js
iMakeFuntion()
  .then((value) => {
    console.log("첫번째 then의 value: ", value);
    return iMakeFuntion();
  })
  .then((value) => {
    console.log("두번째 then의 value: ", value);
    return iMakeFuntion();
  })
  .then((value) => {
    console.log("세번째 then의 value: ", value);
    return iMakeFuntion();
  })
  .then((value) => {
    console.log("네번째 then의 value: ", value);
    return iMakeFuntion();
  });
```

```
첫번째 then의 value:  0.9927731554194077
두번째 then의 value:  0.469400739703691
세번째 then의 value:  0.9650530149250598
네번째 then의 value:  0.6236043053283775
```

먼가 편하지 않나요?

return한 값이 다음 than의 인자값이다.

return한 값이 다음 than의 value값이다.

저는 이걸로 Promise을 생각하고있어요

---

## Promise 예제\_7 이제 readFile을 이용해보자

파일읽기 readFile을 **Non-Promise** 스타일과 **Promise** 스타일로 만들겁니다.

```js
const fs = require("fs");
//           파일이름,    옵션,       콜백
fs.readFile(".gitignore", "utf-8", (error, value) => {
  console.log(value);
});
```

```
node_modules
```

.gitignore의 파일을 잘읽었네요

---

Promis 을 해봅시다. 예제를 하도 많이 쓰니 확실히 머릿속에 들어오네요.

```js
const fs = require("fs");

/**
 * @param {string} fileName
 */

function readFilePromise(fileName) {
  return new Promise((resolve, reject) => {
    fs.readFile(fileName, "utf-8", (error, value) => {
      if (error) {
        reject(error);
      }
      resolve(value);
    });
  });
}

readFilePromise(".gitignore").then((value) => {
  console.log(value);
});
```

```
node_modules
```

## 이렇게 Promise의 예제를 보고

---

## 저는 항상 Promise을 보면 async await가 생각이 납니다.

한번 보게요

---

## Promise 예제\_8 이제 async function 을 이용해보자

async function은 어떤일을 할수있을까?

async function은 다른 async function안에서 기다려줄수 있다. ?? 참 모호하네요

이럴땐 코드를 복사해서 생각하시는게 편하죠

## 밑에 코드는 짬뽕입니다. promise의 예제와 async의 예제를 같이 실행할것입니다.

iMakeFuntion()과 sleep()의 함수가 같이 실행됩니다 보시죠

```js
function iMakeFuntion() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(Math.random());
    }, 1000);
  });
}

iMakeFuntion()
  .then((value) => {
    console.log("첫번째 then의 value: ", value);
    return iMakeFuntion();
  })
  .then((value) => {
    console.log("두번째 then의 value: ", value);
    return iMakeFuntion();
  })
  .then((value) => {
    console.log("세번째 then의 value: ", value);
    return iMakeFuntion();
  })
  .then((value) => {
    console.log("네번째 then의 value: ", value);
    return iMakeFuntion();
  });

/**
 * @param {number} duration
 */

async function sleep(duration) {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(undefined);
    }, duration);
  });
}

async function main() {
  console.log("first");
  await sleep(1000);
  console.log("second");
  await sleep(1000);
  console.log("third");
  await sleep(1000);
  console.log("finish!!!");
}

main();
```

```
first
첫번째 then의 value:  0.6721425465651856
second
두번째 then의 value:  0.80274069432717
third
세번째 then의 value:  0.9256154957200897
finish!!!
네번째 then의 value:  0.73408801601983
```

두개의 함수가 1초 단위로 실행이 되는데

iMakeFuntion() 안에 sleep() 함수를 넣어볼까?

저는 시간차이를 위해 iMakeFuntion()을 2초마다

sleep()을 1초마다 실행하겠습니다 같이 달리기를 시키면 sleep가 빨리 끝나겠죠?

```
first // 위내용되로 2초와 1초 차이를 줌
second
첫번째 then의 value:  0.6673616002344345
third
finish!!!
두번째 then의 value:  0.9998197793473762
세번째 then의 value:  0.4980908831035802
네번째 then의 value:  0.24532565415435248
```

---

## async function은 다른 async function안에서 기다려줄수 있다.

```js
async function sleep(duration) {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log("sleep함수가 실행");
      resolve(undefined);
    }, duration);
  });
}

function iMakeFuntion() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(Math.random());
    }, 2000);
  });
}

iMakeFuntion()
  .then(async (value) => {
    console.log("첫번째 then의 value: ", value);
    await sleep(1000); // sleep 추가
    return iMakeFuntion();
  })
  .then(async (value) => {
    console.log("두번째 then의 value: ", value);
    await sleep(1000); // sleep 추가
    return iMakeFuntion();
  })
  .then(async (value) => {
    console.log("세번째 then의 value: ", value);
    await sleep(1000); // sleep 추가
    return iMakeFuntion();
  })
  .then(async (value) => {
    console.log("네번째 then의 value: ", value);
    await sleep(1000); // sleep 추가
    return iMakeFuntion();
  });
```

```
첫번째 then의 value:  0.8262478926597039
sleep함수가 실행
두번째 then의 value:  0.00970582582087598
sleep함수가 실행
세번째 then의 value:  0.16339873903229507
sleep함수가 실행
네번째 then의 value:  0.5930357857019992
sleep함수가 실행
```

우리 좀더 힘내봐요

## Promise 예제\_9 이제 async function 을 이용해보자

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */
async function sleep(duration) {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log("sleep함수가 실행");
      resolve(undefined);
    }, duration);
  });
}

async function main() {
  console.log("first");
  await sleep(1000);
  console.log("second");
  await sleep(1000);
  console.log("third");
  await sleep(1000);
  console.log("finish");
}

main();
```

```
first
sleep함수가 실행
second
sleep함수가 실행
third
sleep함수가 실행
finish
```

## async function은 다른 async function안에서 기다려줄수 있다.

이말을 곱씹어보면서 코드를 보니 저도 머릿속에 박히네요 휴...

그럼 우리 이코드를 Promise의 then으로 한번?

go? go 오케이

---

```js
function sleep(duration) {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("sleep함수가 실행");
    }, duration);
  });
}

sleep()
  .then((value) => {
    console.log("first");
    console.log(value);
    return sleep(1000);
  })
  .then((value) => {
    console.log("second");
    console.log(value);
    return sleep(1000);
  })
  .then((value) => {
    console.log("third");
    console.log(value);
    return sleep(1000);
  })
  .then((value) => {
    console.log("finish");
    console.log(value);
  });
```

```
first
sleep함수가 실행
second
sleep함수가 실행
third
sleep함수가 실행
finish
sleep함수가 실행
```

---

## await 함수는 먼가 짤막한데 Promise는 길죠?

그래서 할수있으면 await로 하는 것이 좋다고 합니다.

---

```js
const fs = require("fs");

async function main() {
  const result = await fs.promises.readFile(".gitignore", "utf-8");
  console.log(result);
}

main();
```

```
node_modules
```

이것또한 async await
