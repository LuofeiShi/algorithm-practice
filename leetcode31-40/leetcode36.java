 class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] dic = new boolean[10];
        // row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(dic, false);
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    int v = val - '0';
                    if (dic[v]) {
                        return false;
                    }
                    dic[v] = true;
                }
            }
        }
        // col
        for (int j = 0; j < 9; j++) {
            Arrays.fill(dic, false);
            for (int i = 0; i < 9; i++) {
                char val = board[i][j];
                if (val != '.') {
                    int v = val - '0';
                    if (dic[v]) {
                        return false;
                    }
                    dic[v] = true;
                }
            }
        }
        // 3 x 3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(dic, false);
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i + x][j + y] != '.') {
                            int t = board[i + x][j + y] - '0';
                            if (dic[t]) {
                                return false;
                            }
                            dic[t] = true;
                        }
                    }
                }
            }
        }
        
        return true;
        
    }
}
