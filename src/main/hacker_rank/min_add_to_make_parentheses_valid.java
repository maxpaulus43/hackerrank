public class min_add_to_make_parentheses_valid {
    public static void main(String[] args) {

    }

    public int minAddToMakeValid(String s) {
        int opened = 0;
        int unclosed = 0;


        for (char c : s.toCharArray()) {
            if (c == '(') {
                opened++;
            } else if (c == ')') {
                if (opened == 0) {
                    unclosed++;
                } else {
                    opened--;
                }
            }
        }

        return opened + unclosed;
    }
}
