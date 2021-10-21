/*

Print N-bit binary numbers having more 1’s than 0’s in all prefixes
Difficulty Level : Medium
Last Updated : 16 Jul, 2021
Given a positive integer n, print all n-bit binary numbers having more 1’s than 0’s for any prefix of the number.*/
public class NbitBinaryNumHavingMore1than0inAllPrefixes {
    public static void main(String[] args) {
        int n = 4;
        generateBinary(n, 0, 0, "");
    }

    static void generateBinary(int n, int one, int zero, String ans) {
        if (n == 0) {
            System.out.print(ans + " ");
            return;
        }
        // we are adding zero only if number of 0 is less than 1
        if (zero < one) {
            String out = ans;
            out += '0';
            generateBinary(n - 1, one, zero + 1, out);
        }
        String out = ans;
        out += '1';
        generateBinary(n - 1, one + 1, zero, out);
    }
}
