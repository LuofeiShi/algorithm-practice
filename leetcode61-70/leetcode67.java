class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        StringBuilder c = new StringBuilder();
        for (int i = 0, t = 0; i < a.length() || i < b.length() || t > 0; i++) {
            if (i < a.length()) t += a.charAt(i) - '0';
            if (i < b.length()) t += b.charAt(i) - '0';
            c.append(String.valueOf(t % 2));
            t /= 2;
        }
        
        return c.reverse().toString();
    }
}
