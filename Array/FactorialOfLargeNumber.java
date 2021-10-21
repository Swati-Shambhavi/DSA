import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FactorialOfLargeNumber {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(factorial(num));
    }

    static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> fact = new ArrayList<>();
        int[] res = new int[50];
        // int size = 1;
        res[0] = 1;
        fact.add(1);
        int sizef = 1;
        for (int i = 2; i <= n; i++) {
            // size = multiply(res, size, i);
            sizef = multiply(fact, sizef, i);
        }
        Collections.reverse(fact);
        System.out.println("\n" + fact);
        return fact;
    }

    static int multiply(ArrayList<Integer> fact, int size, int n) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int prod = fact.get(i) * n + carry;
            fact.add(i, prod % 10);
            carry = prod / 10;
        }
        while (carry != 0) {
            fact.add(size, carry % 10);
            carry = carry / 10;
            size++;
        }
        return size;
    }

    static int multiply(int[] arr, int size, int n) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int prod = arr[i] * n + carry;
            arr[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry != 0) {
            arr[size] = carry % 10;
            carry = carry / 10;
            size++;
        }
        return size;

    }
}

// // JAVA program to compute factorial
// // of big numbers
// class GFG {

// // This function finds factorial of
// // large numbers and prints them
// static void factorial(int n) {
// int res[] = new int[500];

// // Initialize result
// res[0] = 1;
// int res_size = 1;

// // Apply simple factorial formula
// // n! = 1 * 2 * 3 * 4...*n
// for (int x = 2; x <= n; x++)
// res_size = multiply(x, res, res_size);

// System.out.println("Factorial of given number is ");
// for (int i = res_size - 1; i >= 0; i--)
// System.out.print(res[i]);
// }

// // This function multiplies x with the number
// // represented by res[]. res_size is size of res[] or
// // number of digits in the number represented by res[].
// // This function uses simple school mathematics for
// // multiplication. This function may value of res_size
// // and returns the new value of res_size
// static int multiply(int x, int res[], int res_size) {
// int carry = 0; // Initialize carry

// // One by one multiply n with individual
// // digits of res[]
// for (int i = 0; i < res_size; i++) {
// int prod = res[i] * x + carry;
// res[i] = prod % 10; // Store last digit of
// // 'prod' in res[]
// carry = prod / 10; // Put rest in carry
// }

// // Put carry in res and increase result size
// while (carry != 0) {
// res[res_size] = carry % 10;
// carry = carry / 10;
// res_size++;
// }
// return res_size;
// }

// // Driver program
// public static void main(String args[]) {
// factorial(100);
// }
// }
// // This code is contributed by Nikita Tiwari
