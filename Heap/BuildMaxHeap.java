import java.util.Arrays;

//doesn't work;
public class BuildMaxHeap {
    // I am using Heapify method so that my time complexity becomes O(n) rather than
    // being O(nlon(n))
    public static void main(String[] args) {
        int arr[] = { 5, 3, 2, 9, 4, 6, 1, 8, 7 };
        System.out.println(Arrays.toString(arr));
        buildMaxHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int i, int n) {
        int leftChild = 2 * i;
        int rightChild = 2 * i + 1;
        int largest = i;
        System.out.println("n, right, left=" + n + " " + rightChild + " " + leftChild);
        if (leftChild < n && arr[largest] < arr[leftChild]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[largest] < arr[rightChild]) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }

    static void buildMaxHeap(int[] num, int n) {
        int[] arr = new int[num.length + 1];
        n = n + 1;
        arr[0] = -1;
        int index = 1;
        for (int i : num) {
            arr[index++] = i;
        }
        for (int i = n / 2; i > 1; i--) {
            heapify(num, i, n - 1);
        }

        System.out.println("len arr=" + arr.length + " len num=" + num.length);

        System.out.println("Heap" + Arrays.toString(arr));

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}