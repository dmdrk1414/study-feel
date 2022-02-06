function test() {
  return new Promise((res, rej) => {
    setTimeout(() => {
      console.log("시간함수");
      res();
    }, 1000);
  });
}

function nomal() {
  setTimeout(() => {
    console.log("nomal funtion");
  }, 1000);
}

async function testCall() {
  console.log("test");
  await test();
  nomal();
  console.log("test after");
}

testCall();
