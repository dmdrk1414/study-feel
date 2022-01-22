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

// B. 각 도시별로 개와 고양이를 키우는 사람의 수

/**
 * {
  서울: {
    dog: 2,
    cat: 1,
  },
  대구: {
    dog: 1,
    cat: 1,
  },
  부산: {
    cat: 1,
  },
};
 * 
 */

// 타입 정의 오브젝트. key는 string, 값은 number          타입의 이름은? PetsOfCities
/** @typedef {Object.<string, Object.<string, number>>} PetsOfCities */

function solveB() {
  /** @type {PetsOfCities} */
  const result = {};

  peple.forEach((person) => {
    const { city, pet: petOrPets } = person;

    // 펫이 있으면?
    if (petOrPets) {
      const petsOfCity = result[city] || {};

      // petOrPets가 문자형이면?
      if (typeof petOrPets === "string") {
        // pet 은 문자열
        const pet = petOrPets;
        const origNumPetsOfCity = petsOfCity[pet] || 0;
        petsOfCity[pet] = origNumPetsOfCity + 1;
      } else {
        for (const pet of petOrPets) {
          const origNumPetsOfCity = petsOfCity[pet] || 0;
          petsOfCity[pet] = origNumPetsOfCity + 1;
        }
      }

      result[city] = petsOfCity;
      console.log("~ petsOfCity", petsOfCity);
    }
  });

  return result;
}

console.log("~ solveB()", solveB());
