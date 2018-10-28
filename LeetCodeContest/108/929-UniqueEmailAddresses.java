/*
929. Unique Email Addresses
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 

 

Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 

Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
*/

class Solution {
    public int numUniqueEmails(String[] emails) {
        int ret = 0;
        Map<String, Set<String>> map = new HashMap<>();

        for (String s: emails){
            String[] parts = s.split("@");
            StringBuilder sbuilder = new StringBuilder();
            for (char c: parts[0].toCharArray()){
                if (c == '.'){
                    continue;
                }
                if (c == '+'){
                    break;
                }
                sbuilder.append(c);
            }
            parts[0] = sbuilder.toString();
            if (!map.containsKey(parts[0])){
                map.put(parts[0], new HashSet<>());
            }
            map.get(parts[0]).add(parts[1]);
        }

        for (String s: map.keySet()) {
            ret += map.get(s).size();
        }

        return ret;
    }
}

