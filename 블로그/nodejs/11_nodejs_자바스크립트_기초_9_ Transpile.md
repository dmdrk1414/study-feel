# Transpile 이란?

Transpile은 코들르 A 언어에서 B언어로 변환하는 작업을 뜻합니다.

보통 신규 언어 스펙에서 구형 언어 스펙으로 Transpile 할때 사용

보통 Babel, tsc(TypeScript Compiler), ESBuild 등이 있습니다.

---

Transpile을 설치하기 전에

가장 많이 거론되는 것은 optional chaining 입니다.

일단 기본적인 형으론

```js
// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

const obj = {
  foo: {
    bar: 1,
  },
};

console.log(obj.foo.bar);
```

```
1
```

객체 obj 안에 객체 foo 안에 bar의 값은 1 입니다.

다음

```js
const objs = [
  {
    foo: {
      bar: 1,
    },
  },
  {},
  {
    foo: {},
  },
];

console.log(obj.map((obj) => obj.foo.bar));
```

```
console.log(obj.map((obj) => obj.foo.bar));
                                     ^

TypeError: Cannot read property 'bar' of undefined
```

바로 오류가 떠버리네요 왜냐하면

비어있는 객체에서 undefind을 내보냅니다.

한번 foo 안에 있는 bar에 접근을 해봅시다.

```js
const objs = [
  {
    foo: {
      bar: 1,
    },
  },
  {},
  {
    foo: {},
  },
];

const objValue = obj.map((obj) => {
  const { foo } = obj;
  if (foo) {
    return foo.bar;
  }
  return undefined;
});
console.log("~ objValue", objValue);
```

```
~ objValue [ 1, undefined, undefined ]
```

이렇게 하면 foo안에 있는 bar에 접근이 되고

만약 foo가 없으면 || bar가 없으면 undefined 가 return된다.

저가 생각하기에 이 안에있는 배열과 객체들이 복잡하다면 저는 못합니다.(포기)

---

그래서

## optional chaining 이 있습니다.

```js
const objs = [
  {
    foo: {
      bar: {
        baz: 2,
      },
    },
  },
  {},
  {
    foo: {},
  },
];

console.log(objs.map((obj) => obj.foo?.bar?.baz));
```

```
[ 2, undefined, undefined ]
```

## obj.foo?.bar?.baz

이걸로 저 복잡한게 끝난다고?

저는 항상 우리 선배님들에게 항상 감사합나디.

? 있으면 내려가고 없으면 undefined로 return한다.

---

polyfill은 함수를 추가하는 것이고

Transpile 은 문법을 추가하는 것입니다.

그럼이제 Transpile 에관한 라이브 러리를 다운받아 봅시다.

```
npm install esbuild
```

---

다운을 받은 후에
나는 package.json 파일의 script에 build을 추가합시다.

```
"build": "esbuild src/main.js --bundle --outfile=build/main.js --target=node14.15.1"
```

이것을

```
"scripts": {
    "debug": "node src/main.js",
    "build": "esbuild src/main.js --bundle --outfile=build/main.js --target=node14.15.1"
  },
```

이런식으로 적어주세요

그리고 run dev을하면

폴더: build 에 main.js라는 파일이 생길것입니다.

---

build/main.js

```js
(() => {
  // src/main.js
  var objs = [
    {
      foo: {
        bar: {
          baz: 2,
        },
      },
    },
    {},
    {
      foo: {},
    },
  ];
  console.log(
    objs.map((obj) => {
      var _a, _b;
      return (_b = (_a = obj.foo) == null ? void 0 : _a.bar) == null
        ? void 0
        : _b.baz;
    })
  );
})();
```

src/main

```js
const objs = [
  {
    foo: {
      bar: {
        baz: 2,
      },
    },
  },
  {},
  {
    foo: {},
  },
];
console.log(objs.map((obj) => obj.foo?.bar?.baz));
```

2개의 파일을 비교하시면 차이가 보일꺼에용

이런식으로 코드를 Transpile을하여 옛날코드를 읽을수 있답니다.
