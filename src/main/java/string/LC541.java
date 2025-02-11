package string;

public class LC541 {
    public static void main(String[] args) {
      //  System.out.println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
       System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcd", 2));
    }
    public static String reverseStr(String s, int k) {

        String result =s;
        int length = s.length();
        if(length < k){
            return reverse(s, 0, length);
        }
        int flag = 0;
        int start = 0;
        while(start+k < length){
            if(flag % 2 == 0){
                result = reverse(result, start, start+k);
                start = start+k;
                flag = flag + 1;
            }else{
                start = start+k;
                flag = flag + 1;
            }

        }
        if(flag % 2 == 0){
            result = reverse(result, k, length);
        }

        return result;

    }

    public static String reverse(String s, int start ,int end){
        //end index is getting treat as exclusive
        char arr[] = s.toCharArray();

        int i = start;
        int j = end-1;
        while(i<=j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

}
