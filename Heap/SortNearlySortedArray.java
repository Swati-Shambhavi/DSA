
/**
 * Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Input:
First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N

Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortNearlySortedArray {
    // Nearly Sorted Algorithm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 1; j <= t; j++) {
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            arr = sort(arr, n, k);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");

            }
            System.out.println();
        }
        sc.close();
    }

    static int[] sort(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[n];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                ans[index++] = pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll();
        }
        return ans;
    }

}
