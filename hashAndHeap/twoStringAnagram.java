class Solution {
    public int minSteps(String s, String t) {
        if (s.equals(t))
            return 0;

        int n = s.length(), ans = 0;
        int[] arr = new int[26];
        // convert string to char array
        char[] sc = s.toCharArray();
        // converted string to char array
        char[] tc = t.toCharArray();

        for (int i = 0; i < n; i++) {
            arr[sc[i] - 'a']++;
            arr[tc[i] - 'a']--;
        }
        for (int i : arr) {
            if (i > 0)
                ans += 1;
        }
        return ans;
    }
}
