-- 코드를 작성해주세요

select t.ITEM_ID ITEM_ID, i.ITEM_NAME ITEM_NAME, i.RARITY as RARITY
from ITEM_TREE t join ITEM_INFO i on t.ITEM_ID = i.ITEM_ID
where t.ITEM_ID not in (
    select distinct(t2.PARENT_ITEM_ID)
    from ITEM_TREE as t2
    where t2.PARENT_ITEM_ID is not NULL
)
order by ITEM_ID desc