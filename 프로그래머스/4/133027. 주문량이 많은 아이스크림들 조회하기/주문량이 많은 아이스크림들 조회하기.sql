SELECT *
from (
SELECT    j.flavor
FROM      july j
LEFT JOIN first_half h 
          ON j.flavor = h.flavor
GROUP BY  j.flavor
ORDER BY  SUM(j.total_order) + SUM(h.total_order) DESC
    )
    where rowNum <=3
