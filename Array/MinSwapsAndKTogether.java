public class MinSwapsAndKTogether {
    public static void main(String[] args) {
        // int arr[] = { 2, 1, 5, 6, 3 };
        // int k = 3; // ans=1
        int arr[] = { 10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1 };
        int k = 1; // ans=1; my ans=2
        System.out.println(minSwap(arr, arr.length, k));
    }

    public static int minSwap(int arr[], int n, int k) {
        int swap = 0;
        int nextMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                i++;
            } else {
                nextMin = i;
                break;
            }
        }
        System.out.println(nextMin);
        // int i = nextMin + 1;
        int i = 0;
        while (i < n) {
            if (arr[i] <= k && i != nextMin && nextMin < n) {
                int temp = arr[i];
                arr[i] = arr[nextMin];
                arr[nextMin] = temp;
                nextMin++;
                swap++;
            }
            i++;
        }
        return swap;
    }
}
