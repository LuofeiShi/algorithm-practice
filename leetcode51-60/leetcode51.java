class Solution {
    // using two arrays of size 2n to represents the diagonal positions of the board.
    int n;
    boolean[] col, dg, udg;
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int _n) {
        // init vectors
        n = _n;
        col = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        // init board
        for(int i = 0; i < n; i++) {
            String s = ".";
            s = s.repeat(n);
            path.add(s);
        }
        // do backtrack and return the answer.
        dfs(0);
        return ans;
    }
    
    private void dfs(int u) {
        // reach the end of the board. add the path to the answer.
        if (u == n) {
            List<String> temp = new ArrayList<>(path);
            ans.add(temp);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            // check if the position is valid.
            if (!col[i] && !dg[u - i + n] && !udg[u + i]) {
                // set the column array's value and two diagonal arrays' values to false.
                // also set the position in the path to 'Q'.
                col[i] = true;
                dg[u - i + n] = true;
                udg[u + i] =  true;
                char[] s = path.get(u).toCharArray();
                s[i] = 'Q';
                String c = String.valueOf(s);
                path.set(u, c);
                // backtrack
                dfs(u + 1);
                // recovery all the settings before backtrack.
                s = path.get(u).toCharArray();
                s[i] = '.';
                c = String.valueOf(s);
                path.set(u, c);
                col[i] = false;
                dg[u - i + n] = false;
                udg[u + i] =  false;
            }
        }
    }
}
