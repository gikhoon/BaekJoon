-- 코드를 입력하세요
SELECT b.CATEGORY as CATEGORY, sum(sales) as TOTAL_SALES
FROM BOOK_SALES s join BOOK as b on s.BOOK_ID = b.BOOK_ID
where s.SALES_DATE between '2022-01-01' and '2022-01-31'
group by CATEGORY
order by CATEGORY
