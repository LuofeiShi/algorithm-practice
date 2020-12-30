public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        if (n <= 0) {
            return result;
        }
        List<Integer> cols = new ArrayList<>();
        search(result, cols, n);
        return result;
    }
    
    private void search(List<List<String>> result, List<Integer> cols, int n) {
        // already a valid path
        if (cols.size() == n) {
            List<String> path = drawPath(result, cols, n);
            result.add(path);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(cols, n, i)) {
                continue;
            }
            cols.add(i);
            search(result, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> cols, int n, int position) {
        // check if the current position is valid
        int numOfRows = cols.size();
        for (int row = 0; row < numOfRows; row++) {
            if (position == cols.get(row)) {
                return false;
            }
            // left diagonals
            if (row + cols.get(row) == position + numOfRows) {
                return false;
            }
            // right diagonals
            if (position - cols.get(row) == numOfRows - row) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> drawPath(List<List<String>> result, List<Integer> cols, int n) {
        List<String> path = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                 if (cols.get(i) == j ) {
                     sb.append("Q");
                 } else {
                     sb.append(".");
                 }
            }
            path.add(sb.toString());
        }
        return path;
    }
    
}
