<div style="font-size: 24px">

제가 공부하고 있는 블로그는 여기입니다.!!!<br>
[https://heropy.blog/2018/10/28/regexp//](https://heropy.blog/2018/10/28/regexp/)<br>
정규표현식은 여기 사이트에서 연습하셔도 좋아요
[https://regexr.com/](https://regexr.com/)
<br>
<br>

## 정규 표현식이란?

1.문자 검색(search)<br> 2.문자 대체(replace)<br> 3.문자 추출(extract)<br>

이 편합니다 <br>
저도 잘사용을 못하는 데용 ㅜㅜ<br>
(그러니 공부를 하는 것 이겠죠?)<br>
<br>

</div>

---

## 정규 표현식의 방식은<br>

1. 생성자 함수 방식

   ````javascript
   const regexp1 = new RegExp("^abc");
   // new RegExg(표현식);
   const regexp2 = new RegExp("^abc", "gi");
   // new RegExg(표현식, 플레그);
     ```
   ````

2. 리터럴(Literal) 방식이 있습니다.
   ```javascript
   const regexp1 = /^abc/;
   // /표현식/
   const regexp2 = /^abc/gi;
   // /표현식/플래그
   ```

---

## 정규식 생성

```js
// 생성자
new RegExp("표현", "옵션");
new RegExp("[a-z]", "gi");
// 옵션 : g 모든 내용을 검색사겠다.
//        i 대문자 소문자를 구분하지 않겠다.

// 리터럴
/표현/옵션
/[a-z]/gi;
```

---

| 메소드   | 문법                            | 설명                                                            |
| -------- | ------------------------------- | --------------------------------------------------------------- |
| exec     | 정규식.exec(문자열)             | 일치하는 하나의 정보(Array) 반환                                |
| test     | 정규식.test(문자열)             | 일치 여부(Boolean) 반환                                         |
| match    | 문자열.match(정규식)            | 일치하는 문자열의 배열(Array) 반환                              |
| search   | 문자열.search(정규식)           | 일치하는 문자열의 인덱스(Number) 반환                           |
| replace  | 문자열.replace(정규식,대체문자) | 일치하는 문자열을 대체하고 대체된 문자열(String) 반환           |
| split    | 문자열.split(정규식)            | 일치하는 문자열을 분할하여 배열(Array)로 반환                   |
| toString | 생성자\_정규식.toString()       | 생성자 함수 방식의 정규식을 리터럴 방식의 문자열(String)로 반환 |

---

## 메소드 코드\_1

```js
const str = `
010-1234-5678
dmdrk1414@gmail.com
The quick brown fox jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd
`;

const regexp = /the/gi;
console.log(str.match(regexp));
`;
```

---

## 메소드 코드\_2

```js
const str = `
010-1234-5678
dmdrk1414@gmail.com 
The quick brown fox jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd
`;

const regexp = /the/gi;

console.log("exec 함수");
console.log(regexp.exec(str));

console.log("-----------------------------");

console.log("test 함수");
console.log(regexp.test(str));
console.log(str);

console.log("-----------------------------");

console.log("match 함수");
console.log(str.match(regexp));

console.log("-----------------------------");

console.log("search 함수");
console.log(str.search(regexp));

console.log("-----------------------------");

console.log("replace 함수");
console.log(str.replace(regexp, "fuck"));
console.log(str);

console.log("-----------------------------");

console.log("split 함수");
console.log(str.split(regexp));
```

---

## 플래그 옵션

| 플래그 | 설명                                                     |
| ------ | -------------------------------------------------------- |
| g      | 모든 문자와 여러 줄 일치(global) , 전체 확인             |
| i      | 영어 대소문자를 구분 않고 일치(insensitive, ignore case) |
| m      | 여러 줄 일치(multiline) 줄마다 해석을 하겠다.            |
| u      | 유니코드(unicode)                                        |
| y      | lastIndex 속성으로 지정된 인덱스에서만 1회 일치(sticky)  |

---

## 플래그 옵션 예시

```js
const str = `
010-1234-5678
the
dmdrk1414@gmail.com 
The quick brown fox jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd.
`;

// "."을 찾는다
console.log(str.match(/\./gi));

console.log("----------------");

// $ 은 문장 끝에 있는가?  => ` 뒤가 쪽이 나온다.
console.log(str.match(/\.$/gi));
console.log(str.match(/\.$/gim));
```

## 패턴(표현)

|   패턴    | 설명                                                          |
| :-------: | ------------------------------------------------------------- |
|  1\_ ^ab  | 줄 시작에 있는 ab와 일치                                      |
|    ab$    | 줄 끝에 있는 ab와 일치                                        |
|     .     | 임의의 한 문자와 일치 (어떠한 문자도 가능)                    |
|   a\|b    | a또는 b와 일치                                                |
|    ab?    | b가 없거나 b와 일치                                           |
|    {3}    | 3개 연속 일치                                                 |
|   {3,}    | 3개 이상 연속 일치                                            |
|   {3,5}   | 3개 이상 5개 이하 (3~5개) 연속 일치                           |
|    ---    | ----------------------------------------------------------    |
| 2\_ [abc] | a 또는 b 또는 c                                               |
|   [a-z]   | a부터 z 사이의 문자 구간에 일치(영어 소문자)                  |
|   [A-Z]   | A부터 Z 사이의 문자 구간에 일치(영어 대문자)                  |
|   [0-9]   | 0부터 9 사이의 문자 구간에 일치(숫자)                         |
|  [가-힣]  | 가부터 힣 사이의 문자 구간에 일치(한글))                      |
|    ---    | ------------------------------------------------------------- |
|    \w     | 63개 문자(Word, 대소영문 52개 + 숫자 10개 + \_)에 일치        |
|    \b     | 63개 문자에 일치하지 않는 문자 경계 (Boundary)                |
|    \d     | 숫자(Digit )에 일치                                           |
|    \s     | 공백(Space, Tap 등)에 일치                                    |
|    ---    | ---------------------------------------------------------     |
| 3\_ (?=)  | 앞쪽 일치(Lookahead)                                          |
|   (?<=)   | 뒤쪽 일치(Lookbehind)                                         |

---

<br>

## 패턴(표현) 예제\_1

```js
const str = `
010-1234-5678
the
https://www.dmdrk1414@gmail.com
The quick brown fox jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd
hxyp
http://localhost:1234
`;

console.log(str.match(/d$/gm));

console.log("----------------");

// ^ 은 문장 앞에 있는가?
console.log(str.match(/^t/gm));
console.log(str.match(/^t/gim));

console.log("----------------");

// .   임의의 한 문자와 일치
console.log(str.match(/./gm));
console.log(str.match(/h..p/gm));

console.log("----------------");

//  |   a 또는 b와 일치
console.log(str.match(/fox|dog/gm));
console.log(str.match(/fox|dog/));

console.log("----------------");

// ?    있거나 없거나
console.log(str.match(/http/gm));
console.log(str.match(/https?/gm));

console.log("----------------");

// {2} 2개 연속일치
console.log(str.match(/d{2}/));
console.log(str.match(/d{2}/gm));

console.log("----------------");

// {2,} 2개 연속일치
console.log(str.match(/d{2,}/));
console.log(str.match(/d{2,}/gm));

console.log("----------------");

// {2,3} 2~3개 연속 일치
console.log(str.match(/d{2,3}/));
console.log(str.match(/d{2,3}/gm));

console.log("----------------");

// \w
console.log(str.match(/\w{2,3}/gm));
console.log(str.match(/\b\w{2,3}\b/gm));
```

---

## 패턴(표현) 예제\_2

```js
const str = `
010-1234-5678
frozen
foo_oox
foo@oox
the
https://www.dmdrk1414@gmail.com 
The quick brown fox fo f jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd
hxyp
http://localhost:1234
동해물과_백두산이 마르고 닳도록
`;

// f, o , x 가 다 나온다.
console.log(str.match(/[fox]/g));

// 0 ~ 9 까지 숫자 가 다 나온다.
console.log(str.match(/[0-9]/g));

// 0 ~ 9 까지 이어진 숫자 가 다나온다.
console.log(str.match(/[0-9]{1,}/g));

// 가 ~ 힣 까지 모든 숫자가 나온다.
console.log(str.match(/[가-힣]/g));
console.log(str.match(/[가-힣]{1,}/g));

//   \b 는 기준이다 띄어쓰기. @, 벽 등등 기준
console.log(str.match(/\bf\w/g));
console.log(str.match(/\bf\w{1,}/g));
console.log(str.match(/\bf\w{1,}\b/g));

// \d 숫자만 입력
console.log(str.match(/\d/g));

const h = "    the hello world   !  ";

// \s 공백문자
console.log(str.match(/\s/g));
console.log(h.replace(/\s/g, ""));
```

---

## 패턴(표현) 예제\_3

```js
const str = `
010-1234-5678
the
dmdrk1414@gmail.com 
The quick brown fox jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd.
`;

// (?=) 앞쪽 일치 . 임의의 문자
console.log(str.match(/.{1,}(?=@)/g));

// (?<=) 뒷쪽 일치 . 임의의 문자
console.log(str.match(/(?<=@).{1,}/g));
```
