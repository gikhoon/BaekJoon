With recursive outs as (
    SELECT 0 as N
    
    UNION ALL
    
    SELECT N+1 from outs
    where N < 23
)


SELECT N as HOUR, COUNT(ANIMAL_ID) as COUNT
FROM OUTS o left join ANIMAL_OUTS a on o.N = HOUR(a.DATETIME)
GROUP BY N
order by N

# SELECT *
# FROM OUTS o left join ANIMAL_OUTS a on o.N = HOUR(a.DATETIME)