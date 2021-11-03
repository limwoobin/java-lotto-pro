# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기
### 기능 구현 목록
- 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- 숫자 하나로 이루어진 문자열(e.g. "1")인 경우 해당 숫자 반환  
- ',:' 를 구분자로 문자열 분리
- 커스텀 구분자에 의한 문자열 분리
- 분리된 문자열 sum
- 예외 처리
- 테스트 케이스

## 로또(자동)
### 기능 구현 목록
- 사용자 Input을 위한 InputView 클래스를 생성한다.
  - readline을 하기 위한 Console 클래스
  - 사용자 input 클래스
- 상수, 메세지 관리를 위한 클래스 생성
- 로또 도메인 클래스 생성
  - 6개의 숫자를 관리하는 하나의 로또 클래스
  - 일급 컬렉션
  - 숫자 자동 생성
  - 테스트 케이스 작성
- 로또 자동 생성 클래스를 생성한다.
  - 구입 금액 만큼 로또 클래스 생성
  - 당첨 결과 확인 메서드 작성
  - 테스트 케이스 작성
- 당첨 번호 클래스를 생성한다.
  - 당첨번호 input 클래스 생성
  - 당첨 번호 input 시 1~45까지의 숫자만 입력 가능 & 6까지만 입력 가능, delimiter = , 지정
  - 테스트 케이스 작성
- 당첨 결과 클래스 생성
  - 자동 생성된 로또 번호 통계
  - 수익률 계산
- 결과에 대한 ResultView 클래스를 생성한다.
- Main 메서드 클래스 생성

### 결과 확인
LottoMain 클래스의 main 메서드를 활용한다.


  

