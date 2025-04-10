class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long sR = x, eR = x, sC = y, eC = y;
        for(int i=queries.length-1;i>=0;i--) {
            int[] query = queries[i];
            int mount = query[1];
            if(query[0] == 1) {
                if(eC != m-1 && eC - mount < 0) return 0;
                if(eC != m-1) eC -= mount;
                sC = Math.max(0, sC - mount);
                //c증
            } else if(query[0] == 0) {
                //c감
                if(sC != 0 && sC + mount >= m) return 0;
                if(sC != 0) sC += mount;
                eC = Math.min(m-1, eC + mount);
            } else if(query[0] == 3) {
                //r증
                //0 0 => 1증가
                if(eR != n-1 && eR - mount < 0) return 0;
                if(eR != n-1) eR -= mount;
                sR = Math.max(0, sR - mount);
            } else {
                if(sR != 0 && sR + mount >= n) return 0;
                if(sR != 0) sR += mount;
                eR = Math.min(n-1, eR + mount);
                //r감
            }
        }
        return (eC - sC + 1) * (eR - sR + 1);
    }
    /**
    1 3  -4
    5 7
    0 3 -4
    0 7
    **/
    
    /**
    0 c감 1 c증 2 r감 3 r증
    
    거꾸로 가면 되지 않을까?
    sR eR sC eC
    2 5
    0 0 1 1
    0 1 1 1
    0 1 2 2
    0 1 2 2
    0 1 1 1
    0 1 1 1
    0 1 1 1
    
    
    **/
}