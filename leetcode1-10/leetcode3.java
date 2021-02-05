class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.get(s.charAt(i)) > 1) {
                int val = map.get(s.charAt(j));
                val--;
                map.put(s.charAt(j), val);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
