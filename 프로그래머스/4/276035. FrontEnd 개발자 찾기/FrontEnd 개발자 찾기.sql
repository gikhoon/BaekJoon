-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS s
where s.SKILL_CODE & (
    select sum(CODE)
    from skillcodes
    where CATEGORY = "Front End"
) > 0
order by s.ID

