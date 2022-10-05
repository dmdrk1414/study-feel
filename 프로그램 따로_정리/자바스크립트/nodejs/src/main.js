// @ts-check

/* eslint-disable no-new */
/* eslint-disable no-console */

// 프레임워크 없이 간단한 토이프로젝트 웹 서버 만들어보기

/**
 * 블로그 포스팅 서비스
 * - 로컬 파일을 데이터베이스로 환용할 예정 (JSON)
 * - 인증 로직은 넣지 않는다. (유저에 의심하지 않는다)
 * - RESTful API을 사용한다. test와 사람이 보기 편하다hh
 */

const http = require("http");

const PORT = 4000;

const server = http.createServer((req, res) => {
  res.writeHead(200, { "content-Type": "text/html" });
  res.end("plz help me ");
});

server.listen(PORT, () => {
  console.log("listen");
});
