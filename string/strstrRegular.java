class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() < needle.length())
            return -1;
        
        if (needle == null || needle.length() == 0)
            return 0;
        
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int len = 0;
                while (i + len < haystack.length() && len < needle.length() 
                       && haystack.charAt(i + len) == needle.charAt(len)) {
                    len++;
                }
                
                if (len == needle.length())
                    return i;
            }
        }
        
        return -1;
    }
}