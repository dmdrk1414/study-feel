function test() {
  return new Promise((res, rej) => {
    setTimeout(() => {
      console.log("비동기처리 함수");
    }, 1000);
  });
}

function testCall() {
  test();
  console.log("test after");
}
