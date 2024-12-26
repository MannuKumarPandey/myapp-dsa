package string;

public class RotateStringToMatchGoal {

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "bcdea";

        String s1 = "gcmbf";
        String goal1 = "fgcmb";

        //Either the goal is i n right or left roration, It will work fine

        System.out.println(s.length() == goal.length() && (s + s).contains(goal));
        System.out.println(s1.length() == goal1.length() && (s1 + s1).contains(goal1));

    }
}
