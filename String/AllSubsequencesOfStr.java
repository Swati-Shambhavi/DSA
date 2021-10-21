public class AllSubsequencesOfStr {
    public static void main(String[] args) {
        String s = "abc";
        printSubsequence(s, "");
    }

    static void printSubsequence(String in, String out) {
        if (in.length() == 0) {
            System.out.println(out);
            return;
        }
        String out1 = out;
        String out2 = out;
        out2 += in.charAt(0);
        in = in.substring(1, in.length());
        printSubsequence(in, out1);
        printSubsequence(in, out2);
        return;
    }
}