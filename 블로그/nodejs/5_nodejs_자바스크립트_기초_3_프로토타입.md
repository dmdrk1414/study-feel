prototype

# prototype 하는 법

prototype은 쉽게 생각하면 클래스안에 있는 함수이다. (매소드 같은)

생성자에 메소드 체인을 걸수 있습니다.

```js
// Prototype

function Student(name) {
  this.name = name;
}

Student.prototype.greet = function greet() {
  return `Hi, ${this.name}`;
};

const me = new Student("dmdrk1414");
console.log(me.greet);
```

```
Hi, dmdrk1414
```

debug로 확인을 하여도 prototype으로 geet() 함수가 있네용.

---

저는 다시 **Person**이라는 **부모클래스**를 만들어서

**student**을 자식 클래스로 만들어 보겠습니다.

(class의 상속개념과 super개념을 공부해서 오세요)

```js
// Prototype

function Person(name) {
  this.name = name;
}

function Student(name) {
  this.__proto__.constructor(name);
  //super 부모의 생성자를 상속한다.
}

Person.prototype.greet = function greet() {
  return `Hi, ${this.name}!!!`;
};

Student.prototype.study = function study() {
  return `${this.name} is studing`;
};

Object.setPrototypeOf(Student.prototype, Person.prototype);
// Person class에 Student class을 상속시켰다.

const me = new Student("dmdrk1414");
console.log(me.greet());
console.log(me.study());
```

```
Hi, dmdrk1414!!!
dmdrk1414 is studing
```

혹시 능력되시는 분은 debug로 확인 해보시면서 비교해보셔요

---

추가로 prototype을 알려드리면

instanceof 가 있습니다.

```js
// Prototype

function Person(name) {
  this.name = name;
}

function Student(name) {
  this.__proto__.constructor(name);
}

Person.prototype.greet = function greet() {
  return `Hi, ${this.name}!!!`;
};

Student.prototype.study = function study() {
  return `${this.name} is studing`;
};

Object.setPrototypeOf(Student.prototype, Person.prototype);

const me = new Student("dmdrk1414");
// instanceof 누구의 인스턴스인가?
console.log(me instanceof Student);
console.log(me instanceof Person);

const anotherPerson = new Person("Foo");
console.log(anotherPerson instanceof Student);
console.log(anotherPerson instanceof Person);

console.log([] instanceof Array);
```

```
true
true
false
true
true
```

instanceof는 이 인스턴스가 이 클래스에 포함하냐를 알려줍니다.!
