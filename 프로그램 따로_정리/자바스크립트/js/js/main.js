const http = require("http");

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.end("HELLO");
});

const PORT = 3000;

server.listen(PORT, () => {
  console.log("작은 서버를 만들어 보자!!!", PORT);
});
