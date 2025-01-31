package bitmanipulation;

import java.util.HashSet;

public class LC898BitWiseORs {

    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{1,1,2}));
    }

    public static int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int len = arr.length;
        for(int i= 0; i<len; i++){
            int tempXor = 0;
            for(int j=i; j<len; j++){
                tempXor= tempXor ^ arr[j];
                hs.add(tempXor);
            }
        }



        return hs.contains(0)?hs.size()-1 : hs.size();
    }
}
