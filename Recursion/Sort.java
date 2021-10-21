import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 6, 1, 2, 9, 8, 5, 3 };
        List<Integer> list = new ArrayList<>();
        for (int integer : arr) {
            list.add(integer);
        }
        sortRecursively(list);
        System.out.println(list);
    }

    static void insert(List<Integer> list, int element) {
        if (list.size() == 0 || list.get(list.size() - 1) <= element) {
            list.add(element);
            return;
        }
        int last = list.remove(list.size() - 1);
        insert(list, element);
        list.add(last);
        return;
    }

    static void sortRecursively(List<Integer> list) {
        if (list.size() == 1) {
            return;
        }
        int last = list.remove(list.size() - 1);
        sortRecursively(list);
        insert(list, last);
    }

}