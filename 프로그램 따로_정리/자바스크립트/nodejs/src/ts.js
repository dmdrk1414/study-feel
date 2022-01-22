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
];

const asdf = peple.reduce((acc, [city, pet]) => {
  console.log(acc);
  console.log(city);
  console.log(pet);
  return acc + city;
});

console.log("~ asdf", asdf);
