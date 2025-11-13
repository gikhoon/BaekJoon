SELECT DISTINCT h1.CAR_ID as CAR_ID,
CASE WHEN (
    exists (
        select 1
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h2
        where h2.CAR_ID = h1.CAR_ID and '2022-10-16' between h2.START_DATE and h2.END_DATE
    )   
) then '대여중'
    else '대여 가능'
    END as AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as h1
order by CAR_ID desc

# SELECT *
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where '2022-10-16' between START_DATE and END_DATE
# order by CAR_ID desc