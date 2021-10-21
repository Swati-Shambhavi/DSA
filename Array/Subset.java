import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<List<Integer>> in = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            in.add([nums[i]]);
        }
        create(in, out);
        return out;
    }

    public static void create(List<List<Integer>> in, List<List<Integer>> out) {
        if (in.size() == 0) {
            out.add(in);
            return;
        }
    }
}