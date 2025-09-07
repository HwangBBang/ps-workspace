-- 코드를 입력하세요

-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, TO_CHAR(r.CREATED_DATE, 'YYYY-MM-DD')as CREATED_DATE
from USED_GOODS_BOARD b 
join USED_GOODS_REPLY r 
on r.BOARD_ID = b.BOARD_ID
where b.CREATED_DATE >= TO_DATE('2022-10-01', 'YYYY-MM-DD') 
and b.CREATED_DATE < TO_DATE('2022-11-01', 'YYYY-MM-DD') 
order by r.CREATED_DATE , b.TITLE
-- BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS
-- 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수

-- REPLY_ID, BOARD_ID, WRITER_ID, CONTENTS, CREATED_DATE는 
-- 댓글 ID, 게시글 ID, 작성자 ID, 댓글 내용, 작성일