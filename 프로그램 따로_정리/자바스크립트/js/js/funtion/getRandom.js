export function random() {
  return Math.floor(Math.random() * 10);
}

export function getType(data) {
  return Object.prototype.toString.call(data);
}

export const user = {
  name: "dmdrk1414",
  age: 112,
};

export const array = [{ name: "dmdrk1414" }, { age: 112 }];
