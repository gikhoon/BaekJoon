-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID
,TO_CHAR(OUT_DATE,'YYYY-MM-DD') as OUT_DATE,
CASE 
    when o.OUT_DATE is null then '출고미정'
    when o.OUT_DATE <= TO_DATE('2022-05-01', 'YYYY-MM-DD') then '출고완료'
    else '출고대기'
 END as 출고여부
FROM FOOD_ORDER o
order by order_id