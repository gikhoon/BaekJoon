-- 코드를 입력하세요
SELECT MONTH(h.start_date) as MONTH, h.CAR_ID as CAR_ID, count(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
where YEAR(h.start_date) = 2022 and MONTH(h.start_date) >= 8 and MONTH(h.start_date) <=10
and h.CAR_ID in (
    select CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as h2
    where YEAR(h2.start_date) = 2022 and MONTH(h2.start_date) >= 8 and MONTH(h2.start_date) <=10
    group by CAR_ID
    having count(*) >=5
)
group by MONTH, CAR_ID
order by month, CAR_ID desc



