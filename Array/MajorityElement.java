import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int occurance = map.get(arr[i]);
                map.replace(arr[i], occurance + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int ideal = n / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > ideal) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
