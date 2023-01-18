class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] >= 'a'){
                    char val = grid[i][j];
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i * cols + j);
                    while(!q.isEmpty()){
                        int curr = q.poll();
                        int row = curr / cols, col = curr % cols;
                        if(grid[row][col] < 'a') return true;
                        grid[row][col] -= 26;
                        for(int[] dir : directions){
                            int row2 = row + dir[0], col2 = col + dir[1];
                            if(isValid(row2, col2, rows, cols, val, grid)){
                                q.add(row2 * cols + col2);
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean isValid(int row, int col, int rows, int cols, 
                            char val, char[][] grid){
        if(row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if(grid[row][col] != val) return false;
        return true;
    }
}