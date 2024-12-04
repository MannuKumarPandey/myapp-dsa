package DSA200HARD;

import java.util.ArrayList;
import java.util.List;

public class L68TextJustifications {
    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).toString());
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int currentLength = 0;
        int numWords = 0;
        List<String> line = new ArrayList<>();

        for (String word : words) {
            if (currentLength + word.length() + numWords <= maxWidth) { // jab tak specific line me add ho rahi word ka length maxWidth se kam ho
                line.add(word);
                currentLength += word.length();
                numWords++;
            } else {
                // Form a line
                result.add(justifyLine(line, maxWidth, currentLength, numWords)); // call justifyLine to format the line with spaces distribution
                line = new ArrayList<>(); //jab wo line result me jut gya tab fir se usko reset kar diya
                line.add(word); // aa rahi word iteration se usko naye line me add ke liye dale
                currentLength = word.length();
                numWords = 1;
            }
        }

        // Handle the last line: line variable will keep the last line string
        String lastLine = String.join(" ", line);//matlab line list me jitane words hai sabko " " se join karke string banakar de
        int padding = maxWidth - lastLine.length();
        lastLine += " ".repeat(padding);
        result.add(lastLine);

        return result;
    }

     /*currentLength : me us line add ho rahe sare words ka actual length rakha hua hai
     numWords :me us line add ho rahe sare words ka actual count rakha hua hai
    maxWidth : me total max characters can be present in that line ka info rakha hua hai
    line : list of all the words which will form the line*/

    private static String justifyLine(List<String> line, int maxWidth, int currentLength, int numWords) {
        if (numWords == 1) {
            // Single word on the line, left-justify
            return String.format("%-" + maxWidth + "s", line.get(0));
        }

        int totalSpaces = maxWidth - currentLength; //total spaces jo add karni padegi
        int spacesBetweenWords = numWords - 1; // wo spaces jo words ke bich me add karni padegi
        int extraSpaces = totalSpaces % spacesBetweenWords; //yha spacesBetweenWords se mod lene se ye pta chal gya ki kitani esi extra spaces hogi jisko settle karna padega

        int spaces = totalSpaces / spacesBetweenWords; //actual spaces jisko us words ke bich me add kar denge

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size() - 1; i++) {
            sb.append(line.get(i)); // ith string add karne ke bad
            sb.append(" ".repeat(spaces)); //spaces ke value jitani empty space add kar diya
            if (extraSpaces > 0) { // agar extra spaces 0 se jyada hai to left wale gap me add kar diya
                sb.append(" ");
                extraSpaces--;
            }
        }
        sb.append(line.get(line.size() - 1));

        return sb.toString();
    }
}
