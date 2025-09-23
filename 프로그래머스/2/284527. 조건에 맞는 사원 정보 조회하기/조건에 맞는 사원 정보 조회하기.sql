SELECT SUM(SCORE) as SCORE, g.EMP_NO as EMP_NO, e.EMP_NAME as EMP_NAME, e.POSITION as POSITION, e.EMAIL as EMAIL
from HR_GRADE as g join HR_EMPLOYEES as e on e.EMP_NO = g.EMP_NO
where g.year = 2022
group by g.EMP_NO
order by score desc
limit 1