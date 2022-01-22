<div style="font-size: 20">

## 저는 오늘 Promise을 이용해서 OMDB API를 처리하고 싶은데요<br>각설하고 코드보시게용

axios을 이용해서OMDB API의 정보를 얻어 올것입니다.

```js
import axios from "axios";

function fetchMovies(title) {
  const OMDB_API_KEY = "7035c60c";
  return new Promise(async (resolve, reject) => {
    const res = await axios.get(
      `https://www.omdbapi.com/?apikey=${OMDB_API_KEY}&s=${title}`
    );
    console.log(res);
  });
}

function test() {
  fetchMovies("frozen");
}

test();
```

```
regeneratorRuntime is not defined
```

????

regeneratorRuntime is not defined 오류가 뜨네요 이게뭘까요 인터넷에 쳐보니 babel을 설치하라는뎅

일단 설치해볼게요 babel이 무엇인지 공부해서 오겟습니다. (얖은 상식으론 최근js코드로 봐궈주는 걸로 알고있습니다.)

```
npm install --save-dev babel-polyfill //설치
```

import "regenerator-runtime";
임포트를 한 후

결과

```
{data: {…}, status: 200, statusText: '', headers: {…}, config: {…}, …}
```

---

데이터를 받앗습니다.

이후resolve라는 매개 변수를 호출한후

resolve(res); 응받을 받은 res을 반환한다.

```js
import axios from "axios";
import "regenerator-runtime";

function fetchMovies(title) {
  const OMDB_API_KEY = "7035c60c";
  return new Promise(async (resolve, reject) => {
    const res = await axios.get(
      `https://www.omdbapi.com/?apikey=${OMDB_API_KEY}&s=${title}`
    );
    resolve(res);
  });
}

function test() {
  const res = fetchMovies("frozen");
  console.log(res);
}

test();
```

```
Promise {<pending>}
[[Prototype]]: Promise
[[PromiseState]]: "fulfilled"
[[PromiseResult]]: Object
```

fetchMovies 함수에 있는 프로미스의 객체를

res의 변수로 받아서

resolve(res) 로 호출할시 데이터를 보낸다.

test함수의 res는 resolve(res) 가 반환된다 확인

결과

```
Promise {<pending>}
[[Prototype]]: Promise
[[PromiseState]]: "fulfilled"
[[PromiseResult]]: Object
config: {transitional: {…}, transformRequest: Array(1), transformResponse: Array(1), timeout: 0, adapter: ƒ, …}
data: {Search: Array(10), totalResults: '327', Response: 'True'}
headers: {cache-control: 'public, max-age=86400', content-type: 'application/json; charset=utf-8', expires: 'Fri, 14 Jan 2022 06:23:15 GMT', last-modified: 'Fri, 14 Jan 2022 05:23:15 GMT'}
request: XMLHttpRequest {onreadystatechange: null, readyState: 4, timeout: 0, withCredentials: false, upload: XMLHttpRequestUpload, …}
status: 200
statusText: ""
[[Prototype]]: Object
```

---

## 이정도 읽고 제가 이해가 안되면 다시 적었습니다 예제\_2

**then** 메소드는 해당 Promise 가 성공했을 때의 동작을 지정합니다. 인자로 함수를 받습니다.

**catch** 메소드는 해당 Promise 가 실패했을 때의 동작을 지정합니다. 인자로 함수를 받습니다.

위 함수들은 체인 형태로 활용할 수 있습니다. (연속적으로 호출할 수 있습니다. 아래 예제에서 확인하도록 합니다.)

```js
const promise1 = new Promise((resolve, reject) => {
  resolve();
});
promise1
  .then(() => {
    console.log("then!");
  })
  .catch(() => {
    console.log("catch!");
  });
```

```
then!
```

---

```js
const promise1 = new Promise((resolve, reject) => {
  reject();
});
promise1
  .then(() => {
    console.log("then!");
  })
  .catch(() => {
    console.log("catch!");
  });
```

```
catch!
```

---

함수에 promise1 을 리턴해보자

```js
function startAsync(age) {
  return new Promise((resolve, reject) => {
    if (age > 20) resolve();
    else reject();
  });
}

setTimeout(() => {
  const promise1 = startAsync(25);
  promise1
    .then(() => {
      console.log("1 then!");
    })
    .catch(() => {
      console.log("1 catch!");
    });
  const promise2 = startAsync(15);
  promise2
    .then(() => {
      console.log("2 then!");
    })
    .catch(() => {
      console.log("2 catch!");
    });
}, 1000);
```

---

### 우리는 resolve, reject 함수에 인자를 전달함으로써. then 및 catch 함수에서 비동기 작업으로부터 정보를 얻을 수 있습니다.

```js
function startAsync(age) {
  return new Promise((resolve, reject) => {
    if (age > 20) resolve(`${age} success`);
    else reject(new Error(`${age} is not over 20`));
  });
}

setTimeout(() => {
  const promise1 = startAsync(25);
  promise1
    .then((value) => {
      console.log(value);
    })
    .catch((error) => {
      console.error(error);
    });
  const promise2 = startAsync(15);
  promise2
    .then((value) => {
      console.log(value);
    })
    .catch((error) => {
      console.error(error);
    });
}, 1000);
```

```
25 success
Error: 15 is not over 20
```

---

# async await

저는 async await 를 위의 예제로 만들어 볼꺼예용

```js
function setTimeoutPromise(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(), ms);
  });
}

async function startAsync(age) {
  if (age > 20) return `${age} success`;
  else throw new Error(`${age} is not over 20`);
}

async function startAsyncJobs() {
  await setTimeoutPromise(1000);
  const promise1 = startAsync(25);
  try {
    const value = await promise1;
    console.log(value);
  } catch (e) {
    console.error(e);
  }
  const promise2 = startAsync(15);
  try {
    const value = await promise2;
    console.log(value);
  } catch (e) {
    console.error(e);
  }
}

startAsyncJobs();
```

결과 입니다.

```
25 success
Error: 15 is not over 20
    at startAsync (/home/taehoon/Desktop/playground-nodejs/index.js:17:14)
    at startAsyncJobs (/home/taehoon/Desktop/playground-nodejs/index.js:29:20)
```

```js
function setTimeoutPromise(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(), ms);
  });
}

async function fetchAge(id) {
  await setTimeoutPromise(500);
  console.log(`${id} 사원 데이터 받아오기 완료!`);
  return parseInt(Math.random() * 20, 10) + 25;
}

async function startAsyncJobs() {
  let ages = [];
  for (let i = 0; i < 5; i++) {
    let age = await fetchAge(i);
    ages.push(age);
  }

  console.log(
    `평균 나이는? ==> ${
      ages.reduce((prev, current) => prev + current, 0) / ages.length
    }`
  );
}

startAsyncJobs();
```

```
0 사원 데이터 받아오기 완료!
1 사원 데이터 받아오기 완료!
2 사원 데이터 받아오기 완료!
3 사원 데이터 받아오기 완료!
4 사원 데이터 받아오기 완료!
5 사원 데이터 받아오기 완료!
6 사원 데이터 받아오기 완료!
7 사원 데이터 받아오기 완료!
8 사원 데이터 받아오기 완료!
9 사원 데이터 받아오기 완료!
평균 나이는? ==> 33.1
```

너무 오래 걸리지 않나요?

for 안에 await을 사용해서 for문을 돌릴때마다

await가 사용되는 것같습니다

## 윗 코드와 밑 코드를 한번 비교해보게요

```js
function setTimeoutPromise(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(), ms);
  });
}

async function fetchAge(id) {
  await setTimeoutPromise(500);
  console.log(`${id} 사원 데이터 받아오기 완료!`);
  return parseInt(Math.random() * 20, 10) + 25;
}

async function startAsyncJobs() {
  let promises = [];
  for (let i = 0; i < 10; i++) {
    promises.push(fetchAge(i));
  }

  let ages = await Promise.all(promises);

  console.log(
    `평균 나이는? ==> ${
      ages.reduce((prev, current) => prev + current, 0) / ages.length
    }`
  );
}

startAsyncJobs();
```

여기에는 Promise.all 이라는 개념이 나왔네요

이 함수는 인자로 Promise 의 배열을 받으며, 하나의 특별한 Promise 를 새로 생성합니다.

---

저도 지금 이해가 너무 안되서 ㅠ

여기 사이트에서 공부 하세용 자세한건..

[[link](https://elvanov.com/2597)](https://elvanov.com/2597)

</div>
