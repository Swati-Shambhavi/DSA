import java.util.HashSet;
import java.util.Set;

public class UnionOf2Arr {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 1, 2, 3 };
        System.out.println(union(a, a.length, b, b.length));
    }

    static int union(int[] a, int n, int[] b, int m) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        Set<Integer> un = new HashSet<>();
        int len = n > m ? n : m;
        for (int i = 0; i < len; i++) {
            if (i < m) {
                un.add(b[i]);
            }
            if (i < n) {
                un.add(a[i]);
            }
        }
        return un.size();
    }
}
