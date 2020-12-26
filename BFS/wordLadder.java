class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        // add words into set
        for (String word : wordList) {
            dict.add(word);
        }
        
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        HashSet<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        hash.add(beginWord);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict. contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}