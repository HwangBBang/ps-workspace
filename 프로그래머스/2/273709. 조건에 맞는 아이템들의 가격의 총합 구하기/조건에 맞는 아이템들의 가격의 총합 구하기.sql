-- 코드를 작성해주세요
select SUM(PRICE) as TOTAL_PRICE
from ITEM_INFO
where RARITY = 'LEGEND'