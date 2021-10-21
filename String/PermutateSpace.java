import java.util.ArrayList;

public class PermutateSpace {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(permutation(s));
    }

    static ArrayList<String> permutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        String out = s.substring(0, 1);
        String in = s.substring(1);
        ans = action(in, out, ans);
        return ans;
    }

    static ArrayList<String> action(String in, String out, ArrayList<String> ans) {
        if (in.length() == 0) {
            ans.add(out);
            return ans;
        }
        String out1 = out;
        String out2 = out;
        out1 += " " + in.charAt(0);
        out2 += in.charAt(0);
        in = in.substring(1);
        action(in, out1, ans);
        action(in, out2, ans);
        return ans;
    }
}
