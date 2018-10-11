public class Solution {
    // time o(n)
    // space o(n)
    // stack based solution
    public String decodeString(String s) {
    if (s == null || s.length() == 0) {
        return s;
    }

    Stack<Integer> countStack = new Stack<>();
    Stack<String> resultStack = new Stack<>();
    char[] strArr = s.toCharArray();
    int count = 0;
    String curResult = "";
    for (int i = 0; i < s.length(); i++) {
        //calculate repeat number
        if (Character.isDigit(strArr[i])) {
            count = count * 10 + (strArr[i] - '0');
        }
        //push previous decoded string into stack
        else if (strArr[i] == '[') {
            countStack.push(count);
            resultStack.push(curResult);
            count = 0;
            curResult = "";
        }
        //start to decode current string
        else if (strArr[i] == ']') {
            int repeat = countStack.pop();
            StringBuilder temp = new StringBuilder(resultStack.pop());
            for (int j = 0; j < repeat; j++) {
                temp.append(curResult);
            }
            curResult = temp.toString();
        }
        //normal character, concat to current string, preparing for decoding
        else {
            curResult += strArr[i];
        }
    }
    return curResult;
}
}