class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if(words.length == 0) return ans;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int n = words.length;
        int len = words[0].length();

        HashMap<String, Integer> find = new HashMap<String, Integer>();

        for(int i = 0; i <= s.length() - n * len; i++){
            find.clear();
            int j = 0;
            for(;j < n;j++){
                String t = s.substring(i + j * len, i + j * len + len);
                if(map.containsKey(t)){
                    find.put(t, find.getOrDefault(t, 0) + 1);
                    if(find.get(t) > map.get(t)) break;
                }
                else break;
            }

            if(j == n) ans.add(i);
        }

        return ans;

    }
}
