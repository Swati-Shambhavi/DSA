import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegativeNumInEveryWIndowOfSizeK {

    /*
     * Input : N = 5 A[] = {-8, 2, 3, -6, 10} K = 2 Output : -8 0 -6 -6
     */
    public static void main(String[] args) {
        int[] arr = { -8, 2, 3, -6, 10 };
        int k = 2;
        System.out.println(Arrays.toString(arr));
        System.out.println(printFirstNegativeInteger(arr, arr.length, k));
    }

    public static List printFirstNegativeInteger(int arr[], int n, int k) {
        List<Integer> myAns = new ArrayList<>();
        List<Integer> window = new ArrayList<>();
        int start = 0, end = 0;

        // { -8, 2, 3, -6, 10 } k=2
        while (end < n) {
            if (arr[end] < 0)
                window.add(arr[end]);
            if (end - start + 1 < k) {
                end++;
                continue;
            } else if (end - start + 1 == k) {
                if (window.size() == 0) {
                    myAns.add(0);
                    // ans[i++] = 0;
                    start++;
                } else {
                    System.out.println("window= " + window + " ans= " + myAns);
                    myAns.add(window.remove(0));
                    start++;
                }
            }
        }
        return myAns;

    }

}
