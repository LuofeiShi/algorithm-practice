class Solution {
    public String multiply(String num1, String num2) {
        int[] A = new int[num1.length()];
        int[] B = new int[num2.length()];
        
        int n = num1.length();
        int m = num2.length();
        
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            A[j] = num1.charAt(i) - '0';
        }
        for (int i = m - 1, j = 0; i >= 0; i--, j++) {
            B[j] = num2.charAt(i) - '0';
        }
        
        int[] C = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i + j] += A[i] * B[j];
            }
        }
       
        for (int i = 0, t = 0; i < C.length; i++) {
            t += C[i];
            C[i] = t % 10;
            t /= 10;
        }

        
        int k = C.length - 1;
        System.out.println(k);

        while (k > 0 && C[k] == 0) {
            k--;
        }
        System.out.println(k);
        
        StringBuilder result = new StringBuilder();
        while (k >= 0) {
            result.append(C[k--]);
        }
        
        return result.toString();
        
    }
}
