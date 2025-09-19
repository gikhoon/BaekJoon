-- 코드를 작성해주세요
SELECT E.EMP_NO as EMP_NO, E.EMP_NAME as EMP_NAME,
case
    when D.a >= 96 then 'S'
    when D.a >= 90 then 'A'
    when D.a >= 80 then 'B'
    else 'C'
    END as GRADE,
CASE
        WHEN D.a >= 96 THEN E.SAL * 0.2
        WHEN D.a >= 90 THEN E.SAL * 0.15
        WHEN D.a >= 80 THEN E.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES as E join (
    SELECT AVG(SCORE) as a, E2.EMP_NO as EMP_NO
    FROM HR_EMPLOYEES as E2 join HR_GRADE as G2 on E2.EMP_NO = G2.EMP_NO
    GROUP BY E2.EMP_NO 
) as D on E.EMP_NO = D.EMP_NO
order by EMP_NO

