# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구 사항
### 입력
- **게임 옵션 입력 기능**
  - start,end,move 이외의 입력값에 대한 검증 해주는 기능 추가
  - 이외의 문자열을 입력한 경우 예외 발생
- 게임 시작 기능 (start를 입력 받는다.)
- 게임 종료 기능 (end를 입력 받는다.)
- 게임 이동 기능 (move 출발지 목적지 - 예. move b2 b3)
  - 이동할 수 없는 지점을 입력하면 예외 발생
  - move b2 b3와 같은 형식에 알맞게 입력하는지 검증

### 도메인
- **체스말을 생성하는 기능**
  - 추상클래스 Piece, 하위 클래스 Bishop, King, Knight, Pawn, Queen, Rook
- **체스판을 초기화하는 기능**
  - 위치를 나타내주는 Position

- **BoardFactory**
  - 말들의 객체 생성과 말들의 체스 보드 초기 위치 지정
- **Position**
  - 캐싱 전략 사용
  - 각 Piece들의 움직임 가능의 여부를 확인할 때, 좌표를 비교해주는 기능
- **Bishop**
  - 대각선으로 칸수에 제한없이 움직일 수 있다.
- **King**
  - 상하좌우,대각선 1칸씩만 움직일 수 있다.
- **Knight**
  - 상하좌우 2칸 전진후, 왼쪽이나 오른쪽으로 1칸 움직일 수 있다. (L자 모형)
- **Pawn**
  - 앞으로 한칸 전진할 수 있다.
- **Queen**
  - 상하좌우, 대각선 칸수에 제한없이 움직일 수 있다.
- **Rook**
  - 상하좌우 방향으로 칸수에 제한없이 움직일 수 있다.

## 웹 UI 적용하기
- HTML 구현하기
- css 구현하기

### 웹 컨트롤러
- GET 방식의 start (보드판 초기화하기)
- POST 방식의 move (웹에서 input에 입력한 값으로 말 움직이기)
- GET 방식의 status (현재 점수 상황 조회하기)
- GET 방식의 END (게임 종료하기)
- 예외 처리 및 에외 메시지 렌더링하기

## 웹 DB 적용하기
- 웹 서버를 재시작하더라도 이전에 하던 체스 게임을 다시 시작할 수 있어야 한다.
- Board 테이블 추가
- Primary Key는 Position, column은 Piece
- 게임이 시작될 때, db도 초기화
- piece가 움직일 때마다, db에 업데이트
- 종료될 때, db에서 삭제
