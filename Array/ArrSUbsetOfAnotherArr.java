import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrSUbsetOfAnotherArr {
    public static void main(String[] args) {
        // long a1[] = { 11, 1, 13, 21, 3, 7 }, a2[] = { 11, 3, 7, 1 };
        // long a1[] = { 10, 5, 2, 23, 19 }, a2[] = { 19, 5, 3 };
        // 818,273
        long a1[] = new long[273];
        long a2[] = new long[818];

        System.out.println(isSubset(a1, a2, a1.length, a2.length));
    }

    public static String isSubset(long a1[], long a2[], long n, long m) {
        Set<Long> set = new HashSet<>();
        if (m > n) {
            return "No";
        }
        // Boolean is1stLarger = n >= m ? true : false;

        for (int i = 0; i < n; i++) {
            set.add(a1[i]);
        }
        int j = 0;
        while (j < m) {
            if (set.contains(a2[j])) {
                j++;
            } else {
                return "No";
            }

        }
        return "Yes";
    }
}
