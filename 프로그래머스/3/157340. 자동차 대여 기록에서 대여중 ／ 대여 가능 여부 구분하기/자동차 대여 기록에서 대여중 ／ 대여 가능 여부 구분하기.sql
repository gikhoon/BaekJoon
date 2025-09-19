-- 코드를 입력하세요
SELECT distinct h.CAR_ID as CAR_ID, 
(
    CASE when 
    exists (
        select 1
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h2
        where h2.CAR_ID = h.CAR_ID and '2022-10-16' between h2.START_DATE and h2.END_DATE
    )
    then "대여중"
    else "대여 가능"
    END
) AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
order by CAR_ID desc


