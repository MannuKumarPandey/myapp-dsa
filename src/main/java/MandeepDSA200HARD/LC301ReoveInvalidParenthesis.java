package MandeepDSA200HARD;

import java.util.*;
public class LC301ReoveInvalidParenthesis {

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));
    }

    public static List<String> removeInvalidParentheses(String s) {
        //final ans rakhne ke liye
        List<String> finalAns=new ArrayList<>();
        ///ans duplicate na rakha jaye
        HashSet<String> set=new HashSet<String>();
        //pahle ye check kar lete hai ki kitane parenthesis ne isko invalid banya tha
        int countOfMinBracketsToBeRemoved=countOfMinBracketsToBeRemoved(s);
        backtrack(s, countOfMinBracketsToBeRemoved,set,finalAns);

        return finalAns;
    }

    public static void backtrack(String s, int countOfMinBracketsToBeRemoved, HashSet<String> set, List<String> finalAns){
       /*agar koi bhi valid String set me hai aur hamara temp string bhi match kare set se
        to wo duplicate ans hoga no need to add that*/
        //set apane under sari valid and invalid strings ko rakh rha hai
        if(set.contains(s)) return;
        //else add that string in set
        set.add(s);

        if(countOfMinBracketsToBeRemoved==0){
            int remove=countOfMinBracketsToBeRemoved(s);
            if(remove==0) finalAns.add(s);
            return;
        }

        for(int i=0;i<s.length();i++){
            //agar kisi bhi index par ( ) ko chhorkar koi dusra charaacter hai tab continue because that will never make string invalid
            if(s.charAt(i)!='(' && s.charAt(i)!=')') continue;
            String L=s.substring(0,i);
            String R=s.substring(i+1);
            /*yha check yah kar rahe hai ki jis index par ham hai agar usko remove kar diye to kya
            iske left ke substring and isase right ke substring add karke koi countOfMinBracketsToBeRemoved ko 0 kar rha hai kya
            so agala iteration ka work un dono string ke left and right substring ke addition par hoga
            countOfMinBracketsToBeRemoved ek kam karke*/
            if(!set.contains(L+R)) backtrack(L+R,countOfMinBracketsToBeRemoved-1,set,finalAns);
        }
    }

    public static int countOfMinBracketsToBeRemoved(String s){
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);

            if(x=='(') stack.push(x);
            else if(x==')'){
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else stack.push(x);
            }
        }
        return stack.size();
    }
}