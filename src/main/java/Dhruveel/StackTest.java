package Dhruveel;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack stack1 = new Stack();// we have not used generics here
        stack1.push(1000);
        stack1.push("abc");
        stack1.push(true);
        System.out.println(stack1);


        //mandatory to store only Integer data type
        //getting compile time error here
        Stack<Integer> stack2 = new Stack<Integer>();
        stack2.push(1000);
        /*stack2.push("abc");
        stack2.push(true);
        System.out.println(stack2);*/
    }
}
