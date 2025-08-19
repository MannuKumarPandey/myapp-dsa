package viveksingh;

import java.util.Stack;

public class StackKthElement {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        stack1.push(100);
        stack1.push(200);
        stack1.push(300);
        //====================================================
        //count nikal rha hu ki kitane elements hai
        /*System.out.println(stack1);
        Stack<Integer> stack2 = new Stack<>();
        int count = 0;
        while(!stack1.isEmpty()){
            count++;
            int poppedElement = stack1.pop();
            stack2.push(poppedElement);
        }

        System.out.println(count);
        System.out.println(stack2);
        while(!stack2.isEmpty()){
            int poppedElement = stack2.pop();
            stack1.push(poppedElement);
        }
        System.out.println(stack1);*/

        //==================================================
        //max nikal rha hu stack me se
        /*int max = 0;
        System.out.println(stack1);
        Stack<Integer> stack2 = new Stack<>();
        int count = 0;
        while(!stack1.isEmpty()){
            int poppedElement = stack1.pop();
            max = Math.max(poppedElement, max);
            stack2.push(poppedElement);
        }

        System.out.println(count);
        System.out.println(stack2);
        while(!stack2.isEmpty()){
            int poppedElement = stack2.pop();
            stack1.push(poppedElement);
        }
        System.out.println(stack1);*/


        //==================================================
        //min nikal rha hu stack me se
       /* int min = 0;
        System.out.println(stack1);
        Stack<Integer> stack2 = new Stack<>();
        int count = 0;
        while(!stack1.isEmpty()){
            int poppedElement = stack1.pop();
            min = Math.min(poppedElement, min);
            stack2.push(poppedElement);
        }

        System.out.println(count);
        System.out.println(stack2);
        while(!stack2.isEmpty()){
            int poppedElement = stack2.pop();
            stack1.push(poppedElement);
        }
        System.out.println(stack1);*/





        //==================================================
        //total sum nikal rha hu stack me se
        /*int sum  = 0;
        System.out.println(stack1);
        Stack<Integer> stack2 = new Stack<>();
        int count = 0;
        while(!stack1.isEmpty()){
            int poppedElement = stack1.pop();
            sum = sum + poppedElement;
            stack2.push(poppedElement);
        }

        System.out.println(count);
        System.out.println(stack2);
        while(!stack2.isEmpty()){
            int poppedElement = stack2.pop();
            stack1.push(poppedElement);
        }
        System.out.println(stack1);*/


        //==================================================
        //total multiplication nikal rha hu stack me se
        /*int mult  = 1;
        System.out.println(stack1);
        Stack<Integer> stack2 = new Stack<>();
        int count = 0;
        while(!stack1.isEmpty()){
            int poppedElement = stack1.pop();
            mult = mult * poppedElement;
            stack2.push(poppedElement);
        }

        System.out.println(count);
        System.out.println(stack2);
        while(!stack2.isEmpty()){
            int poppedElement = stack2.pop();
            stack1.push(poppedElement);
        }
        System.out.println(stack1);*/

        //==================================================
        //reverse of a stack into another

        System.out.println(stack1);
        Stack<Integer> stack2 = new Stack<>();
        while(!stack1.isEmpty()){
            int poppedElement = stack1.pop();
            stack2.push(poppedElement);
        }
        System.out.println(stack2);


    }
}
