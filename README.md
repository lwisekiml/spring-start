# spring-start
## 프로젝트 환경설정 - 프로젝트 생성
https://start.spring.io/

## 프로젝트 환경설정 - 빌드하고 실행하기
윈도우 cmd build 방법

gradlew build

cd build/libs에서

java -jar hello-spring-0.0.1-SNAPSHOT.jar

## 스프링 웹개발 기초 - 정적 컨텐츠
실행 : http://localhost:8080/hello-static.html

## 회원 관리 예제 - 웹 MVC 개발 : 회원 웹 기능 - 홈 화면 추가
controller안에 HomeController가 / 이므로 실행(index.html은 무시됨)

## 회원 관리 예제 - 웹 MVC 개발 : 회원 웹 기능 - 등록
createMemberForm.html을 통해 폼 작성 후 등록

name="name" 부분에 의해 name에 값 저장

->

MemberController의

@PostMapping("/members/new")

public String create(MemberForm form) {

실행

MemberForm에 name이 setting

(setName이 자동 실행 되어 저장 되는것 같음)

## 스프링 DB 접근 기술 : H2 데이터베이스 설치
https://www.h2database.com
다운로드 및 설치(All Platforme 다운)

h2 데이터베이스 버전은 스프링 부트 버전에 맞춘다.

권한 주기: chmod 755 h2.sh (윈도우 사용자는 x)
실행: ./h2.sh (윈도우 사용자는 ./h2.bat)

안될 경우 앞부분 IP를 localhost로 변경(ex: localhost:8082....)

데이터베이스 파일 생성 방법
1) jdbc:h2:~/test (최초 한번 접속/자동입력 되어있다.)
2) ~/test.mv.db 파일 생성 확인
3) 이후부터는 JDBC URL을 jdbc:h2:tcp://localhost/~/test 로 바꿔서 접속


