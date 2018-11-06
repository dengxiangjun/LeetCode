import java.util.HashSet;
import java.util.Set;

/**
 * description https://leetcode.com/problems/unique-email-addresses/description/
 * <p>
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * <p>
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * <p>
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * <p>
 * If you add periods ('.') between some characters in the local name part of an email address,
 * mail sent there will be forwarded to the same address without dots in the local name.
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * (Note that this rule does not apply for domain names.)
 * <p>
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 * (Again, this rule does not apply for domain names.)
 * <p>
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/10/28 13:05
 **/
public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String a[] = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int res = numUniqueEmails(a);
        System.out.println(res);
    }

    public static int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        Set<String> emailSet = new HashSet<>();
        for (String s : emails) {
            String[] arr = s.split("@");
            char[] localnameArr = arr[0].toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < localnameArr.length; i++) {
                char c = localnameArr[i];
                if (c >= 'a' && c <= 'z') sb.append(c);
                else if (c == '+') break;
            }
            sb.append('@').append(arr[1]);
            emailSet.add(sb.toString());
        }
        return emailSet.size();
    }
}
