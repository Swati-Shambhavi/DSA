
// import java.util.ArrayList;
import java.util.Arrays;

// Input: arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
// output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
public class ArrangeAlternalePosneg {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, -4, -1, 4 };
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

        System.out.println("Original=" + Arrays.toString(arr));
        arrange(arr);
        System.out.println("Answer=" + Arrays.toString(arr));
    }

    static boolean isEven(int i) {
        return i % 2 == 0;
    }

    static void rotate(int[] arr, int start, int end, int n) {

        int temp = arr[end];
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
    }

    static void arrange(int[] arr) {

        // Solution 2; Space= O(1)

        // Input: arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
        // output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
        //
        int index = 0;
        int misplaced = -1;
        while (index < arr.length) {
            if (misplaced >= 0) {
                if ((arr[index] >= 0 && isEven(index)) || (arr[index] < 0 && !isEven(index))) {
                    rotate(arr, misplaced, index, arr.length);
                    if ((index - misplaced) >= 2) {
                        misplaced += 2;
                    } else {
                        misplaced = -1;
                    }
                }
            }
            if (misplaced == -1) {
                if ((arr[index] >= 0 && isEven(index)) || (arr[index] < 0 && !isEven(index))) {
                    misplaced = index;
                }
            }
            index++;
        }
        // Solution 1: SPace=> (n)
        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> neg = new ArrayList<>();
        // int lenPos = 0, lenNeg = 0;
        // for (int i = 0; i < arr.length; i++) {
        // if (arr[i] < 0) {
        // neg.add(arr[i]);
        // lenNeg++;
        // } else {
        // pos.add(arr[i]);
        // lenPos++;
        // }
        // }
        // int i = 0, j = 0, k = 0;
        // while (i < lenNeg && j < lenPos) {
        // if (k % 2 == 0) {
        // if (j > lenNeg - 1) {
        // break;
        // } else {
        // arr[k++] = neg.get(j);
        // j++;
        // }
        // } else {
        // if (i > lenPos - 1) {
        // break;
        // } else {
        // arr[k++] = pos.get(i);
        // i++;
        // }
        // }
        // }
        // if (i > lenPos - 1) {
        // while (j < lenNeg) {
        // arr[k++] = neg.get(j);
        // j++;
        // }
        // } else {
        // while (i < lenPos) {
        // arr[k++] = pos.get(i);
        // i++;
        // }
        // }

    }

}
