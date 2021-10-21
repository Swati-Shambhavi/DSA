import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
     * 22. Generate Parentheses Medium Share Given n pairs of parentheses, write a
     * function to generate all combinations of well-formed parentheses. Example 1:
     * 
     * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"] Example
     * Input: n = 1 Output: ["()"]
     */
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, n, "", ans);
        return ans;
    }

    public static void helper(int opening, int closing, String balanced, List<String> ans) {
        if (opening == 0 && closing == 0) {
            ans.add(balanced);
            return;
        }
        if (opening != 0) {
            String out1 = balanced;
            out1 += '(';
            helper(opening - 1, closing, out1, ans);
        }
        if (closing > opening) {
            String out2 = balanced;
            out2 += ')';
            helper(opening, closing - 1, out2, ans);
        }
        return;
    }
}
