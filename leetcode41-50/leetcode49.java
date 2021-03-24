class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // Have to say that JAVA is really verbose...
            // I can write this for loop in 3 lines in C++ or Python...
            // and I am really suspect that I would forget the Stream or Map methods in Tech Interviews.
            String nstr = s.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
            if (map.containsKey(nstr)) {
                System.out.println("caonima");
                map.get(nstr).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(nstr, l);
            }
        }
        
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
}
