package stack;

import java.util.Stack;

public class MonotonicDecreasingStack {

    static Stack<Integer> os = new Stack<>();
    static Stack<Integer> ms = new Stack<>();


    public static void main(String[] args) {
        add(10);
        add(50);
        add(1);
        System.out.println(get());
    }


    public static int get() {
        if (!ms.isEmpty()) {
            return ms.peek();
        }
        return -1;
    }

    public static void delete() {
        os.pop();
        ms.pop();
    }


    public static void add(int data) {
        os.push(data);
        if (!ms.isEmpty()) {
            ms.push(Math.min(ms.peek(), data));
        } else {
            ms.push(data);
        }

    }
}
