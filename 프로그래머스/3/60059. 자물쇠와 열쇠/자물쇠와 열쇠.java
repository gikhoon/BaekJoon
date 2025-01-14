class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        lock = makeBig(lock, key.length);
        int[][] base = clone(key);
        
        for (int r = 0; r < 4; r++) { // 4번 회전 (0도, 90도, 180도, 270도)
            for (int x = 0; x <= lock.length - key.length; x++) {
                for (int y = 0; y <= lock.length - key.length; y++) {
                    if (isMatch(base, lock, x, y)) return true;
                }
            }
            base = rotate90(base); // key를 90도 회전
        }
        return false;
    }

    private boolean isMatch(int[][] key, int[][] lock, int startX, int startY) {
        int keySize = key.length;
        int[][] tempLock = clone(lock);

        // key를 lock에 배치
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                tempLock[startX + i][startY + j] += key[i][j];
            }
        }

        // lock의 중앙 영역 확인
        int padding = keySize - 1;
        return isLockFilled(tempLock, padding, padding + lock.length - (2 * padding));
    }

    private boolean isLockFilled(int[][] lock, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (lock[i][j] != 1) { // 중앙 영역이 모두 1이어야 함
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotate90(int[][] base) {
        int size = base.length;
        int[][] rotated = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - 1 - i] = base[i][j];
            }
        }
        return rotated;
    }

    private int[][] clone(int[][] base) {
        int[][] cpy = new int[base.length][base.length];
        for (int i = 0; i < base.length; i++) {
            cpy[i] = base[i].clone();
        }
        return cpy;
    }

    private int[][] makeBig(int[][] base, int keySize) {
        int padding = keySize - 1;
        int[][] newArr = new int[base.length + 2 * padding][base.length + 2 * padding];

        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base.length; j++) {
                newArr[i + padding][j + padding] = base[i][j];
            }
        }
        return newArr;
    }
}
