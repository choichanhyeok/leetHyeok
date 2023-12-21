import java.util.EmptyStackException;

class MinStack {
    private final Stack<Integer> mainStack;
    private final Stack<Integer> subStack;
    int test;
    public MinStack() {
        mainStack = new Stack<>();
        subStack = new Stack<>();
    }
    
    public void push(int value) {
        mainStack.push(value);
        if (subStack.isEmpty() || value <= subStack.peek()){
            subStack.push(value);
        }
    }
    
    public void pop() {
        if(!mainStack.isEmpty()){
            int value = mainStack.pop();
            if (value == subStack.peek()){
                subStack.pop();
            }
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        if (!subStack.isEmpty()) {
            return subStack.peek();
        }
        throw new EmptyStackException();    
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */