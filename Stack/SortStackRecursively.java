import java.util.Stack;

public class SortStackRecursively {
    public static void main(String[] args) {
        /*
         * input=11 2 32 3 41 Output: 41 32 11 3 2
         */
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);

        s.push(32);
        s.push(3);
        s.push(41);
        System.out.println(s);
        s = sort(s);
        System.out.println(s);

    }

    public static void insert(Stack<Integer> s, int ele) {
        if (s.size() == 0 || s.peek() <= ele) {
            s.push(ele);
            return;
        }
        int top = s.pop();
        insert(s, ele);
        s.push(top);
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.size() == 1) {
            return s;
        }
        int top = s.pop();
        sort(s);
        insert(s, top);
        return s;
    }
}
