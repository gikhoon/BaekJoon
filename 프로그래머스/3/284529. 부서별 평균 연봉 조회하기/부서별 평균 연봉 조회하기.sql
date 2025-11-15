-- 코드를 작성해주세

With gr as (
    select DEPT_ID, ROUND(AVG(SAL)) as agv
    from HR_EMPLOYEES
    group by DEPT_ID
)

SELECT gr.DEPT_ID as DEPT_ID, d.DEPT_NAME_EN as DEPT_NAME_EN, gr.agv as AVG_SAL
from gr gr join HR_DEPARTMENT d
on gr.DEPT_ID = d.DEPT_ID
order by AVG_SAL desc
