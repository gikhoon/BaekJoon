-- 코드를 입력하세요
SET @signin = (
    SELECT COUNT(DISTINCT USER_ID)
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
);

SELECT YEAR(sales_date),
MONTH(sales_date),
count(distinct u.user_id) as PURCHASED_USERS,
ROUND(count(distinct u.user_id) / @signin, 1) as PUCHASED_RATIO
FROM USER_INFO u
JOIN ONLINE_SALE o on u.USER_ID = o.USER_ID 
and o.user_ID in
(
    select distinct USER_ID
    from USER_INFO
    where YEAR(JOINED) = 2021 
)
group by YEAR(sales_date), MONTH(sales_date)

