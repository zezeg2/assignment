## 문제 7

---

<aside>
🧩 스프링부트를 사용하여 게시판 API를 만듭니다. 
**화면 구성할 필요 없이, API 코드만 동일하게 만들어서 제출하면 됩니다.**

</aside>

### **요구사항**

- 커뮤니티 사이트를 구현해주세요.
- 로그인은 가능해야 합니다. 단 회원가입은 없습니다.
- 회원 테이블에 2명의 회원을 만들어주세요.
    - 1번 회원(admin)은 관리자 회원입니다.
    - 2번 회원(user1)은 일반 회원입니다.
- 게시글의 CRUD를 구현해주세요.
- 게시판은 2개가 있습니다.(1번 게시판은 공지사항, 2번 게시판은 자유게시판)
- 메인페이지에는, 각 게시판의 최신글이 10개 나와야 합니다.
- MySQL을 이용해주세요.
- 각 게시판별 게시물을 300개 이상 만들어 주세요.
    - 공지사항 게시물은 전부 1번 회원(admin)이 작성한 걸로 되어야 합니다.
    - 자유 게시물은 전부 2번 회원(user)가 작성한 걸로 되어야 합니다.
- 게시물 검색은 게시물 제목만 해당됩니다.
- JDBC 템플릿을 이용합니다.
    - MyBatis, JPA를 이용하지 않습니다.
- 2번 회원(user1)은 본인이 작성한 게시물만 수정/삭제 할 수 있습니다.
- 1번 회원(admin)은 타인이 작성한 게시물을 삭제 할 수 있습니다. 수정은 불가능 합니다.

### **엔드포인트 예시**

---

- /usr/home/main
    - 내용 : 메인화면, 각 게시판별 최신글 10개씩 노출
    - HTTP 메소드 : GET
- /usr/article/list?boardId=1
    - 내용 : 1번 게시판(공지사항)의 게시물 10개 노출, 1 페이지
    - HTTP 메소드 : GET
- /usr/article/list?boardId=1&page=2
    - 내용 : 1번 게시판(공지사항)의 게시물 10개 노출, 2 페이지
    - HTTP 메소드 : GET
- /usr/article/list?boardId=2
    - 내용 : 2번 게시판(자유게시판)의 게시물 10개 노출, 1 페이지
    - HTTP 메소드 : GET
- /usr/article/list?boardId=2&searchKeyword=11
    - 내용 : 2번 게시판(자유게시판)의 게시물 중에서, 제목에 11이라는 문장이 포함된 것들만 추려서 10개 노출
    - HTTP 메소드 : GET
- /usr/article/detail?id=1
    - 내용 : 1번 게시물 상세화면
    - HTTP 메소드 : GET
- /usr/article/modify?id=1
    - 내용 : 1번 게시물의 수정 폼
    - HTTP 메소드 : GET
- /usr/article/doModify
    - 내용 : 1번 게시물의 수정 폼 처리
    - HTTP 메소드 : POST
    - 파라미터
        - id : 수정하려는 게시물 번호
        - title : 새 제목
        - body : 새 내용
- /usr/article/write?boardId=1
    - 내용 : 1번 게시판의 글 작성 폼
    - HTTP 메소드 : GET
- /usr/article/doWrite
    - 내용 : 1번 게시판의 글 작성 폼
    - HTTP 메소드 : POST
    - 파라미터
        - boardId : 작성하려는 게시물의 게시판 번호
        - title : 제목
        - body : 내용
- /usr/member/login
    - 내용 : 로그인 폼
    - HTTP 메소드 : GET
- /usr/member/doLogin
    - 내용 : 로그인 폼
    - HTTP 메소드 : POST
    - 파라미터
        - loginId : 아이디
        - loginPw : 비밀번호