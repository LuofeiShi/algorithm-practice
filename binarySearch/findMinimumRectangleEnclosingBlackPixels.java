class Solution {
    public int minArea(char[][] image, int x, int y) {
        // to find the rectangle, we need to find:
        // 1. the right most colum that 1 appear.
        // 2. the left most colum that 1 appear.
        // 3. the top most row that 1 appear.
        // 4. the bottom most row that 1 appear.
        // then we can calculate the area by: (right - left + 1) * (bottom - top + 1)
        
        // first check inputs
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        int n = image.length;
        int m = image[0].length;
        
        int left = findLeft(image, 0, y);           // on the left of given point
        int right = findRight(image, y, m - 1);     // on the right of the given point
        int top = findTop(image, 0, x);             // on the top of given row
        int bottom = findBottom(image, x, n - 1);   // on the bottom of given row
        
        return (right - left + 1) * (bottom - top + 1);
    }
    
    private int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isEmptyColumn(image, start))
            return end;
        return start;
    }
    
    private int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isEmptyColumn(image, end)) {
            return start;
        }
        return end;
    }
    
    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isEmptyRow(image, start)) {
            return end;
        }
        return start;
    }
    
    private int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isEmptyRow(image, end)) {
            return start;
        }
        return end;
    }
    
    private boolean isEmptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1')
                return false;
        }
        return true;
    }
    
    private boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1')
                return false;
        }
        return true;
    }
}