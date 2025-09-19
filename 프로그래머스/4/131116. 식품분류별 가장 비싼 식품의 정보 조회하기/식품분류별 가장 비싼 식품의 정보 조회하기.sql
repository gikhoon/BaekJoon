-- 코드를 입력하세요
# SELECT CATEGORY, MAX(PRICE) as PRICE
# FROM FOOD_PRODUCT
# WHERE CATEGORY in ('식용유', '과자', '국', '김치')
# group by CATEGORY

SELECT CATEGORY, PRICE as MAX_PRICE, p1.PRODUCT_NAME as PRODUCT_NAME
FROM FOOD_PRODUCT p1
WHERE p1.CATEGORY in ('식용유', '과자', '국', '김치') and
p1.price = (
    select MAX(PRICE)
    from FOOD_PRODUCT p2 where p2.CATEGORY = p1.CATEGORY
    )
group by p1.CATEGORY
order by MAX_PRICE desc