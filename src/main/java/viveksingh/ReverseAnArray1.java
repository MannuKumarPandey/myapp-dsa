package viveksingh;

import java.util.Arrays;

public class ReverseAnArray1 {

    public static void main(String[] args) {
        //1 way
        //TC: O(n)
        //SC : O(n) because we are using result[]
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = arr.length;//O(1) unit
        int[] result = new int[len];//input length ke barabar ki ek memory extra use me
                                    // layi gayi is vajah se iski space complexity bhi O(n) ho gayi
        int ip = 0;//O(1) 1 unit
        int op = len - 1; //O(1) unit
        //1+ n+ 1+1=====> constant ko neglect kar dete hai aur sirf function wale term ko rakhte hai
        for (ip = 0; ip < len; ip++) {
            result[op - ip] = arr[ip];
        }
        System.out.println(Arrays.toString(result));
    }
}
