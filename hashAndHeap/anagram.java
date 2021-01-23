public class Anagram {
    public static int anagram(String s) {
        if (s.length() % 2 == 1)
            return -1;

        Stirng s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);

        int[] dic = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int letter : chars) {
            if (letter > 0) {
                ans += letter;
            }
        }
        return ans;
    }
}
