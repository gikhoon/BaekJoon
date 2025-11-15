-- 코드를 입력하세요

with too as(
    SELECT b.CATEGORY as CATEGORY, SUM(SALES) as TOTAL_SALES
    from BOOK_SALES s join BOOK b on b.BOOK_ID = s.BOOK_ID 
    where s.SALES_DATE between TO_DATE('2022-01-01', 'YYYY-MM-DD') and TO_DATE('2022-01-31', 'YYYY-MM-DD')
    group by b.CATEGORY
    order by CATEGORY
)

SELECT * from TOO