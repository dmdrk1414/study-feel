java
seungchan141414@gmail.com
Qkrtmdcks1!

## 자바을 사용하면서 사용하는 툴

1. 자바 개발도구 : jdk 11.0.2(build 11.0.2+9) , spring "Tool suite 3.9.17"
2. IDE : STS3(eclips) , intellij - ( boot + spring 사용가능)
3. 웹 서버 : Tomcat 9 "9.0.62"
4. 데이터 베이스 : MySQL 5.7

---

JAVA_HOME : 톰캣의 환경변수를 잡아준다.

java : do input java directory \bin path

톰캣 : 실행하는 방법

cd C:\Program Files\apache-tomcat-9.0.62\bin

startup cmd에 명령창 실행 - port는 8080

---

sts 의 들어가서 프로젝트 스프링 mvc 생성우 톰캣을 연결

---

외부 browser을 사용하는 방법을 찾아보자.

---

## AWS에 서버 구축하기

Amazon EC2 - 크기 조정이 가능한 컴퓨팅 용량을 클라우드에서 제공하는 웹 서비스

Amazon S3 - 확장성, 가용성, 내구성을 가진 데이터 저장 공간을 제공

Amazon RDS - 관계형 DB 관리 서비스, 관계형을 모니터링, 주기적 백업

```
on-Premise : 서버를 직접 운영하는 방식
Serverless : 서버 작업을 서버내부가 아닌 클라우드 서비스로 처리
Region : 데이터 센터가 물리적으로 존재하는 곳.
CDN(Content Delivery Network) : 정적 리소스를 빠르게 제공할 수 있게 전셰게의 캐시서버에 복제해주는 서비스,
```

rdp : aws에서 받은 가상환경 머신에 접속하기위한 프로그램

---

## aws에서 톰캣을 돌리고 다른 컴퓨터에서 aws에서 돌리는 톰캣 접근

rdp 가상환경 머신에서 설정하는 방법

윈도우처럼 톰캣과 자바를 설치한후

원격환경에서 원격 서버를 열기위한 firewall을 들어가서 advance settings,

in 안으로 들어가기

out 밖으로 나가는 규칙

newrules을 하여 8080의 허가를 받자.

aws의 보안그룹의 새로운 규칙설정 모든 tcp

1. aws 내 서버에서의 firewall 의 inbound Rules 에서 새로운 규칙을 설정을 하자.
2. aws의 홈페이지 대시보드에서 규칙을 정하자.
   http://52.79.250.19:8080/
9