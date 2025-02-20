-- 코드를 작성해주세요
select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
join SKILLCODES s
on (s.code & d.skill_code) = s.code and s.name in ('C#', 'Python')
order by ID