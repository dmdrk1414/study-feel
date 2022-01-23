# 토이 프로젝트를 만들기

코드를 보시죠

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

// 프레임워크 없이 간단한 토이프로젝트 웹 서버 만들어보기

/**
 * 블로그 포스팅 서비스
 * - 로컬 파일을 데이터베이스로 환용할 예정 (JSON)
 * - 인증 로직은 넣지 않는다. (유저에 의심하지 않는다)
 * - RESTful API을 사용한다. test와 사람이 보기 편하다
 */

const http = require("http"); // 노드 모듈을 가져온다

const PORT = 4000; // 사용할 서버 포트

// 요청이 오면 실행되는 콜백 함수
const server = http.createServer((req, res) => {
  res.statusCode = 200; // 응답 상태값 설정
  res.end("Hello!"); // 응답 데이터 전송
});

// 서버를 요청 대기 상태로 만든다
server.listen(PORT, () => {
  // 요청 대기가 완료되면 실행되는 콜백 함수
  // 터미널에 로그를 기록한다
  console.log(`The server is listening at port: ${PORT}`);
});
```

http.createServer(): 서버 인스턴스를 만들어 반환
http.server: 서버 클래스
server.listen(): 서버를 클라이언트 요청 대기 상태(listen)로 만듬

```
The server is listening at port: 4000
```

node 로실행을 하면 클라이언트의 요청을 대기한다.

요청을 기달린다 라고 생각합니다.

이코드를 테스트 하기위해 httpie을 다운받아서 테스트를 해봅시다!

```
sudo apt-get install httpie
```

을 설치하고

---

```
http localhost:4000
```

을 하면 떠야되는데

```
http: error: ConnectionError: HTTPConnectionPool(host='localhost', port=4000): Max retries exceeded with url: / (Caused by NewConnectionError('<urllib3.connection.HTTPConnection object at 0x7fa0f8becf28>: Failed to establish a new connection: [Errno 111] Connection refused',)) while doing GET request to URL: http://localhost:4000/
```

역시 한번에 되면 제가 아니죠

찾아보니 요청을 많이 해서 그런다네요? 하... 여기에 그럼

0.5초마다 요청을 하는 식으로 try catch, setInterval, callback을 이용해봅시다

```js
const http = require("http"); // 노드 모듈을 가져온다

const PORT = 4000; // 사용할 서버 포트

function sleep(duration, callback) {
  setInterval(() => {
    callback();
  }, duration);
}

// 요청이 오면 실행되는 콜백 함수
const server = http.createServer((req, res) => {
  res.statusCode = 200; // 응답 상태값 설정
  res.end("Hello!"); // 응답 데이터 전송
});

// 서버를 요청 대기 상태로 만든다
try {
  server.listen(PORT, () => {
    // 요청 대기가 완료되면 실행되는 콜백 함수
    // 터미널에 로그를 기록한다
    console.log(`The server is listening at port: ${PORT}`);
  });
} catch (error) {
  sleep(
    500,
    server.listen(PORT, () => {
      console.log(`The server is listening at port: ${PORT}`);
    })
  );
}
```

```
 localhost:4000
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 6
Date: Sat, 22 Jan 2022 05:41:57 GMT
Keep-Alive: timeout=5

Hello!
```

역시 사람이 그냥 죽으라는 법은 없네요 콜백을 배운김에 사용했는데

되버리다니 이느낌에 프로그램하죠 하하(으쓱으쓱)

---

저는 이제 여기에서 시작할꺼고용

작은 블로그를 만들 생각이고요

Post = 글쓰기
GET /posts = 전체 글을 보는법

GET /posts:id = 특정 글을 보는법
(해당 id)

POST /posts = 글을 올리기

---

```js
const server = http.createServer((req, res) => {
  console.log(req.url);

  res.statusCode = 200; // 응답 상태값 설정
  res.end("Hello!"); // 응답 데이터 전송
});
```

저는 여기 안에 req.url을 찍어 보겠습니다.

req 요청하다
url url을

요청하는 방법은

```
http localhost:4000/요기에url입니다
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 6
Date: Sat, 22 Jan 2022 06:12:21 GMT
Keep-Alive: timeout=5

Hello!
```

```
/%EC%9A%94%EA%B8%B0%EC%97%90url%EC%9E%85%EB%8B%88%EB%8B%A4
```

이런식으로 요청이 가는 것을 볼수있네요.

그런데 너무 귀찮아요 고칠때마다 다시 실행하고

그래서 nodemon 노드몬이라는 패키지을 다운받죠

---

```
npm i --savs-dev nodemon
```

그럼이제 package.json에 script에 추가를 합시다

```
"scripts": {
    "debug": "node src/main.js",
    "build": "esbuild src/main.js --bundle --outfile=build/main.js --target=node14.15.1",
    "server": "nodemon src/main.js"
  },
```

하지만 되지않는 점....

이런 찾아보니 윈도우는 안되는점.... 이런 맥살걸

그래도 한번 해봐야죠

그냥 리눅스로 옮겼습니다 이번기회에

로 해보세요 윈도우는 안되네요

---
