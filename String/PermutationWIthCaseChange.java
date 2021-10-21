import java.util.ArrayList;
import java.util.List;

public class PermutationWIthCaseChange {
    public static void main(String[] args) {
        String s = "a1B2";

        // String s = "C";
        permutateWIthCaseChange(s);
    }

    static void permutateWIthCaseChange(String s) {
        List<String> ans = new ArrayList<>();
        ans = helper(s, "", ans);
        System.out.println(ans);

    }

    static List<String> helper(String in, String out, List<String> ans) {
        if (in.length() == 0) {
            ans.add(out);
            return ans;
        }
        char curr = in.charAt(0);
        curr = Character.isUpperCase(curr) ? Character.toLowerCase(curr) : Character.toUpperCase(curr);
        if ((curr >= 'a' && curr <= 'z') || (curr >= 'A' && curr <= 'Z')) {
            String out1 = out, out2 = out;
            out1 = out1 + curr;
            out2 = out2 + in.charAt(0);
            in = in.substring(1);
            helper(in, out1, ans);
            helper(in, out2, ans);
        } else {
            String out1 = out;
            out1 += in.charAt(0);
            in = in.substring(1);
            helper(in, out1, ans);
        }

        return ans;

    }
}
