-- 왜 안된건지? 
select f1.ID, f2.FISH_NAME, f1.LENGTH
from FISH_INFO f1 join FISH_NAME_INFO f2 on f1.FISH_TYPE = f2.FISH_TYPE      
   join(select FISH_TYPE, MAX(LENGTH) as MAX_LEN
        from FISH_INFO 
        group by FISH_TYPE
   )f3
   on f1.FISH_TYPE = f3.FISH_TYPE 
   and f1.LENGTH = f3.MAX_LEN
   
order by f1.id;