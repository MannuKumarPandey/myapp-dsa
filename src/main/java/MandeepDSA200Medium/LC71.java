package MandeepDSA200Medium;

import java.util.Stack;

public class LC71 {


    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        int n=path.length();
        int i=0;

        while(i<n){
            char currChar=path.charAt(i);

            StringBuilder sb=new StringBuilder();
            sb.append(currChar);
            i++;

            while(i<n && currChar!=path.charAt(i)){
                sb.append(path.charAt(i));
                i++;
            }

            if(currChar=='.'){
                if(!stack.isEmpty() && sb.length()==1){
                    stack.pop();
                }
                else if(sb.length()==2){
                    int count=0;
                    while(!stack.isEmpty() && count<2){
                        stack.pop();
                        count++;
                    }
                }
                else{
                    stack.push(sb.toString());
                }
            }

            else if(currChar=='/'){
                if(sb.length()==1){
                    stack.push(sb.toString());
                }
                else if(sb.length()>1){
                    stack.push("/");
                }
            }

            else{
                stack.push(sb.toString());
            }

        }
        if(!stack.isEmpty() && (stack.size()!=1) && (stack.peek().equals("/"))){
            stack.pop();
        }

        StringBuilder sb2=new StringBuilder();
        int nn=stack.size();
        for(int k=0; k<nn;k++){
            sb2.append(stack.pop());
        }

        return sb2.reverse().toString();


    }
}