## nodejs 의 특징

1. js식 비동기 처리방식
2. Offloading - 저수준의 오래 걸리는 일은 node에게, 고수준의 로직은 메인 스레드에서
3. 저수준 처리의 개선 - C와 WebAssembly
   1. C는 node-gyp를 통해, WebAssembly는 node 12번전붜 제공
4. 방대한 오픈 소스 생태계 - npm

---

사용하기전

## Linting을 알아볼께요

Linting은 좀더 잘지켰으면 좋은 것들을 혹여나 에러가 날수있는 부분을 나타냅니다.

---
linting : ESLint

```
npm i --save-dev eslint
```
eslint을 설치하고요

