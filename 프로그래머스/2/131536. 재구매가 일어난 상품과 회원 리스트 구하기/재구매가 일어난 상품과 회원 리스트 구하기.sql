-- 코드를 입력하세요
-- ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여
-- 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 
-- 결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.


SELECT distinct ori.USER_ID ,ori.PRODUCT_ID
FROM ONLINE_SALE ori ,ONLINE_SALE com
WHERE ori.ONLINE_SALE_ID != com.ONLINE_SALE_ID
and ori.USER_ID=com.USER_ID
and ori.PRODUCT_ID=com.PRODUCT_ID
order by ori.USER_ID asc ,ori.PRODUCT_ID desc;