-- 코드를 입력하세요
SELECT
o.PRODUCT_ID as PRODUCT_ID,
p.PRODUCT_NAME,
sum(amount * price) as TOTAL_SALES
from FOOD_PRODUCT p
join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID
where Year(o.PRODUCE_DATE) = 2022 and Month(o.PRODUCE_DATE) = 5
group by o.product_ID
order by TOTAL_SALES DESC, PRODUCT_ID