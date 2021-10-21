import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        int ans = findTheWinner(6, 5);
        System.out.println(ans);
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(i + 1);
        }
        int ans = helper(0, k - 1, people);

        return ans;
    }

    static int helper(int gun, int k, List<Integer> p) {
        if (p.size() == 1) {
            return p.get(0);
        }
        int nextToDie = (gun + k) % p.size();
        p.remove(nextToDie);
        return helper(nextToDie, k, p);

    }
}
