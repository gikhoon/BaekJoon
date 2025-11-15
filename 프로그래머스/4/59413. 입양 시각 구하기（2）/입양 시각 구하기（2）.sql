WITH outs (n) AS (
    -- 0부터 시작
    SELECT 0
    FROM dual
    
    UNION ALL
    
    -- 23까지 증가
    SELECT n + 1
    FROM outs
    WHERE n < 23
),
agg AS (
    SELECT 
        TO_NUMBER(TO_CHAR(a.datetime, 'HH24')) AS hour,
        COUNT(*) AS cnt
    FROM ANIMAL_OUTS a
    GROUP BY TO_NUMBER(TO_CHAR(a.datetime, 'HH24'))
)
SELECT 
    o.n AS hour,
    NVL(a.cnt, 0) AS count
FROM outs o
LEFT JOIN agg a 
    ON a.hour = o.n
ORDER BY o.n;