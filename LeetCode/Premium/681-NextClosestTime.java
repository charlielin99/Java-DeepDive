/*
Thought
There is nothing special about the idea, that is, the "deductive method." I want to know how to get the minimum time larger than the current time. Because you need to be as small as possible, scan from the end of the time string to the front to see if each scale is likely to change, because the beginning is a more significant position.
When scanning, you need to see if you can make the digit of the current scale larger. Of course, you need the digit of the reuse input. If it can be changed, all positions on the left side of the changed position remain unchanged.
Another thing to note is that the range limit of each digit position in the timestamp string is different. For example, the first digit can only be '0', '1', '2'; the last digit can be ‘0’-‘9’
Note that when you find that the value of a digit cannot be increased, you should take the smallest digit possible, instead of leaving it as it is. Thus, after the digit on the left side becomes larger, the new timestamp obtained is as small as possible. If all digits are unlikely to become large, then the time to be found is "next day", then each digit is as small as possible and the "minimum" timestamp is met.
*/

class Solution {
    public String nextClosestTime(String time) {
        HashSet<Character> digits = new HashSet();
        for(int i = 0; i < 5; i ++) {
            if(i != 2) digits.add(time.charAt(i));
        }

        boolean increased = false; // means if one of digit changed to closest bigger one
        StringBuilder rst = new StringBuilder();

        for(int i = 4; i >= 0; --i) { // insert char to result from back to begin
            char tmp = time.charAt(i);

            if(i != 2 && !increased) {
                // limit is upper bound of char value we can insert to result for current position
                char limit = '9';
                if(i == 3) limit = '5';
                else if (i == 1) limit = time.charAt(0) == '2' ? '3' : '9';
                else if (i == 0) limit = '2';

                if(tmp < limit) {
                    tmp ++;
                    for(char c = tmp; c <= limit; c ++) { // add first valid bigger char value
                        if(digits.contains(c)) {
                            rst.insert(0, c);
                            increased = true;
                            break;
                        }
                    }
                }

                // append smallest char if not changed
                if(!increased) {
                    for(char c = '0'; c <= '9'; c ++) {
                        if(digits.contains(c)) {
                            rst.insert(0, c);
                            break;
                        }
                    }
                }
            } else rst.insert(0, tmp);
        }
        return rst.toString();
    }
}