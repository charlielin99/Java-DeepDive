class Solution {

    //The idea is to keep string builder and appending until the length A is greater or equal to B.
public int repeatedStringMatch(String A, String B) {
    int count = 0;
    StringBuilder sb = new StringBuilder();
    while (sb.length() < B.length()) {
        sb.append(A);
        count++;
    }
    if(sb.toString().contains(B)) return count;
    if(sb.append(A).toString().contains(B)) return ++count;
    return -1;
}
}