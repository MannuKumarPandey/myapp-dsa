package viveksingh;

public class FreqArrayOfString1 {
    public static void main(String[] args) {
        String s1 ="aviveksingh";

        //Surety: all tha character are of small letters
        //matlab ki sirf 26 different characters hi aa sakte hai jo a -> z tak honge

        //Frequency Array: Kisi bhi String me kaun ka character kitani bar present hai uska count

        int[] freqArray = new int[26];
        for(int i=0; i<s1.length(); i++){
            int index = s1.charAt(i)-'a';//char1-char2   ===> ASCII value of char1 - ASCII value of char2
            freqArray[index]++;
        }

    }
}
