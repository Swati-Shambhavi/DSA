import java.util.ArrayList;
// import java.util.HashMap;

/*
Common elements 
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function commonElements() which take the 3 arrays A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and returns an array containing the common element present in all the 3 arrays in sorted order. 
If there are no such elements return an empty array. In this case the output will be printed as -1.

Expected Time Complexity: O(n1 + n2 + n3)
Expected Auxiliary Space: O(n1 + n2 + n3) 
*/

public class CommonElementIn3SortedArray {
    public static void main(String[] args) {
        int[] A = { 1, 5, 10, 20, 40, 80 }, B = { 6, 7, 20, 80, 100 }, C = { 3, 4, 15, 20, 30, 70, 80, 120 };
        // int[] A = { 3, 3, 3, }, B = { 3, 3, 3 }, C = { 3, 3, 3, };
        System.out.println(commonElements(A, B, C, A.length, B.length, C.length));
    }

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> common = new ArrayList<>(n1 + n2 + n3);

        // 2nd Solution;
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (A[i] == B[j] && A[i] == C[k]) {
                boolean alreadyPresent = common.contains(A[i]);
                if (!alreadyPresent) {
                    common.add(A[i]);
                }
            }
            if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }

        // 1st SOlution; Space= O(n1+n2+n3)
        // HashMap<Integer, Boolean> a = new HashMap<>();
        // HashMap<Integer, Boolean> b = new HashMap<>();
        // HashMap<Integer, Boolean> c = new HashMap<>();
        // for (int i = 0; i < n1; i++) {
        // a.put(A[i], true);
        // }
        // for (int i = 0; i < n2; i++) {
        // b.put(B[i], true);
        // }
        // for (int i = 0; i < n3; i++) {
        // c.put(C[i], true);
        // }
        // for (int i = 0; i < n1; i++) {
        // int curr = A[i];
        // if (a.containsKey(curr) && b.containsKey(curr) && c.containsKey(curr)) {
        // boolean alreadyPresent = common.contains(A[i]);
        // if (!alreadyPresent) {
        // common.add(A[i]);
        // }
        // }
        // }
        return common;
    }
}
