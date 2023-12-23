
-- Options
-- Type : '세단', 'SUV', '승합차', '트럭', '리무진'
-- 코드를 입력하세요
SELECT round(AVG(DAILY_FEE)) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR 
where CAR_TYPE = 'SUV'
