-- 코드를 입력하세요
SELECT u.USER_ID as USER_ID, NICKNAME, (CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2) as 전체주소, 
SUBSTR(TLNO, 1, 3) || '-' ||
    SUBSTR(TLNO, 4, 4) || '-' ||
    SUBSTR(TLNO, 8, 4) AS 전화번호
FROM USED_GOODS_USER u
WHERE u.USER_ID in (
    SELECT b.WRITER_ID USER_ID
FROM USED_GOODS_BOARD b
group by b.WRITER_ID
having count(*) >= 3
)
order by USER_ID desc
