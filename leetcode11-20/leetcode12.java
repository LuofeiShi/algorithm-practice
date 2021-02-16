class Solution {
    public String intToRoman(int num) {
        //analyze how the law of the trasmission.
        if (num == 0) {
            return "";
        }
        
        // 1 <= num <= 3999
        int[] values = new int[] {1000, 
                                  900, 500, 400, 100, 
                                  90, 50, 40, 10, 
                                  9, 5, 4, 1};
        
        String[] reps = new String[] {
            "M", 
            "CM", "D", "CD", "C", 
            "XC", "L", "XL", "X", 
            "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 12 && num >= 0; i++) {
            while (num >= values[i]) {
                System.out.println(num);
                num -= values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }
}
