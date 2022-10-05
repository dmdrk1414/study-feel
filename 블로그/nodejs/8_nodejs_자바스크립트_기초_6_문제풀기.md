# 저는 node을 배우기 앞써 js 기초를 공부를 하고있어요

오늘은 문제를 풀어봐요

```js
const peple = [
  {
    age: 20,
    city: "서울",
    pet: ["cat", "dog"],
  },
  {
    age: 40,
    city: "부산",
  },
  {
    age: 31,
    city: "대구",
    pet: ["cat", "dog"],
  },
  {
    age: 36,
    city: "서울",
  },
  {
    age: 27,
    city: "부산",
    pet: "cat",
  },
  {
    age: 24,
    city: "서울",
    pet: "dog",
  },
];

/**
 *  다음 문제들을 풀어봅시다.
 *
 * A. 30대 미만이 한 명이라도 사는 모든 도시
 */
```

여기서 A의 문제를 풀어 봅시다.

```js
// 문제 A을 푸는 방식 1
function solvaA() {
  /** @type {string[]} */

  const cities = [];

  peple.forEach((person) => {
    if (!cities.find((city) => person.city === city)) {
      if (person.age < 30) {
        cities.push(person.city);
      }
    }
  });

  return cities;
}

console.log("~ solvaA", solvaA());

// 문제 A을 푸는 방식 2
function solveAFunctional() {
  const allCities = peple
    .filter((person) => {
      return person.age < 30;
    })
    .map((person) => {
      return person.city;
    });

  // 이런식으로 리펙토링이 가능하고요

  // const allCities = peple
  //   .filter(({ age }) => {
  //     return age < 30;
  //   })
  //   .map(({ city }) => {
  //     return city;
  //   });

  const setting = new Set(allCities);
  return Array.from(setting);
}

console.log("~ solveAFunctional()", solveAFunctional());
```

```
[ '서울', '부산' ]
```

find: 조건식에 맞는 것을 찾다
filter: 조건식에 맡는 것을 객체로 나열
map: 원하는 것을 뽑아 올수있다 의 활용을 검색해보세요.
new Set: 집합으로 만든다 => 중복을 제거한다. => typeof을 사용하시면 객체로나옵니다.

---

화이팅 합시다!!! 저도 js로 접근하니 참어렵네요...(다른것도 못하긴하지만)
