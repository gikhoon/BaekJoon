import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        // 1. 비트 마스킹을 통해 모든 열 조합 탐색
        for (int subset = 1; subset < (1 << columnCount); subset++) {
            Set<String> rowSet = new HashSet<>();

            // 2. 각 조합에 대해 유일성 검사
            for (String[] row : relation) {
                StringBuilder key = new StringBuilder();
                for (int col = 0; col < columnCount; col++) {
                    if ((subset & (1 << col)) != 0) {
                        key.append(row[col]).append(",");
                    }
                }
                rowSet.add(key.toString());
            }

            // 3. 유일성을 만족하고, 최소성을 만족하는지 검사
            if (rowSet.size() == relation.length && isMinimal(subset, candidateKeys)) {
                candidateKeys.add(subset);
            }
        }

        return candidateKeys.size();
    }

    private boolean isMinimal(int subset, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            if ((key & subset) == key) {
                return false; // 최소성을 만족하지 않음
            }
        }
        return true;
    }
}