# nodejs 의 특징

1. js식 비동기 처리방식
2. Offloading - 저수준의 오래 걸리는 일은 node에게, 고수준의 로직은 메인 스레드에서
3. 저수준 처리의 개선 - C와 WebAssembly
   1. C는 node-gyp를 통해, WebAssembly는 node 12번전붜 제공
4. 방대한 오픈 소스 생태계 - npm

---

# 기본 setting을 하자!!!

# Linting을 알아볼께요

Linting은 좀더 잘지켰으면 좋은 것들을 혹여나 에러가 날수있는 부분을 나타냅니다. 우리들만의 강력한 규제라고 생각하시면 될꺼같습니다.
linting : ESLint

---

```
npm i --save-dev eslint
```

eslint 을 사용하실때 .eslintrc.js 파일을 생성하여 규제를 적을 수있습니다.

하지만 많은 규제들의 라이브러리가있는데요.

저는 airbnb 라이브러리를 사용할 것 입니다.

```
npm install --save-dev eslint-config-airbnb-base  eslint-plugin-import
```

터미널에서 설치를 하시고요

prettier을 사용하시면 자꾸 오류가 날수있어요 그럼 eslint에맞는

prettier을 설치해봅시다.

```
npm install --save-dev eslint-config-prettier
```

```js
// .eslintrc.js 파일에  이걸 넣어 줍시다.
module.exports = {
  extends: ["airbnb-base", "prettier"], // airbnb-base라이브러리 사용
};
```

---

console.log(); 을 사용할때마다 eslint가 규칙위반을 말하네요

```js
/* eslint-disable-next-line */
console.log("Hello, world!");

/* eslint-disable no-console */
//저는 console.log을 많이 사용하고싶어서 이렇게 할려고용
console.log("Hello, world!");
console.log("Hello, world!");
```

이렇게 하면 다음줄을 eslint가 잡지를 않습니다. 하지만 모든 규칙을 무시할수 있으니

```js
/* eslint-disable-next-line no-console */
console.log("Hello, world!");
```

이렇게 no-console 을 적어주면 console만 잡지 않아서 편하죠

---

# 다음 우리가 설치할 것은 node전용 eslint입니다.

```
npm i --save-dev eslint-plugin-node
```

설치한후

.eslintrc.js 파일에 plugin:node/recommended 을 넣어 봅시다.

```js
module.exports = {
  extends: ["airbnb-base", "plugin:node/recommended", "prettier"],
};
```

---
