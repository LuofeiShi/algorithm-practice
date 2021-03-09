class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];
        
    public void solveSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        
        dfs(board, 0, 0);
    }
    
    private boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') {
            return dfs(board, x, y+1);
        }
        for (int i = 0; i < 9; i++) {
            // check if the current number is appeared in row, col, or 3 x 3.
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = (char) ((int)'1' + i);
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = true;
                // if we fill the whole board, return true and end
                if (dfs(board, x, y+1)) return true;
                // else, trace back
                board[x][y] = '.';
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = false;
            }
        }
        // current branch has no result
        return false;
    }
}
