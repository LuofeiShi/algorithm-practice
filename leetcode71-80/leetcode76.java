class Solution {
    public String minWindow(String s, String t) {
        // this problem use a similar approach as leetcode 30.
        // ht represents the number of different chars string t
        // hs represents the number of different chars in our sliding window of string s
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        // fill in the ht hashmap based on string s
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i) , 0) + 1);
        }
        
        String res = ""; // the result string
        int cnt = 0;    // cnt represents the number of efficient characters in our sliding window
        // j means the nearest position for i to including all characters
        for (int i = 0, j = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            // if we don't get enough char that at position i, we can count it as a efficient char
            // and move the right pointer to include this char 
            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i)))
                cnt++;
            
            // if we got extra char at j, we need to move the left pointer to the right
            while (j < i && hs.get(s.charAt(j)) > ht.getOrDefault(s.charAt(j), 0)) {
                int num = hs.get(s.charAt(j));
                hs.put(s.charAt(j), num - 1);
                j++;
            }
            
            if (cnt == t.length()) {    // we got enough valid chars
                if (res.length() == 0 || i - j + 1 < res.length()) {
                    // we can update our result string when we got shorter valid window
                    res = s.substring(j, i + 1);
                }
            }
        }
        
        return res;
        
    }
}
