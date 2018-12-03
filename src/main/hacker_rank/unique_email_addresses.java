import java.util.HashSet;
import java.util.Set;

public class unique_email_addresses {

    public static void main(String[] args) {
        new unique_email_addresses().numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        });
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String e : emails) {
            emailSet.add(process(e));
        }

        return emailSet.size();
    }

    String process(String email) {
        int plusSign = email.indexOf('+');
        String localName = email.substring(0, plusSign).replace(".", "");
        String domainName = email.substring(email.indexOf('@'));
        return localName + domainName;
    }
}
