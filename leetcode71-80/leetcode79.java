// brute-forcing searching
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    
    private boolean dfs(char[][] board, String word, int u, int x, int y) {
        if (board[x][y] != word.charAt(u)) return false;
        if (u == word.length() - 1) return true;
        
        char t = board[x][y];
        board[x][y] = '.';  // represent we have visited this place. will be recover later.
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] == '.') continue;
            if (dfs(board, word, u+1, a, b)) return true;
        }
        board[x][y] = t;
        return false;
    }
}

// prone branches, a little bit faster
class Solution2 {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int pos = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == letters[0]) {
                    visited[i][j] = true;
                    boolean b = searchNearby(board, visited, i, j, 1, letters);
                    if (b) return b;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean searchNearby(char[][] board, boolean[][] visited, int x, int y, int index, char[] letters) {
        if (index >= letters.length) {
            return true;
        }
        char target = letters[index];
        int n = board.length;
        int m = board[0].length;

        boolean b;
        // check four directions
        if (x+1 < n && board[x+1][y] == target && !visited[x+1][y]) {
            visited[x+1][y] = true;
            b = searchNearby(board, visited, x+1, y, index+1, letters);
            if (b) return true;
            visited[x+1][y] = false;
        }
        if (y + 1 < m && board[x][y+1] == target && !visited[x][y+1]) {
            visited[x][y+1] = true;
            b = searchNearby(board, visited, x, y+1, index+1, letters);
            if (b) return true;
            visited[x][y+1] = false;
        } 
        if (x - 1 >= 0 && board[x-1][y] == target && !visited[x-1][y]) {
            visited[x-1][y] = true;
            b = searchNearby(board, visited, x-1, y, index+1, letters);
            if (b) return true;
            visited[x-1][y] = false;
        }
        if (y - 1 >= 0 && board[x][y-1] == target && !visited[x][y-1]) {
            visited[x][y-1] = true;
            b = searchNearby(board, visited, x, y-1, index+1, letters);
            if (b) return true;
            visited[x][y-1] = false;
        }
        
        return false;
    }
    
}
