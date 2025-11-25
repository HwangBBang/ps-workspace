-- 코드를 입력하세요
SELECT CAR_ID, 
case 
    WHEN SUM(case 
        when '2022-10-16' between START_DATE and END_DATE then 1
        else 0
     end) > 0
     THEN '대여중'
     ELSE '대여 가능' 
     END AS AVAILABILITY

from CAR_RENTAL_COMPANY_RENTAL_HISTORY group by CAR_ID
order by CAR_ID desc;