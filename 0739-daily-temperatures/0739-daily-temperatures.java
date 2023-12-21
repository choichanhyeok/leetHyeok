class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i ++){
            while (top > -1 && temperatures[i] > temperatures[stack[top]]){
                int prevDay = stack[top--];
                answer[prevDay] = i - prevDay;
            }
            stack[++top] = i;
        }
        
        return answer;
    }
}