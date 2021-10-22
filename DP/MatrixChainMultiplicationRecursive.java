public class MatrixChainMultiplicationRecursive {
    public static void main(String[] args) {
        int arr[] = { 40, 20, 30, 10, 30 };
        System.out.println(matrixMultiplication(arr.length, arr));
    }

    static int matrixMultiplication(int n, int arr[]) {
        return solve(arr, 1, n - 1);
    }

    static int solve(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            // at every value of k, 2 temperary ans will be calculated recursively and then
            // the main tempary answer is calculate based on both the answers; three answers
            // are seperated by +
            // we will find a potential answer at every k and then in the end return the
            // most suitable one
            int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            // The above code is equivalent to the below code
            // int leftAnsBeforeK = solve(arr, i, k);
            // int rightAnsAfterK = solve(arr, k + 1, j);
            // int combiningTwoAns = arr[i - 1] * arr[k] * arr[j];
            // int tempAns = leftAnsBeforeK + rightAnsAfterK + combiningTwoAns;

            minAns = Math.min(minAns, tempAns);
        }
        return minAns;
    }
}
