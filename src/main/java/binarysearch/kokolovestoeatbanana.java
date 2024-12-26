package binarysearch;


// Binary Search Over Space
public class kokolovestoeatbanana {
    // some changes are required

    public static void main(String[] args) {

        int[] arr = new int[] { 3, 11, 7, 6 };
        int h = 8;

        // so take the min range as 1 and max boundary as max value from array
        // 1 to 11

        System.out.println(koko(arr, h));

    }

    public static int koko(int[] arr, int h) {
        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

        }

        int p = 1;
        int q = max;

        while (p <= q) {
            int mid = (p + q) / 2;
            int tempRes = 0;
            for (int hh : arr) {
                int t = (int) Math.ceil(hh / mid);
                tempRes =  (tempRes + t);
            }
            if (tempRes <= h) {
                res = Math.min(tempRes, res);
                q = mid - 1;
            } else{
                p = mid+1;
            }
        }
        return res;
    }
}

