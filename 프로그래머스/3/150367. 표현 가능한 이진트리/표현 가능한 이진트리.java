import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            if(isBinaryTree(numbers[i])) answer[i] = 1;
        }
        return answer;
    }
    
    private boolean isBinaryTree(long number) {
        String binary = Long.toBinaryString(number);
        String fullBinary = getFullBinary(binary);
        int len = fullBinary.length();
        
        int root = len / 2;
        if(fullBinary.charAt(root) == '0') {
            return false;
        }
        String leftBinary = fullBinary.substring(0, root);
        String rightBinary = fullBinary.substring(root+1);
        
        return isBinary(leftBinary) && isBinary(rightBinary);
    }
    
    private String getFullBinary(String binary) {
        int length = binary.length();
        int nodeCount = 1;
        int level = 1;
        while (length > nodeCount) {
            level *= 2;
            nodeCount += level;
        }

        int offset = nodeCount - length;
        return "0".repeat(offset) + binary;
    }
    
    private boolean isBinary(String binary) {
        int len = binary.length();
        if(len == 0) return true;
        
        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '0') {
            return isZero(leftSubTree) && isZero(rightSubTree);
        }

        return isBinary(leftSubTree) && isBinary(rightSubTree);
    }
    
    private boolean isZero(String binary) {
        for(int i=0;i<binary.length();i++) {
            if(binary.charAt(i) == '1') return false;
        }
        return true;
    }
    //0000101
    //
}