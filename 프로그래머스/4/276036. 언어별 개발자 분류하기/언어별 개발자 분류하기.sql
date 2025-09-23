with cte as (
    select
    case
        when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End') > 0 and
            SKILL_CODE & (select sum(CODE) from SKILLCODES where NAME = 'Python') > 0
    then 'A'
    
    when SKILL_CODE & (select sum(CODE) from SKILLCODES where NAME = 'C#') > 0
    then 'B'
    
    when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End') > 0
    then 'C'
    else NULL
    end as grade,
    id,email
    from developers
)

select *
from cte
where GRADE IS NOT NULL
order by grade, ID
