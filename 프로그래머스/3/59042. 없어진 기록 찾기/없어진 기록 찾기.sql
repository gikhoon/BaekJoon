-- 코드를 입력하세요
# SELECT *
# FROM ANIMAL_INS as i
# LEFT JOIN
# ANIMAL_OUTS as o on i.ANIMAL_ID = o.ANIMAL_ID

SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS 
where ANIMAL_ID not in (
    select distinct ANIMAL_ID from ANIMAL_INS 
)