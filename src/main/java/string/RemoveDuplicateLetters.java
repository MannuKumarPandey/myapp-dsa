package string;

import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {

        HashSet<Character> hs = new HashSet<Character>();

        Stack<Character> stack = new Stack<Character>();

        char[] arr = s.toCharArray();

        for(int i = 0; i<arr.length; i++){
            if(!hs.contains(arr[i])){
                if(!stack.isEmpty()){
                    if(stack.peek() >= arr[i]){
                        stack.pop();
                        stack.push(arr[i]);
                        hs.add(arr[i]);
                    }
                }else{
                    stack.push(arr[i]);
                    hs.add(arr[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
