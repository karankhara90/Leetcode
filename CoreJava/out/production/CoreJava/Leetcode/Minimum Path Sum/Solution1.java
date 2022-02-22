class Solution1 {
    public int minPathSum(int[][] grid) {
        int maxRowInd = grid.length - 1, maxColInd = grid[0].length - 1;

        if(maxRowInd == -1 || maxColInd == -1){ return -1; }
        if(maxRowInd == 0 && maxColInd == 0){ return grid[0][0]; }

        Map<String, Integer> memoize = new HashMap<>();

        minPathSum(grid, 0, 0, maxRowInd + 1, maxColInd + 1, 0, memoize);
        printMap(memoize);

        return memoize.get(maxRowInd+","+maxColInd);
    }


    public void minPathSum(int[][] grid, int r, int c, int rows, int cols, int sumParent, Map<String, Integer> memoize) {
        if(r == rows || c == cols){ return; }

        String pair = r+","+c;
        int sum = sumParent + grid[r][c];
        if(!memoize.containsKey(pair)){
            memoize.put( pair, sum );
        }else{
            if(sum < memoize.get(pair) ){
                memoize.put( pair, sum );
            }else{
                return;
            }
        }

        minPathSum(grid, r+1, c, rows, cols, sum, memoize);
        minPathSum(grid, r, c+1, rows, cols, sum, memoize);
    }

    public void printMap(Map<String, Integer> memoize) {
        System.out.println("Map: ");
        for(Map.Entry entry : memoize.entrySet() ){
            String pair = (String) entry.getKey();
            System.out.println(pair+", "+entry.getValue());
        }
    }

}