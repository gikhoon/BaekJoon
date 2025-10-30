-- 코드를 작성해주세요
Select t.ITEM_ID as ITEM_ID, i.ITEM_NAME as ITEM_NAME
from ITEM_INFO i join ITEM_TREE t on i.ITEM_ID = t.ITEM_ID
where t.PARENT_ITEM_ID is null
order by ITEM_ID