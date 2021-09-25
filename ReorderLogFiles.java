// Time Complexity : O(n log n)
// Space Complexity : O(1)

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] log1Arr = log1.split(" ", 2);
            String[] log2Arr = log2.split(" ", 2);
            boolean isLog1Digit = Character.isDigit(log1Arr[1].charAt(0));
            boolean isLog2Digit = Character.isDigit(log2Arr[1].charAt(0));
            if(!isLog1Digit && !isLog2Digit) {
                int comp = log1Arr[1].compareTo(log2Arr[1]);
                if(comp == 0){
                    return log1Arr[0].compareTo(log2Arr[0]);
                }
                else
                    return comp;
            }
            else if(!isLog1Digit && isLog2Digit){
                return -1;
            }
            else if(isLog1Digit && !isLog2Digit){
                return 1;
            }
            else
                return 0;
        });
        return logs;
    }
}