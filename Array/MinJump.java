// static int minJumps(int[] arr) {
//     int jump = 1, steps = arr[0], i, temp = arr[0];
//     if (steps == 0) {
//         return -1;
//     }
//     for (i = 1; i < arr.length; i++) {
//         steps--;
//         temp--;
//         if (i == arr.length - 1) {
//             return jump;
//         }
//         if (temp < arr[i]) {
//             temp = arr[i];
//         }

//         if (steps == 0) {
//             steps = temp;
//             if (steps == 0) {
//                 return -1;
//             }
//             jump++;
//         }
//     }
//     return jump;
// }
// Q15.
public class MinJump {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }; // ans=3

        // int[] arr = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
        // int[] arr = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 }; // my ans=5; correct ans=4
        System.out.println("Answer=" + minJumps(arr));
    }

    static int minJumps(int[] arr) {
        int jump = 1, carry = arr[0], curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr--;
            carry--;
            if (i == arr.length - 1)
                return jump;
            if (arr[i] > carry) {
                carry = arr[i];
            }
            if (curr == 0) {
                curr = Math.max(carry, arr[i]);
                jump++;
            }

            if (carry == 0 && arr[i] == 0) {
                return -1;
            }

        }
        return jump;
    }

}
