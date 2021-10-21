import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(333);
        s.push(90);
        s.push(32);
        s.push(3);
        s.push(41);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }

    static void insert(Stack<Integer> s, int ele) {
        if (s.size() == 0) {
            s.push(ele);
            return;
        }
        int top = s.pop();
        insert(s, ele);
        s.push(top);
        return;
    }

    static void reverse(Stack<Integer> s) {
        if (s.size() == 1) {
            return;
        }
        int curr = s.pop();
        reverse(s);
        insert(s, curr);
        return;
    }
}
