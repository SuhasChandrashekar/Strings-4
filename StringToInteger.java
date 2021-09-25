// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s == null || s.length() == 0)
            return 0;
        int result = 0;
        char sign = '+';
        
        if(s.charAt(0) != '+' && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0)))
           return 0;
        
        if(s.charAt(0) == '-')
            sign = '-';
        
        int limit = Integer.MAX_VALUE / 10;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                if(sign == '+' && ( result > limit  || (result == limit && (c -'0') > 7))){
                    return Integer.MAX_VALUE;
                }
                if(sign == '-' && ( result > limit  || (result == limit && (c -'0') > 8))){
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + (c -'0');
            }
            else if(i != 0)
                break;
        }
        if(sign == '-')
            return -result;
        else
            return result;
    }
}