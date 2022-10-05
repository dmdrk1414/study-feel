# Typescript 을 이용해 type제어 하기

## 타입스크립은 라이브러리입니다. 일단 Typescript을 설치 하자

```
 npm i --save-dev typescript
```

typescript을 설치한후

```js
// @ts-check                               // 여기에 @ts-check사용
// Formattingm Linting
// Formatting: Prettier
// Linting: EsLint

/* eslint-disable no-console */

const someString = "Hello";
const result = Math.log(someString);
console.log(result);
```

에 오류가 뜨는데 보시면

'string' 형식의 인수는 'number' 형식의 매개 변수에 할당될 수 없습니다.ts(2345)
좋네요 이제 저희는 타입에 대해 좀더 신경을 안써도 되겠네요.

---

## node 환경에서 사용할수있는 typescript을 설치하자

```
npm i --save-dev @types/node
```

이 패키지의 정보는 노드에서 주로 사용되는 객체들에 대한 타입 정보들이

들어있습니다.

```js
// @ts-check
// Formattingm Linting
// Formatting: Prettier
// Linting: EsLint
// Type checking: TypeScript

/* eslint-disable no-console */

const http = require("http");

const server = http.createServer((req, res) => {
  res.statusCode = "200";
  res.end("HELLOW!!!");
});

const PORT = 4000;

server.listen(PORT, () => {
  console.log(`The server is listening at port: ${PORT}`);
});
```

만약 이코드을 넣으시면 오류가 발생할것입니다.

---

---

또한 Typescript을 사용하는 방법중

환경 설정이라는 것이 있는데용

jsconfig.json 파일을 설치해보자

```js
// jsconfig.json 파일 에
{
    "compilerOptions": {
        "strict": true  // 상당히 엄격하게 검사해줘 깐깐하게 검사를 해줘
    },
    "include": [
        "src/**/*"
    ]
}
```

파일안에 내용을 채워 넣고 끝

---

사용하는 패키지

VSCode JavaScript Development Setup
| | Formatting | Linting | Type checking
---|---|---|---
Package | prettier | eslint | typescript
Additional<br>dependencies | | eslint-config-airbnb-base<br>eslint-config-prettier<br>eslint-plugin-import<br>eslint-plugin-node|@types/node
config file | prettierrc | .eslintrc.js | jsconfig.json
VSCode<br>extensions | 0 | 0 | X

---

---

[https://code.visualstudio.com/docs/languages/jsconfig](https://code.visualstudio.com/docs/languages/jsconfig)

---
