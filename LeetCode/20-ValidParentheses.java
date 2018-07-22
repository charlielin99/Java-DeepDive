class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '('){
                myStack.push(')');
            } else if (c == '{'){
                myStack.push('}');
            } else if (c == '['){
                myStack.push(']');
            } else if (myStack.isEmpty() || myStack.pop() != c){
                return false;
            }
        }
        
        return myStack.isEmpty();
    }
}