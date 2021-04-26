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


