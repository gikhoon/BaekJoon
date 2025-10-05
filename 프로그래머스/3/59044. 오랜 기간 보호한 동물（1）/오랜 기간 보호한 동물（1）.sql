-- 코드를 입력하세요
SELECT i.NAME as NAME, i.DATETIME as DATETIME
from ANIMAL_INS as i left join ANIMAL_OUTS as o on i.ANIMAL_ID = o.ANIMAL_ID
where o.DATETIME is NULL
order by i.DATETIME
limit 3