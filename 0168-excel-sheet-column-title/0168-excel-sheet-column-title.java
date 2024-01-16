// Time Complex: O(logn)

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder answerWord = new StringBuilder();
        
        while (columnNumber > 0){
            columnNumber --;
            char currentChar = (char)('A' + (columnNumber % 26));
            answerWord.insert(0, currentChar);
            columnNumber /= 26;
        }
        
        return answerWord.toString();
    }
}
