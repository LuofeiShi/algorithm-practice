class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            int len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j++].length();
            }
            
            StringBuilder sb = new StringBuilder();
            if (j == words.length || j == i + 1) {
                // match left edge
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(' ');
                    sb.append(words[k]);
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                // match left and right edge
                int cnt = j - i - 1, r = maxWidth - len + cnt;
                sb.append(words[i]);
                int k = 0;
                while (k < (r % cnt)) {
                    for (int index = 0; index < (r / cnt + 1); index++) {
                        sb.append(' ');
                    }
                    sb.append(words[i + k + 1]);
                    k++;
                }
                while (k < cnt) {
                    for (int index = 0; index < r / cnt; index++) {
                        sb.append(' ');
                    }
                    sb.append(words[i + k + 1]);
                    k++;
                }
            }
            res.add(sb.toString());
            i = j - 1;
        }
        return res;
    }
}
