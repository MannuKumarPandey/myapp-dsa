package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC140WordBreak2 {

    public static void main(String[] args) {
        List<String> wordDict = List.of("cat","cats","and","sand","dog");
        String inputString = "catsanddog";
        System.out.println(wordBreak(inputString,wordDict));

    }

    public static List<String> wordBreak(String inputString, List<String> wordDict) {
        //wordDict ko set me convert kar liya taki searching O(1) me ho jaye
        Set<String> inputDictionary = new HashSet<>(wordDict);
        //final answer rakhne ke liye ek nya List bnaya
        List<String> finalAns = new ArrayList<>();

        //Temporary list rakhne ke liye ek nya list bnaya
        List<String> tempAns = new ArrayList<>();
        //helper function call kiya
        helper(inputString, 0, inputDictionary, tempAns, finalAns);
        return finalAns;
    }



    private static void helper(String inputString, int i, Set<String> inputDictionary, List<String> tempAns, List<String> finalAns) {
        if (i == inputString.length()) {
            // yha temporary list me jo details ayi hai string ki
            //usase ek string bnani hai jo final ans list me add hogi
            if (tempAns.size() > 0) {
                StringBuilder sb = new StringBuilder();
                ///jitane strings hai temp Result me un sabke liye ek bar iteration lagegi
                for (int j = 0; j < tempAns.size(); j++) {
                    //har ek us string ke liye jo index 0 ke bad ki hogi temp list me se
                    //uske paahle ek space add karenge
                    if (j > 0) {
                        sb.append(' ');
                    }
                    sb.append(tempAns.get(j));
                }
                //yha final ans list me us prepared String ko add karenge
                finalAns.add(sb.toString());
            }
            return;
        }
        //yha loop ka end point equal to length rakha hua hai because jab substring lenge tab right
        //part execlude ho jata hai

        //yah loop pahle first word jo set me hoga usko pick karke temp result me add kar dega and wapis
        //recursive call karega ap us index se jha tak substring bani hui thi
        for (int j = i + 1; j <= inputString.length(); j++) {
            if (inputDictionary.contains(inputString.substring(i, j))) {
                tempAns.add(inputString.substring(i, j));//adding current element to tempRes
                //ab jo call ho rahi hai wo us index se start hogi jha tak sub string mila hua thaand set me tha
                helper(inputString, j, inputDictionary, tempAns, finalAns);
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }
}
